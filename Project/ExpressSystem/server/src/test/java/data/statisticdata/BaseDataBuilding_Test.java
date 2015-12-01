package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataservice.statisticdataservice.BaseDataBuildingDataService;

public class BaseDataBuilding_Test {
	
	private BaseDataBuildingDataService service = new BaseDataBuildingData();

	@Test
	public void testStart() throws RemoteException {
		//assertEquals(true,service.startBaseDataBuilding(true));
		//assertEquals(true,service.startBaseDataBuilding(false));
	}
    @Test
	public void testEnd() throws RemoteException{
		//assertEquals(true,service.endBaseDataBuilding());
	}

}
