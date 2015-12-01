
/**
 * 出库处理数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageOutPO;

public interface StorageOutDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(StorageOutPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(StorageOutPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(StorageOutPO po) throws RemoteException;
	/**
	 * 查找返回相应的StorageOutPOPO结果
	 */
	public ArrayList<StorageOutPO> find(StorageOutPO po) throws RemoteException;
	
	
}