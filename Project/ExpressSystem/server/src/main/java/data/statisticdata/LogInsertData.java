package data.statisticdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.database.DatabaseManager;
import data.statisticdata.inte.LogInsertDataService;

public class LogInsertData implements LogInsertDataService {

    //TODO connection即用即还,不应该是成员变量,释放语句应该写在方法里面
	private Connection connection;
	
	public LogInsertData() {
		super();
        this.connection = DatabaseManager.getConnection();
    }
	
	@Override
	public void insertSystemLog(String log) throws SQLException {
        String currentTime;
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        currentTime = df.format(new Date());
        String insertStat = "insert into SystemLog (time,log) values ('"+currentTime+"','" +log+ "')";
		PreparedStatement statement = connection.prepareStatement(insertStat);
		statement.executeUpdate();
	}

}
