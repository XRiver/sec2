package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.NoteDataService;
import dataservice.logisticdataservice._Stub.NoteDataService_Stub;
import po.NotePO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/10/21.
 */
public class NoteDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        NoteDataService service = new NoteDataService_Stub();
        NoteDataService_Driver driver = new NoteDataService_Driver();
        driver.drive(service);
    }

    public void drive(NoteDataService service) throws RemoteException {
        NotePO po1 = new NotePO();
        NotePO po2 = new NotePO();
        service.init();
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
        service.finish();
    }

}
