package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.BankAccountPO;

/**
* @author River
*/
public interface BankAccountManagementDataService extends Remote {

	/**
	 * Data向数据库中添加对应PO信息
	 *
	 * @param account
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addBankAccount(BankAccountPO account) 
			throws RemoteException,	InterruptWithExistedElementException;

	/**
	 * Data删除对应PO记录
     *
	 * @param account
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException,	ElementNotFoundException;

	/**
	 * Data将originalAccount 替换为modifiedAccount
     *
	 * @param originalAccount
	 * @param modifiedAccount
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyBankAccount(BankAccountPO originalAccount,BankAccountPO modifiedAccount)
			throws RemoteException,	ElementNotFoundException,InterruptWithExistedElementException;

	/**
	 * Data返回符合信息的BankAccountPO
     *
	 * @param account
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<BankAccountPO> findBankAccount(BankAccountPO accountInfo)
			throws RemoteException, ElementNotFoundException;
	/**
     * Data返回所有BankAccountPO记录
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountPO>  getAllAccounts()
			throws RemoteException;
	
}
