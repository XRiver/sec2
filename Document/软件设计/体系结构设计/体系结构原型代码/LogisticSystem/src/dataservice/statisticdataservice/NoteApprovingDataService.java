package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import po.NotePO;
import businesslogic.util.DocType;

/**
 * 单据审批DataService
 * @author River
 *
 */
public interface NoteApprovingDataService extends Remote{
	
	/**
	 * 获得所有未审批NotePO
	 *
	 * @return
	 */
	public ArrayList<NotePO> getAllDoc()
			throws RemoteException;
	
	/**
	 * 根据类型获取NotePO
	 *
	 * @param type
	 * @return
	 */
	public ArrayList<NotePO> getDocByType(DocType type)
			throws RemoteException;
	
	/**
	 * 搜索docPO并通过之
	 *
	 * @param docPO
	 * @return true for successful pass operation
	 */
	public boolean passDoc(NotePO docPO)
			throws RemoteException, ElementNotFoundException;
	
	/**
	 * 搜索docPO并且否决之
	 *
	 * @param docPO
	 * @return true for successful decline operation
	 */
	public boolean failDoc(NotePO docPO, String comment)
			throws RemoteException, ElementNotFoundException;
}
