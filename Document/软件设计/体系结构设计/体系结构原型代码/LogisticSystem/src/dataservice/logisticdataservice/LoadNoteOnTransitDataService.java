/**
 * 录入中转中心装车单数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LoadNoteOnTransitPO;

public interface LoadNoteOnTransitDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 查找返回相应的LoadNoteOnTransitPO结果
	 */
	public ArrayList<LoadNoteOnTransitPO> find(LoadNoteOnTransitPO po) throws RemoteException;
	
	/**
	 * 返回所有的LoadNoteOnServicePO
	 */
	public ArrayList<LoadNoteOnTransitPO> findAll() throws RemoteException;
}
