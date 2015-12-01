package dataservice.statisticdataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.statisticdataservice.BaseDataBuildingDataService;



public class BaseDataBuildingDataService_Stub implements BaseDataBuildingDataService{
	
	@Override
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException {
		if(withBase)
		System.out.println("Based on the accounts of success");
		else
			System.out.println("No base on the account of success");
		return true;
	}

	@Override
	public boolean endBaseDataBuilding() throws RemoteException {
		System.out.println("exit success");
		return true;
	}
}
