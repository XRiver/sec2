package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.StorageInDataService;
import po.StorageInPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageInDataService_Stub implements StorageInDataService {

    public boolean insert(StorageInPO po,String staffID) throws RemoteException {
        System.out.println("insert succeed!");
		return true;
    }

}
