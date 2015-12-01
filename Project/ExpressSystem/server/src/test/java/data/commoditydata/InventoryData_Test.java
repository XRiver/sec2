package data.commoditydata;


import java.rmi.RemoteException;
import java.util.ArrayList;

import data.commoditydata.MockObject.MockInventoryPO;
import org.junit.Test;

import po.InventoryPO;

public class InventoryData_Test {
	
	@Test
	public void testAll() throws RemoteException { // Hard to use junit test.
		
		InventoryData id = new InventoryData();
		
//		ArrayList<InventoryPO> list = id.findByTime("2015-06-07", "2015-11-15");
//		for(InventoryPO po:list) {
//			System.out.println("Time:"+po.getInNum());
//		}
//
//		list = id.findAll();
//		for(InventoryPO po:list) {
//			System.out.println("Time:"+po.getInNum());
//		}
	}

}
