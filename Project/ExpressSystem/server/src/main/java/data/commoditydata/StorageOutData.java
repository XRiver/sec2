package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.CommodityGoodsPO;
import po.StorageOutPO;
import util.enums.DocState;
import data.database.DatabaseManager;
import data.infodata.UserInfoHelper;
import data.statisticdata.LogInsHelper;
import dataservice.commoditydataservice.StorageOutDataService;

/**
 * 
 * @author River
 * database:
 * StorageOutNote:
 * id(varchar(32)),date(varchar(32)),warehouseID(varchar(20)),destination(varchar(64)),
 * code(varchar(32)),isTransfer(INT(11)),isPassed(INT(11))
 */

public class StorageOutData implements StorageOutDataService {

	private static final long serialVersionUID = 6320563981047628663L;
	private Connection connection;
	
	public StorageOutData() {
		super();
	}
	
    @Override
    public boolean insert(StorageOutPO po,String staffID) throws RemoteException {
    	connection = DatabaseManager.getConnection();
    	
    	//校验、获取操作者数据
    	String org = null;
    	try {
			org = UserInfoHelper.getOrg(staffID);
			if(org == null) throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
    	
    	
    	String sql = "insert into StorageOutNote(id,date,warehouseID,destination,"
    			+ "code,isTransfer,isPassed) values (?,?,?,?,?,?,?)";
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
			stmt.setString(4, po.getDestination());
			stmt.setString(5, po.isTransferOrCar()? po.getTransferCode():po.getCarCode());
			stmt.setInt(6, po.isTransferOrCar()?1:0);
			stmt.setInt(7, DocState.UNCHECKED.getIntState());
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
				set = stmt.executeQuery("select isPassed from StorageOutNote where id='"+tempID+"'");
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
    		LogInsHelper.insertLog("仓库管理员："+staffID+"添加了出库单“"+tempID+"”，然而并没通过审核");
    		DatabaseManager.releaseConnection(connection, stmt, set);
    		return false;
    	}
    	//Passed!    	
    	// 审核通过后向InOutInfo中逐条添加
    	ArrayList<String> list = po.getExpressCode();
    	for(String barcode:list) {
    		try {
				int result = stmt.executeUpdate("insert into InOutInfo (OrderID,WarehouseID,isIn,Date)"
						+ " values('"+barcode+"','"+org+"',"+0+",'"+po.getDate()+"')");
				result = stmt.executeUpdate("update order set isInStorage=0 where barcode='"+barcode+"'");
			} catch (SQLException e) {
				e.printStackTrace();
		    	DatabaseManager.releaseConnection(connection, stmt, set);
				return false;
			}
    	}
    	
    	// 要添加staffID的日志记录
    	LogInsHelper.insertLog("仓库管理员："+staffID+"添加了出库单“"+tempID+"”，通过了审核");
    	DatabaseManager.releaseConnection(connection, stmt, set);
    	
        return true;
    }


}
