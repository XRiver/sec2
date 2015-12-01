package dataservice.logisticdataservice._Driver;

import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import dataservice.logisticdataservice._Stub.LoadNoteOnTransitDataService_Stub;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnTransitDataService_Driver {

    public static void main(String[] args) throws RemoteException, SQLException, ElementNotFoundException {
        LoadNoteOnTransitDataService service = new LoadNoteOnTransitDataService_Stub();
        LoadNoteOnTransitDataService_Driver driver = new LoadNoteOnTransitDataService_Driver();
        driver.drive(service);
    }

    public void drive(LoadNoteOnTransitDataService service) throws RemoteException, SQLException, ElementNotFoundException {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000004");
        codes.add("0000000005");
        ArrayList<String> codes2 = new ArrayList<String>();
        codes2.add("0000000006");
        codes2.add("0000000019");
        codes2.add("0000000020");
        codes2.add("0000000030");
        LoadNoteOnTransitPO po1 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "朱梦晴","武昌昊","",codes);
        LoadNoteOnTransitPO po2 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "李沪东","吴大爷","",codes2);
        if(service.insert(po1).isPass())
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po2).isPass())
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");

    }

}
