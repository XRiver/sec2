/**
 * 处理中转中心到达件数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ArrivalNoteOnTransitPO;

public interface ArrivalNoteOnTransitDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 按关键字进行查找返回相应的ArrivalNoteOnTransitPO结果
	 */
	public ArrayList<ArrivalNoteOnTransitPO> find(ArrivalNoteOnTransitPO po) throws RemoteException;
	
	/**
	 * 返回所有的中转中心到达单PO
	 */
	public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException;
}