package data.database;

import config.ServerConfig;

import java.sql.*;
import java.util.*;

/**
 * Created by kylin on 15/11/24.
 */
public class ConnectionPool extends Thread {

    /* 已经创建但是没有被使用的连接 */
    private Stack unuesdPool = new Stack();

    /* 被线程检测并返回的连接 */
    private Stack returnedPool = new Stack();

    /* 已经取走正在使用的连接 */
    private Map usingPool = new HashMap();

    /* 已创建的连接数目 */
    private int created;

    /* 连接池最大数 */
    private final int MAX_CONNCTION = 100;

    private static final String DB_DRIVER;
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PASSWORD;

    /* 是否需要停止线程 */
    private boolean stopThread = false;

    /* 同步锁对象 */
    private final byte[] createdLock = new byte[0];
    private final byte[] usingLock = new byte[0];
    private final byte[] poolLock = new byte[0];
    private final byte[] returnedPoolLock = new byte[0];

    //单例模式
    private static ConnectionPool connectionPoolInstance;

    static{
        HashMap<String, String> hashMap = ServerConfig.getDatabaseConfig().getParams();
        DB_DRIVER = hashMap.get("dbDriver");
        String dbLocation = hashMap.get("dbLocation");
        String dbUnicode = hashMap.get("dbUnicode");
        String dbEncoding = hashMap.get("dbEncoding");
        DB_URL = dbLocation + "?" + dbUnicode + "&" + dbEncoding;
        DB_USER = hashMap.get("dbUser");
        DB_PASSWORD = hashMap.get("dbPassword");
    }

    private ConnectionPool(){
        //启动线程
        this.start();
    }

    public static ConnectionPool getInstance() {
        if(connectionPoolInstance == null){
            synchronized (ConnectionPool.class){
                if(connectionPoolInstance == null)
                    connectionPoolInstance = new ConnectionPool();
            }
        }
        return connectionPoolInstance;
    }


    public Connection getConnection(String poolname, String caller){
        Connection connection = null;
        //百度得,有待理解
        if (null == caller || caller.length() == 0) {
            StackTraceElement[] callerStackTrace = new Throwable()
                    .getStackTrace();
            caller = callerStackTrace[1].toString();
        }
        //从已经创建但是没有被使用的连接中获取Connection
        try {
            synchronized (poolLock) {
                connection = (Connection) unuesdPool.pop();
            }
        }catch (EmptyStackException e){
            connection = newConnection();
        }
        //成功获得Connection
        if(connection != null){
            synchronized (usingLock){
                usingPool.put(connection,new UsingConnection(connection,caller));
            }
        }
        return connection;
    }

    /**
     * 创建新的数据库连接
     *
     * @return 新的数据库连接
     */
    private Connection newConnection() {
        Connection connection = null;
        if(this.created < this.MAX_CONNCTION){
            //尝试建立连接
            try {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //检测获取连接的结果
            if (connection != null) {
                synchronized (createdLock) {
                    created++;
                }
            }
        }
        return connection;
    }

    /**
     * 返回一个数据库连接到池中，再由线程返回连接池
     *
     * @param connection
     */
    public void freeConnection(Connection connection) {
        freeConnection(null, connection);
    }

    public void freeConnection(String poolName, Connection connection) {
        if (connection != null) {
            synchronized (returnedPoolLock) {
                returnedPool.push(connection);
            }
        }
    }

    public void run(){
        Connection connection = null;
        UsingConnection usingConnection = null;
        while (!stopThread){
            while (!returnedPool.empty()){
                //获取被返回的连接
                synchronized (returnedPoolLock) {
                    connection = (Connection) returnedPool.pop();
                }
                //查看被返回的连接是否是本池子发出的连接
                synchronized (usingLock) {
                    usingConnection = (UsingConnection) usingPool.get(connection);
                }
                //返回的连接不在已经取走正在使用的连接中,说明不是自己发出的,直接关闭
                if(usingConnection == null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (usingLock) {
                    usingPool.remove(connection);
                }
                //测试连接是否有效，有效则返回池中
                if (canUse(connection)){
                    synchronized (poolLock){
                        unuesdPool.add(connection);
                    }
                //无效从池中删除
                }else {
                    try {
                        connection.close();
                    } catch (Exception e) {
                    }
                    synchronized (createdLock) {
                        created--;
                    }
                }
            }
            connection = null;
            usingConnection = null;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
            }
        }
        stopThread = false;
    }



    private boolean canUse(Connection connection) {
        boolean result = false;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select 1");
            resultSet = statement.executeQuery();
            result = true;
        } catch (Exception e) {
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                }
            }
        }
        return result;
    }

    /**
     * 释放所有连接,创建新池
     */
    public void release() {
        //要求停止线程
        stopThread = true;
        //等待线程结束,线程结束时会把stopThread置为false
        int timeout = 0;
        while (stopThread) {
            if (++timeout > 600) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
        //创建新连接池实例
        connectionPoolInstance = new ConnectionPool();
        //释放所有连接，除了Using，Using是正在使用的且会在新的池里被释放
        synchronized (poolLock) {
            while (!unuesdPool.isEmpty()) {
                try {
                    Connection conn = (Connection) unuesdPool.pop();
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
        synchronized (returnedPoolLock) {
            while (!returnedPool.isEmpty()) {
                try {
                    Connection conn = (Connection) returnedPool.pop();
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

}
