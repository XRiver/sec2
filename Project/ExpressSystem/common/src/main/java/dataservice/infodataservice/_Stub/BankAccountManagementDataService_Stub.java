package dataservice.infodataservice._Stub;
/**
 * @author wwz
 * @data 2015/10/21
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.BankAccountManagementDataService;

public class BankAccountManagementDataService_Stub implements BankAccountManagementDataService{

	public boolean addBankAccount(BankAccountPO account)
			throws RemoteException, InterruptWithExistedElementException {
		System.out.println("add  bankAccount success");
		return true;
	}

	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException {
		System.out.println("remove bankAccount success");
		return true;
	}

	public boolean modifyBankAccount(BankAccountPO originalAccount,
			BankAccountPO modifiedAccount) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		System.out.println("modify bankAccount success");
		return true;
	}

	public ArrayList<BankAccountPO> findBankAccount(BankAccountPO info)
			throws RemoteException, ElementNotFoundException {
		System.out.println("find bankAccount success");
		return new ArrayList<BankAccountPO>();
	}

	public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException {
		System.out.println("show success");
		ArrayList<BankAccountPO> list = new ArrayList<BankAccountPO>();
		
		list.add(new BankAccountPO("金三胖","1234567890","2000"));		
		return list;
	}

	@Override
	public boolean modifyBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		return false;
	}
	

}
