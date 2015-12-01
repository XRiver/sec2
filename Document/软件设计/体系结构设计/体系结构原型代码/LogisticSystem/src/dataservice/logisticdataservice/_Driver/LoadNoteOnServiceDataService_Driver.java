package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import dataservice.logisticdataservice._Stub.LoadNoteOnServiceDataService_Stub;
import po.LoadNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnServiceDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        LoadNoteOnServiceDataService service = new LoadNoteOnServiceDataService_Stub();
        LoadNoteOnServiceDataService_Driver driver = new LoadNoteOnServiceDataService_Driver();
        driver.drive(service);
    }

    public void drive(LoadNoteOnServiceDataService service) throws RemoteException {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000004");
        codes.add("0000000005");
        ArrayList<String> codes2 = new ArrayList<String>();
        codes2.add("0000000006");
        codes2.add("0000000019");
        codes2.add("0000000020");
        codes2.add("0000000030");
        LoadNoteOnServicePO po1 = new LoadNoteOnServicePO("2015-10-22","0251001","0251001201510220001","上海","苏A 00001","泰勒",
                "小李子",codes);
        LoadNoteOnServicePO po2 = new LoadNoteOnServicePO("2015-10-23","0251001","0251001201510220002","上海","苏A 00002","Tom Hanks",
                "Bridy",codes2);
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
        po2 = new LoadNoteOnServicePO("2015-10-23","0251001","0251001201510220002","西藏","苏A 00002","Tom Hanks",
                "一只麟",codes);
        if(service.update(po2))
        	System.out.println("update succeed");
        else
        	System.out.println("update failed");
        service.findAll();
    }
}
