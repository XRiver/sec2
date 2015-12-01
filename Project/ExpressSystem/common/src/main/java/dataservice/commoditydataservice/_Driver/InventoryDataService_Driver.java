package dataservice.commoditydataservice._Driver;

import dataservice.commoditydataservice.InventoryDataService;
import dataservice.commoditydataservice._Stub.InventoryDataService_Stub;
import po.InventoryPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/20.
 */
public class InventoryDataService_Driver {

    public void drive(InventoryDataService inventoryDataService) throws RemoteException {
    	InventoryPO pos = inventoryDataService.findAll(null);
    	System.out.println("find");
    	InventoryPO pos1 = inventoryDataService.findByTime("2015-10-01","2015-10-11", null);
    	System.out.println("find InventoryPO");
    	InventoryPO pos2 = inventoryDataService.findByTime("2015-10-12","2015-11-26", null);
    	System.out.println("find InventoryPO");
    	InventoryPO pos3 = inventoryDataService.findByTime("2015-11-01","2015-12-11", null);
    	System.out.println("find InventoryPO");
    }

    public static void main(String[] args) throws RemoteException {
        InventoryDataService inventoryDataService = new InventoryDataService_Stub();
        InventoryDataService_Driver driver = new InventoryDataService_Driver();
        driver.drive(inventoryDataService);
    }

}
