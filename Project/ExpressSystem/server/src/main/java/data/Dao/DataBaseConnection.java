package data.dao;

import po.UserPO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/18.
 */
public class DatabaseConnection {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/Express";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "861910";
    private Connection connnection = null;

    public DatabaseConnection(){
        try {
            System.out.println("DataBase connecting......");
            Class.forName(DB_DRIVER);
            connnection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("DataBase is connected!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnnection() {
        return connnection;
    }

    public void close()throws Exception{
        if(connnection!=null){
            connnection.close();
        }
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        UserPO po1 = new UserPO("newUser","666666",6);
    }

}
