package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.exception.FailToPassApprovingException;
import po.PaymentPO;

/**
* @author River
*/
public interface PaymentInputDataService extends Remote {

	/**
	 * Data向数据库中添加记录
	 *
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws FailToPassApprovingException
	 */
	public boolean addPayment(PaymentPO payment)
			throws RemoteException, FailToPassApprovingException;
}
