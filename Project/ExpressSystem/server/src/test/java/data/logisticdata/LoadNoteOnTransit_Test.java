package data.logisticdata;

import data.logisticdata.MockObject.MockLoadNoteOnTransit;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import org.junit.Test;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnTransit_Test {

    private LoadNoteOnTransitDataService service;

    public LoadNoteOnTransit_Test() throws RemoteException {
        service = new LoadNoteOnTransitData();
    }

    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException {
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("1234567890");
        LoadNoteOnTransitPO po1 = new LoadNoteOnTransitPO(
                "2011-11-11", "025010222", "025000201509090000009", "北京", "saza792", "张三", "tom", bar);
        this.service.insert(po1);
    }


}
