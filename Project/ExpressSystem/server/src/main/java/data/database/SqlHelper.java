package data.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {

    /**
     * 执行一条SQL executeUpdate语句
     *
     * @param str String类型的 SQL语句
     * @return 语句成功executeUpdate执行与否
     * @throws SQLException
     * @see Connection,PreparedStatement
     */
    public static boolean excUpdate(String str) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(str);
        int result = statement.executeUpdate();
        DatabaseManager.releaseConnection(connection, statement, null);
        return result > 0;
    }

}
