package dataservice.logisticdataservice._Driver;

import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import dataservice.logisticdataservice._Stub.TransitNoteInputDataService_Stub;
import po.TransitNotePO;
import util.enums.TransitType;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class TransitNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException, SQLException, ElementNotFoundException {
        TransitNoteInputDataService service = new TransitNoteInputDataService_Stub();
        TransitNoteInputDataService_Driver driver = new TransitNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(TransitNoteInputDataService service) throws RemoteException, SQLException, ElementNotFoundException {
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
        TransitNotePO po1 = new TransitNotePO("2015-10-23", "025100201510200000012", "CA1206", TransitType.Aircraft, "南京",
                "西安", "0120", null);
        TransitNotePO po2 = new TransitNotePO("2015-10-24", "025100201510200000013", "CZ3151", TransitType.Aircraft, "南京",
                "深圳", "0122", null);
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
