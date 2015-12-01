package dataservice.logisticdataservice._Driver;

import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import dataservice.logisticdataservice._Stub.ReceivingNoteInputDataService_Stub;
import po.ReceivingNotePO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/10/21.
 */
public class ReceivingNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException, SQLException, ElementNotFoundException {
        ReceivingNoteInputDataService service = new ReceivingNoteInputDataService_Stub();
        ReceivingNoteInputDataService_Driver driver = new ReceivingNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(ReceivingNoteInputDataService service) throws RemoteException, SQLException, ElementNotFoundException {
        ReceivingNotePO po1 = new ReceivingNotePO("0123456789","旭爷","2015-10-23 14:00");
        ReceivingNotePO po2 = new ReceivingNotePO("0123456790","汪同学","2015-10-23 14:00");
        ReceivingNotePO po3 = new ReceivingNotePO("0123456791","狗狗","2015-10-26 9:00");
        if(service.insert(po1).isPass())
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po2).isPass())
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po3).isPass())
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");

    }

}
