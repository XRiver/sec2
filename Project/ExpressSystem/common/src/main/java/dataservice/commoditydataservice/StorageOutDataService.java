
/**
 * 出库处理数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageOutPO;

public interface StorageOutDataService extends Remote, Serializable {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(StorageOutPO po,String staffID) throws RemoteException;

}