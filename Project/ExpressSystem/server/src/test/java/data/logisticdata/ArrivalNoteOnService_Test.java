package data.logisticdata;

import data.database.DatabaseFactoryMysqlImpl;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import org.junit.Test;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.BarcodeAndState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnService_Test {

    //    @Test
    public void testInsertArrivalNote() throws RemoteException, SQLException, ElementNotFoundException {
        ArrayList<BarcodeAndState> barcodes = new ArrayList<>();
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        ArrivalNoteOnServicePO mock1 = new ArrivalNoteOnServicePO("2015-11-11", false,
                "250000201510130000005", "北京", barcodes);
//        service.insertArrivalNote(mock1);
    }

//    @Test
    public void testInsertDeliverNote() throws RemoteException, SQLException, ElementNotFoundException {
        ArrayList<String> barcodes = new ArrayList<>();
        barcodes.add("1234567890");
        barcodes.add("1234567891");
        barcodes.add("1234567892");
        DeliverNoteOnServicePO po1 = new DeliverNoteOnServicePO("025123456", "2015-11-16", barcodes, "test3");
//        service.insertDeliverNote(po1);
    }

    @Test
    public void testFindArrival() throws RemoteException, SQLException {
        ArrivalNoteOnServiceData data = (ArrivalNoteOnServiceData) DatabaseFactoryMysqlImpl.getInstance().getArrivalNoteOnServiceDataService();
        ArrayList<ArrivalNoteOnServicePO> pos = data.getArrivalNoteOnService();
    }

}