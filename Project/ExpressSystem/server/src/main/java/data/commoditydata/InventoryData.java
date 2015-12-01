package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import po.InventoryPO;
import data.infodata.UserInfoHelper;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.exception.ElementNotFoundException;

public class InventoryData implements InventoryDataService {

	private Connection connection;
	
	public InventoryData() {
		super();
	}
	
    @Override
    public ArrayList<InventoryPO> findByTime(String sTime, String eTime,String staffID) throws RemoteException {
    	String orgNum = null;
    	try {
			orgNum = UserInfoHelper.getOrg(staffID);
			if(orgNum==null) throw new Exception();
		} catch (Exception e) {
			System.out.println("StaffID: "+staffID+" 提供错误或数据库连接异常:");
			e.printStackTrace();
		}
    	//TODO 还是得问问InventoryPO到底是什么意思，琢磨了半天似懂非懂
    	HashMap<String,InventoryPO> poMap = new HashMap<>();
    	
    	
    	ArrayList<InventoryPO> result = new ArrayList<>();

    	
        return result;
    }
    
    @Override
    public ArrayList<InventoryPO> findAll(String staffID) throws RemoteException {
        InventoryPO po1 = new InventoryPO(null,null,null,null);
        ArrayList<InventoryPO> list = new ArrayList<InventoryPO>();
        list.add(po1);
        return list;
    }

	@Override
	public boolean setRecentTime(String staffID) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
}
