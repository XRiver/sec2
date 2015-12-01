/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceivingNoteInputPO;

public interface ReceivingNoteInputDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 查找返回相应的ReceivingNoteInputPO结果
	 */
	public ArrayList<ReceivingNoteInputPO> find(ReceivingNoteInputPO po) throws RemoteException;
	
	
	/**
	 * 返回所有的ReceivingNoteInputPO
	 */
	public ArrayList<ReceivingNoteInputPO> findAll() throws RemoteException;
}