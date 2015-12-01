/**
 * 入库处理数据接口
 * @author wqy
 * @date 2015/10/17
 */



package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageInPO;

public interface StorageInDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(StorageInPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(StorageInPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(StorageInPO po) throws RemoteException;
	/**
	 * 查找返回相应的StorageInPO结果
	 */
	public ArrayList<StorageInPO> find(StorageInPO po) throws RemoteException;
	
	

}