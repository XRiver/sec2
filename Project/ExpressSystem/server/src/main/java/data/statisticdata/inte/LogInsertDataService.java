package data.statisticdata.inte;

import java.sql.SQLException;

public interface LogInsertDataService {

	public void insertSystemLog(String log) throws SQLException;
	
}
