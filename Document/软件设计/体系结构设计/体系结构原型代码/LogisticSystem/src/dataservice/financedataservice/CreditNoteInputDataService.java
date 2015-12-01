package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.exception.FailToPassApprovingException;
import po.CreditNotePO;

/**
* @author River
*/
public interface CreditNoteInputDataService extends Remote {

	/**
	 * Data向数据库中添加记录
	 *
	 * @return true for successful add operation
	 * @throws RemoteException
	 */
	public boolean addCreditNote(CreditNotePO note)
			throws RemoteException,FailToPassApprovingException;
	
}
