package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.TransitNoteInputDataService;
import dataservice.logisticdataservice._Stub.TransitNoteInputDataService_Stub;
import po.TransitNoteInputPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class TransitNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        TransitNoteInputDataService service = new TransitNoteInputDataService_Stub();
        TransitNoteInputDataService_Driver driver = new TransitNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(TransitNoteInputDataService service) throws RemoteException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("0000111110");
        list.add("0000111111");
        list.add("0000111112");
        list.add("0000111113");
        ArrayList<String> list2 = new ArrayList<String>();
        list.add("2000111110");
        list.add("2000111111");
        list.add("3000111112");
        list.add("4000111113");
        TransitNoteInputPO po1 = new TransitNoteInputPO("2015-10-23","025100201510200000012","CA1206","南京",
                "西安","0120","王小二",list);
        TransitNoteInputPO po2 = new TransitNoteInputPO("2015-10-24","025100201510200000013","CZ3151","南京",
                "深圳","0122","西北狼",list2);
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
        if(service.delete(po2))
        	System.out.println("delete succeed");
        else
        	System.out.println("delete failed");
        service.findAll();
    }

}
