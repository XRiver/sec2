package data.statisticdata;

import java.rmi.RemoteException;

import dataservice.statisticdataservice.BaseDataBuildingDataService;

public class BaseDataBuildingData implements BaseDataBuildingDataService{

	@Override
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean endBaseDataBuilding() throws RemoteException {
		return true;
	}
	

}
