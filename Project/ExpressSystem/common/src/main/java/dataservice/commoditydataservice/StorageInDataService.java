/**
 * 入库处理数据接口
 * @author wqy
 * @date 2015/10/17
 */



package dataservice.commoditydataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.StorageInPO;

public interface StorageInDataService extends Remote, Serializable {
	/**
	 * 在数据库中增加一个po记录
	 * @throws SQLException 
	 */
	public boolean insert(StorageInPO po,String staffID) throws RemoteException;


}