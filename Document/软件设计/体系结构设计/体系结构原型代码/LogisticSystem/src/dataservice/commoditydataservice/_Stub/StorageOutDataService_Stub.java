package dataservice.commoditydataservice._Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.commoditydataservice.StorageOutDataService;
import po.StorageOutPO;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageOutDataService_Stub implements StorageOutDataService {
    @Override
    public boolean insert(StorageOutPO po) throws RemoteException {
        System.out.println("insert succeed!");
        return true;
    }

    @Override
    public boolean delete(StorageOutPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

    @Override
    public boolean update(StorageOutPO po) throws RemoteException {
        System.out.println("update succeed!");
        return true;
    }

    @Override
    public ArrayList<StorageOutPO> find(StorageOutPO po) throws RemoteException {
        ArrayList<StorageOutPO> pos = new ArrayList<StorageOutPO>();
        StorageOutPO po1 = new StorageOutPO(null, null, null, null, null, false);
        System.out.println("find succeed!");
        pos.add(po1);
        return pos;
    }
}
