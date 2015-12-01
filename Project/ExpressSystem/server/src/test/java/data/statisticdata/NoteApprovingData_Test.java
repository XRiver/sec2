package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.database.DatabaseFactory;
import data.logisticdata.MockObject.MockArrivalNoteOnTransit;
import data.logisticdata.MockObject.MockDeliveryNote;
import org.junit.Test;

import data.logisticdata.MockObject.MockArrivalNoteOnService;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;
import po.*;
import util.BarcodeAndState;
import util.enums.DeliverCategory;
import util.enums.GoodsState;
import util.enums.TransitType;
import vo.LoadNoteOnServiceVO;

public class NoteApprovingData_Test {

    protected NoteApprovingDataService service;

    public NoteApprovingData_Test() throws RemoteException {
//        service = new NoteApprovingData();
    }

    //    @Test
    public void testArrivalOnServiceDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnServicePO po1 = new ArrivalNoteOnServicePO(null, false,
                "025001201511260001", null, null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴1");
    }

    //    @Test
    public void testDeliveryOnServiceDoc() throws RemoteException, ElementNotFoundException, SQLException {
//        ArrayList<String> barcodes = new ArrayList<>();
//        barcodes.add("1234567890");
//        barcodes.add("1234567891");
//        barcodes.add("1234567892");
//        DeliverNoteOnServicePO po1 = new DeliverNoteOnServicePO("025001002","2015-11-16",barcodes,"test2");
//        service.passDoc(po1);

        ArrayList<String> barcodes = new ArrayList<>();
        barcodes.add("1234567890");
        barcodes.add("1234567891");
        barcodes.add("1234567892");
        DeliverNoteOnServicePO po2 = new DeliverNoteOnServicePO("025123456", "2015-11-16", barcodes, "test3");
        service.failDoc(po2, "不高兴1");
    }


    //    @Test
    public void testArrivalOnTransitDoc() throws RemoteException, ElementNotFoundException, SQLException {
//        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(
//                "025001201511260001", "025100", "2011-11-11", "北京", null);
//        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260003", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "3不高兴3");
    }

    //    @Test
    public void testDeliveryDoc() throws RemoteException, ElementNotFoundException, SQLException {
        DeliveryNotePO po1 = new DeliveryNotePO("王二狗", "江苏省南京市栖霞区南京大学仙林校区", "150052120000",
                "Tom Hanks", "上海环球金融中心78层优则金融有限公司", "19883490000", "爆炸物", 10,
                1, 2, DeliverCategory.EXPRESS, 5, "000000008");
        service.failDoc(po1, "123");

//        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
//                "025001201511260002", "025100", "2011-11-11", "北京", null);
//        service.failDoc(po2, "不高兴2");
    }

    //    @Test
    public void testLoadOnServiceDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("1234567890");
        bar.add("1234567891");
        bar.add("1234567892");
        LoadNoteOnServicePO po1 = new LoadNoteOnServicePO("2015-11-11", "0251000",
                "02510002015092100003", "北京", "025000000", "李明", "张三", bar);
        service.failDoc(po1, "不高兴7");

//        LoadNoteOnServicePO po2 = new LoadNoteOnServicePO("2015-11-11", "0251000",
//                "02510002015092100001","北京","025000000","李明","张三",bar);
//        service.failDoc(po2, "不高兴2");
    }

    //    @Test
    public void testLoadOnTransitDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("1234567890");
        LoadNoteOnTransitPO po1 = new LoadNoteOnTransitPO(
                "2011-11-11", "025010222", "025000201509090000006", "北京", "saza792", "张三", "tom", bar);
        service.passDoc(po1);

        ArrayList<String> bar1 = new ArrayList<String>();
        bar.add("1234567890");
        LoadNoteOnTransitPO po2 = new LoadNoteOnTransitPO(
                "2011-11-11", "025010222", "025000201509090000009", "北京", "saza792", "张三", "tom", bar1);
        service.failDoc(po2, "不高兴999");
    }

    //    @Test
    public void testReceivingDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ReceivingNotePO po1 = new ReceivingNotePO("0123456789", "旭爷2", "2015-11-26 21:00");
        service.passDoc(po1);

        ReceivingNotePO po2 = new ReceivingNotePO("1234567893", "旭爷2", "2015-11-26 21:00");
        service.failDoc(po2, "不高兴3333");
    }

    @Test
    public void testTransitDoc() throws RemoteException, ElementNotFoundException, SQLException {
        TransitNotePO po1 = new TransitNotePO("2011-11-11", "025000201510120000005",
                "MF8190", TransitType.Aircraft, "北京",
                "南京", "Tom", null);
        service.passDoc(po1);

        TransitNotePO po2 = new TransitNotePO("2011-11-11", "025000201510120000006",
                "MF8190", TransitType.Aircraft, "北京",
                "南京", "Tom", null);
        service.failDoc(po2, "不高兴2");
    }

}
