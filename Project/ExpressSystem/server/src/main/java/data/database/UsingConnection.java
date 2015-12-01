package data.database;

/**
 * Created by kylin on 15/11/24.
 */

import java.sql.Connection;

/**
 * 用户存储当前被使用的数据库连接信息
 */
class UsingConnection {

    private Connection conn = null;

    private String caller = null;

    long time = 0;

    public UsingConnection(Connection conn, String caller) {
        this.conn = conn;
        this.caller = caller;
        time = System.currentTimeMillis();
    }

    public String getCaller() {
        return caller;
    }

    public long getUsingTime() {
        return System.currentTimeMillis() - time;
    }
}