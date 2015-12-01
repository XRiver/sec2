package dataservice.infodataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.BankAccountPO;

/**
* @author River
*/
public interface BankAccountManagementDataService extends Remote, Serializable {

	/**
	 * Data向数据库中添加对应PO信息
	 *
	 * @param account
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 * @throws SQLException 
	 */
	public boolean addBankAccount(BankAccountPO account) 
			throws RemoteException,	InterruptWithExistedElementException, SQLException;

	/**
	 * Data删除对应PO记录
     *
	 * @param account
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws SQLException 
	 */
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException,	ElementNotFoundException, SQLException;

	/**
	 * Data将originalAccount 替换为modifiedAccount
     *
	 * @param account--BankAccount的账号account作为唯一标识符
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws SQLException 
	 */
	public boolean modifyBankAccount(BankAccountPO account)
			throws RemoteException,	ElementNotFoundException,InterruptWithExistedElementException, SQLException;

	/**
	 * Data返回符合信息的BankAccountPO
     *
	 * @param account
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws SQLException 
	 */
	public ArrayList<BankAccountPO> findBankAccount(BankAccountPO accountInfo)
			throws RemoteException, ElementNotFoundException, SQLException;
	/**
     * Data返回所有BankAccountPO记录
     *
	 * @return
	 * @throws RemoteException
	 * @throws SQLException 
	 * @throws ElementNotFoundException 
	 */
	public ArrayList<BankAccountPO>  getAllAccounts()
			throws RemoteException, ElementNotFoundException, SQLException;
	
}
