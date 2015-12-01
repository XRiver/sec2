package dataservice.commoditydataservice._Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.commoditydataservice.StorageOutDataService;
import po.StorageOutPO;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageOutDataService_Stub implements StorageOutDataService {
    public boolean insert(StorageOutPO po,String staffID) throws RemoteException {
        System.out.println("insert succeed!");
        return true;
    }


}
