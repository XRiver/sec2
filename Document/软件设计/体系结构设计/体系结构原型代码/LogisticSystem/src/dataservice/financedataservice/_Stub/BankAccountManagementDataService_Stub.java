package dataservice.financedataservice._Stub;
/**
 * @author wwz
 * @data 2015/10/21
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BankAccountManagementDataService_Stub implements BankAccountManagementDataService{

	@Override
	public boolean addBankAccount(BankAccountPO account)
			throws RemoteException, InterruptWithExistedElementException {
		System.out.println("add  bankAccount success");
		return true;
	}

	@Override
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException {
		System.out.println("remove bankAccount success");
		return true;
	}

	@Override
	public boolean modifyBankAccount(BankAccountPO originalAccount,
			BankAccountPO modifiedAccount) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		System.out.println("modify bankAccount success");
		return true;
	}

	@Override
	public ArrayList<BankAccountPO> findBankAccount(BankAccountPO info)
			throws RemoteException, ElementNotFoundException {
		System.out.println("find bankAccount success");
		return new ArrayList<>();
	}

	@Override
	public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException {
		System.out.println("show success");
		ArrayList<BankAccountPO> list = new ArrayList<BankAccountPO>();
		BigDecimal c =new BigDecimal(2000);
		
		list.add(new BankAccountPO("金三胖","1234567890",c));		
		return list;
	}
	

}
