package dataservice.financedataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.financedataservice.SettlementManagementDataService;
import po.IncomeNotePO;

public class SettlementManagementDataService_Stub implements SettlementManagementDataService {

	public boolean addIncomeNote(IncomeNotePO note) throws RemoteException {
		System.out.println("add income note sucess");
		return true;
	}

	@Override
	public ArrayList<IncomeNotePO> findAll() throws RemoteException {
		return null;
	}

}
