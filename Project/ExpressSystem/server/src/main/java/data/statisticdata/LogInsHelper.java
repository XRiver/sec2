package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.SQLException;

import data.database.DatabaseFactoryMysqlImpl;
import data.statisticdata.inte.LogInsertDataService;

public class LogInsHelper {

	private static LogInsertDataService dataService = null;
	
	static {
		try {
			dataService = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertLog(String log) {
		try {
			dataService.insertSystemLog(log);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
