package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import po.InventoryPO;
import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseManager;
import data.infodata.UserInfoHelper;
import data.statisticdata.LogInsHelper;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.exception.ElementNotFoundException;

/**
 * @author River
 * 
 * 依赖数据表:
 * 出入信息表：InOutInfo:
 * Columns:OrderID(VARCHAR(16)),WarehouseID(varchar(20)),isIn(int as boolean,DEFAULT 1),Date(varchar(32)),
 * aeraCode(VARCHAR(16)),rowNumber(VARCHAR(16)),frameNumber(VARCHAR(16)),placeNumber(VARCHAR(16))
 * 
 * 最近查询时间表:RecentInquiryTime
 * Columns:WarehouseID(varchar(20),PRIMARY KEY),Date(varchar(32))
 */
public class InventoryData implements InventoryDataService {

	private Connection connection;
	
	public InventoryData() {
		super();
	}
	
    @Override
    public InventoryPO findByTime(String sTime, String eTime,String staffID) throws RemoteException {
    	
    	String orgNum = null;
    	try {
			orgNum = UserInfoHelper.getOrg(staffID);
			if(orgNum==null) throw new Exception();
		} catch (Exception e) {
			System.out.println("StaffID: "+staffID+" 提供错误或数据库连接异常:");
			e.printStackTrace();
		}
    	
    	/**
    	 * 需要填写的内容：
    	 * 总的库存数量
    	 * 出库数量
    	 * 入库数量
    	 * 时间段内货物金额
    	 * 所有货物信息
    	 */
    	
    	
        return null;
    }
    
    @Override
    public InventoryPO findAll(String staffID) throws RemoteException {
    	connection = DatabaseManager.getConnection();
    	String lastTime = null;
    	
    	try {
    		String org = UserInfoHelper.getOrg(staffID);
    		String sql = "select Date from RecentInquiryTime where WarehouseID='"+org+"'";
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		ResultSet set = stmt.executeQuery();
    		if(!set.next()) throw new Exception();
    		lastTime = set.getString("Date");
    		if(lastTime==null) throw new Exception();
    	} catch(Exception e) {
    		e.printStackTrace();
    		DatabaseManager.releaseConnection(connection, null, null);
    		LogInsHelper.insertLog("用户："+staffID+"试图进行库存盘点，但系统获取其上次盘点时间失败");
    		throw new RemoteException("获取上次盘点时间时失败");
    	}
    	
    	String currentTime = null;
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        currentTime = df.format(new Date());
        
    	DatabaseManager.releaseConnection(connection, null, null);
    	
        return findByTime(lastTime, currentTime, staffID);
    }

	@Override
	public boolean setRecentTime(String date,String staffID) throws RemoteException {
		connection = DatabaseManager.getConnection();
		
		String org = null;
		try {
			org = UserInfoHelper.getOrg(staffID);
			if(org==null) throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			LogInsHelper.insertLog("获取用户："+staffID+"机构相关信息失败");
			DatabaseManager.releaseConnection(connection, null, null);
			return false;
		}
		
		/**
		 * 最近查询时间表:RecentInquiryTime
		 * Columns:WarehouseID(varchar(20),PRIMARY KEY),Date(varchar(32))
		 */
		//先查询一下：此仓库是否存在于RecentInquiryTime
		String sql = "select * from RecentInquiryTime where WarehouseID='"+org+"'";
		boolean hasPrev = false;
		try {
			PreparedStatement stmt1 = connection.prepareStatement(sql);
			ResultSet set1 = stmt1.executeQuery();
			if(set1.next()) hasPrev = true;
		} catch (Exception e) {
			e.printStackTrace();
			DatabaseManager.releaseConnection(connection, null, null);
			return false;
		}
		
		//然后决定行为
		if(hasPrev) {
			sql = "update RecentInquiryTime set Date='"+date+"' where WarehouseID='"+org+"'";
		} else {
			sql = "insert into RecentInquiryTime (WarehouseID,Date) values ('"+org+"','"+date+"')";
		}
		
		try {
			PreparedStatement stmt2 = connection.prepareStatement(sql);
			stmt2.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		DatabaseManager.releaseConnection(connection, null, null);
		return true;
	}
    
    
}
