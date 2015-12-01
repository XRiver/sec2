package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.CommodityGoodsPO;
import po.StorageInPO;
import util.enums.DocState;
import data.database.DatabaseManager;
import data.infodata.UserInfoHelper;
import data.statisticdata.LogInsHelper;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.exception.ElementNotFoundException;

/**
 * 
 * @author River
 * database:
 * StorageInNote
 * id(varchar(32)),date(varchar(32)),warehouseID(varchar(20))，isPassed(int,enum Doc for java)
 * 
 * InOutInfo
 * OrderID(VARCHAR(16)),WarehouseID(varchar(20)),isIn(int as boolean,DEFAULT 1),Date(varchar(32))
 */

public class StorageInData implements StorageInDataService {
	
	private Connection connection;
	
	public StorageInData() {
		super();
	}
	
    @Override
    public boolean insert(StorageInPO po,String staffID) throws RemoteException {
    	
    	connection = DatabaseManager.getConnection();
    	String org = null;
    	try {
			org = UserInfoHelper.getOrg(staffID);
			if(org == null) throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
    	
    	String sql = "insert into StorageInNote(id,date,warehouseID,isPassed) values (?,?,?,?)";
    	PreparedStatement stmt = null;
    	
    	try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			DatabaseManager.releaseConnection(connection, stmt, null);
			return false;
		}
    	
    	//假设并发不会导致这种“ID”重复
    	long tempID = System.currentTimeMillis();
    	
    	try {
			stmt.setString(1, ""+tempID);
			stmt.setString(2, po.getDate());
			stmt.setString(3, org);
			stmt.setInt(4, DocState.UNCHECKED.getIntState());
			int res = stmt.executeUpdate();
			if(res==0) return false;
		} catch (SQLException e) {
			e.printStackTrace();
			DatabaseManager.releaseConnection(connection, stmt, null);
			return false;
		}
    	
    	DocState state = DocState.UNCHECKED;
    	ResultSet set = null;
    	while(state==DocState.UNCHECKED) {
    		try {
				set = stmt.executeQuery("select isPassed from StorageInNote where id='"+tempID+"'");
				state = DocState.getDocState(set.getInt("isPassed"));
			} catch (SQLException e) {
				e.printStackTrace();
				DatabaseManager.releaseConnection(connection, stmt, set);
				return false;
			}
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}

    	if(state==DocState.FAILED) {
    		LogInsHelper.insertLog("仓库管理员："+staffID+"添加了入库单“"+tempID+"”，然而并没通过审核");
    		DatabaseManager.releaseConnection(connection, stmt, set);
    		return false;
    	}
    	//Passed!    	
    	// 审核通过后向InOutInfo中逐条添加
    	ArrayList<CommodityGoodsPO> list = po.getGoodsInStorageInfo();
    	for(CommodityGoodsPO good:list) {
    		try {
				int result = stmt.executeUpdate("insert into InOutInfo (OrderID,WarehouseID,isIn,Date)"
						+ " values('"+good.getBarcode()+"','"+org+"',"+1+",'"+po.getDate()+"')");
			} catch (SQLException e) {
				e.printStackTrace();
		    	DatabaseManager.releaseConnection(connection, stmt, set);
				return false;
			}
    	}
    	
    	// 要添加staffID的日志记录
    	LogInsHelper.insertLog("仓库管理员："+staffID+"添加了入库单“"+tempID+"”，通过了审核");
    	DatabaseManager.releaseConnection(connection, stmt, set);
    	
        return true;
    }
}
