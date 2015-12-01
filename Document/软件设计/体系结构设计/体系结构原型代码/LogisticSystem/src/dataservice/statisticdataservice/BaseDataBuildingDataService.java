package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author River
 */
public interface BaseDataBuildingDataService extends Remote {

	/**
	 * Data开始接受单一客户端操作请求
	 *
	 * @return
	 * @throws RemoteException
	 */
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException;

	/**
	 * Data层结束建账，并使用新账
	 *
	 * @return
	 * @throws RemoteException
	 */
	public boolean endBaseDataBuilding()
			throws RemoteException;
	
}
