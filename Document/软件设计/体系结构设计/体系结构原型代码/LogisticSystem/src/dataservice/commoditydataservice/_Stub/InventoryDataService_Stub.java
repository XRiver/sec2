package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.InventoryDataService;
import po.GoodsPO;
import po.InventoryPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/20.
 */
public class InventoryDataService_Stub implements InventoryDataService {

    private InventoryPO inventoryPO1;
    private InventoryPO inventoryPO2;
    private ArrayList<InventoryPO> inventoryPOs;
    private GoodsPO goodsInfo1;
    private GoodsPO goodsInfo2;

    public InventoryDataService_Stub() {
    	
    	goodsInfo1 = new GoodsPO("1234567890","航空区","北京",12,12,56);
    	goodsInfo2 = new GoodsPO("1234567891","航空区","北京",12,12,57);
    	
    	inventoryPOs = new ArrayList<InventoryPO>();
    ArrayList<GoodsPO> goods1 = new ArrayList<GoodsPO>();
    goods1.add(goodsInfo1);
    inventoryPO1 = new InventoryPO("10","20","1000",goods1);
        
    ArrayList<GoodsPO> goods2 = new ArrayList<GoodsPO>();
    goods2.add(goodsInfo2);
    inventoryPO2 = new InventoryPO("10","20","1000",goods2);

        inventoryPOs.add(inventoryPO1);
        inventoryPOs.add(inventoryPO2);
    }

    @Override
    public ArrayList<InventoryPO> findByTime(String sTime, String eTime) throws RemoteException {
        System.out.println("InventoryDataService findByTime succeed");
        return inventoryPOs;
    }

    @Override
    public ArrayList<InventoryPO> findAll() throws RemoteException {
        System.out.println("InventoryDataService findAll succeed");
        return inventoryPOs;
    }
}
