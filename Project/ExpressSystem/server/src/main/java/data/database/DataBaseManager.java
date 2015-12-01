package data.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by kylin on 15/11/24.
 */
public class DatabaseManager {

    public static Connection getConnection(){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection(
                connectionPool.getName(), connectionPool.getName()+"caller");
        System.out.println("DataBase is connected!");
        return connection;
    }

    public static boolean releaseConnection(Connection connection, Statement statement, ResultSet resultSet) {
        boolean flag = true;
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        finally{
            ConnectionPool.getInstance().freeConnection(connection);
        }
        System.out.println("Connection is released!");
        return flag;
    }

}