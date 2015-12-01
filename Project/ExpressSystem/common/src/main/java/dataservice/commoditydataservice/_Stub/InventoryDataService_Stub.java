package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.InventoryDataService;
import po.CommodityGoodsPO;
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
    private CommodityGoodsPO goodsInfo1;
    private CommodityGoodsPO goodsInfo2;

    public InventoryDataService_Stub() {
    	
    	goodsInfo1 = new CommodityGoodsPO("1234567890","航空区","北京","","","");
    	goodsInfo2 = new CommodityGoodsPO("1234567891","航空区","北京","","","");
    	
    	inventoryPOs = new ArrayList<InventoryPO>();
    ArrayList<CommodityGoodsPO> goods1 = new ArrayList<CommodityGoodsPO>();
    goods1.add(goodsInfo1);
    inventoryPO1 = new InventoryPO("10","20","1000",goods1);
        
    ArrayList<CommodityGoodsPO> goods2 = new ArrayList<CommodityGoodsPO>();
    goods2.add(goodsInfo2);
    inventoryPO2 = new InventoryPO("10","20","1000",goods2);

        inventoryPOs.add(inventoryPO1);
        inventoryPOs.add(inventoryPO2);
    }

    public ArrayList<InventoryPO> findByTime(String sTime, String eTime,String staffID) throws RemoteException {
        System.out.println("InventoryDataService findByTime succeed");
        return inventoryPOs;
    }

    public ArrayList<InventoryPO> findAll(String staffID) throws RemoteException {
        System.out.println("InventoryDataService findAll succeed");
        return inventoryPOs;
    }

	@Override
	public boolean setRecentTime(String staffID) {
		return true;
	}
}
