package dataservice.statisticdataservice._Driver;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.statisticdataservice.BaseDataBuildingDataService;
import dataservice.statisticdataservice._Stub.BaseDataBuildingDataService_Stub;


public class BaseDataBuildingDataService_Driver {
	
	public void drive(BaseDataBuildingDataService baseDataBuildingDataService) throws RemoteException{
		baseDataBuildingDataService.startBaseDataBuilding(false);
		baseDataBuildingDataService.startBaseDataBuilding(true);
		baseDataBuildingDataService.endBaseDataBuilding();	
		
		if(baseDataBuildingDataService.startBaseDataBuilding(false))
			System.out.println("success");
		else
			System.out.println("fail");
		if(baseDataBuildingDataService.startBaseDataBuilding(true))
			System.out.println("success");
		else
			System.out.println("fail");
		if(baseDataBuildingDataService.endBaseDataBuilding())
			System.out.println("success");
		else
			System.out.println("fail");
		
	}
	
	public static void main(String[] args) throws RemoteException{
		BaseDataBuildingDataService_Stub  baseDataBuildingDataService_Stub  = new BaseDataBuildingDataService_Stub();
		BaseDataBuildingDataService_Driver baseDataBuildingDataService_Driver = new BaseDataBuildingDataService_Driver();
		baseDataBuildingDataService_Driver.drive(baseDataBuildingDataService_Stub);
	}

}
