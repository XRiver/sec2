package dataservice.financedataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.IncomeNotePO;

/**
* @author River
*/
public interface SettlementManagementDataService extends Remote, Serializable {
	/**
	 * Data层增加收款单记录，修改对应账户信息
	 *
	 * @return
	 * @throws RemoteException
	 */
	public boolean addIncomeNote(IncomeNotePO note) 
			throws RemoteException;
	
	/**
	 * 用于查询所有收款单记录
	 * 
	 * @return
	 */
	public ArrayList<IncomeNotePO> findAll()
		throws RemoteException;
}
