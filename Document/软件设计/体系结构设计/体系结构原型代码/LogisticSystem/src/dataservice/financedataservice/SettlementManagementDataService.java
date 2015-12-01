package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.IncomeNotePO;

/**
* @author River
*/
public interface SettlementManagementDataService extends Remote {
	/**
	 * Data层增加收款单记录，修改对应账户信息
	 *
	 * @return
	 * @throws RemoteException
	 */
	public boolean addIncomeNote(IncomeNotePO note) 
			throws RemoteException;
}
