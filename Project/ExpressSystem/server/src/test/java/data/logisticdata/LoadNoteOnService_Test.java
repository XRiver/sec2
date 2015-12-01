package data.logisticdata;

import data.logisticdata.MockObject.MockLoadNoteOnService;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import org.junit.Assert;
import org.junit.Test;
import po.LoadNoteOnServicePO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnService_Test {

    private LoadNoteOnServiceDataService service;

    public LoadNoteOnService_Test() throws RemoteException {
        service = new LoadNoteOnServiceData();
    }

    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException {
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("1234567890");
        bar.add("1234567891");
        bar.add("1234567892");
        LoadNoteOnServicePO po1 = new LoadNoteOnServicePO("2015-11-11", "0251000",
                "02510002015092100004", "北京", "025000000", "李明", "张三", bar);
        service.insert(po1);
    }

}
