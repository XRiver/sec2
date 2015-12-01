package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.StorageInDataService;
import po.StorageInPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageInDataService_Stub implements StorageInDataService {

    @Override
    public boolean insert(StorageInPO po) throws RemoteException {
        System.out.println("insert succeed!");
		return true;
    }

    @Override
    public boolean delete(StorageInPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

    @Override
    public boolean update(StorageInPO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

    @Override
    public ArrayList<StorageInPO> find(StorageInPO po) throws RemoteException {
        System.out.println("find succeed!");
        return new ArrayList<StorageInPO>();
    }
}
