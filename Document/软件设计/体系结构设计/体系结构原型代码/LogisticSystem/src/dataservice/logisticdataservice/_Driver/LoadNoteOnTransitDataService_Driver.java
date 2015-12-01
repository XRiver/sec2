package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import dataservice.logisticdataservice._Stub.LoadNoteOnTransitDataService_Stub;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnTransitDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        LoadNoteOnTransitDataService service = new LoadNoteOnTransitDataService_Stub();
        LoadNoteOnTransitDataService_Driver driver = new LoadNoteOnTransitDataService_Driver();
        driver.drive(service);
    }

    public void drive(LoadNoteOnTransitDataService service) throws RemoteException {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000004");
        codes.add("0000000005");
        ArrayList<String> codes2 = new ArrayList<String>();
        codes2.add("0000000006");
        codes2.add("0000000019");
        codes2.add("0000000020");
        codes2.add("0000000030");
        LoadNoteOnTransitPO po1 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "朱梦晴","武昌昊",codes);
        LoadNoteOnTransitPO po2 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "李沪东","吴大爷",codes2);
        if(service.insert(po1))
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po2))
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        service.findAll();
        service.find(po1);
        service.find(po2);
        if(service.delete(po1))
        	System.out.println("delete succeed");
        else
        	System.out.println("delete failed");
        service.findAll();
        po2 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000003","西藏","苏B 00001",
                "李沪东","吴大爷",codes2);
        if(service.update(po2))
        	System.out.println("update succeed");
        else
        	System.out.println("update failed");
        service.findAll();
    }

}
