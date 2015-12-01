package dataservice.financedataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.financedataservice.SettlementManagementDataService;
import po.IncomeNotePO;

public class SettlementManagementDataService_Stub implements SettlementManagementDataService {

	@Override
	public boolean addIncomeNote(IncomeNotePO note) throws RemoteException {
		System.out.println("add income note sucess");
		return true;
	}

}
