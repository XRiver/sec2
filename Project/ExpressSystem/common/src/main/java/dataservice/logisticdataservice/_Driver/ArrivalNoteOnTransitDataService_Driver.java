package dataservice.logisticdataservice._Driver;

import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import dataservice.logisticdataservice._Stub.ArrivalNoteOnTransitDataService_Stub;
import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class ArrivalNoteOnTransitDataService_Driver {

    public static void main(String[] args) throws RemoteException, SQLException, ElementNotFoundException {
        ArrivalNoteOnTransitDataService service = new ArrivalNoteOnTransitDataService_Stub();
        ArrivalNoteOnTransitDataService_Driver driver = new ArrivalNoteOnTransitDataService_Driver();
        driver.drive(service);
    }

    public void drive(ArrivalNoteOnTransitDataService service) throws RemoteException, SQLException, ElementNotFoundException {
        ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
    	ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO("2011-11-11","025100","025100201510200000001","上海",BarcodeAndStates);
        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO("2011-11-11","025100","025100201510200000002","上海",BarcodeAndStates);
        if (!service.insert(po1).isPass()) {
            System.out.println("insert failed");
        } else {
            System.out.println("insert succeed");
        }
        if (service.insert(po2).isPass())
            System.out.println("insert succeed");
        else
        	System.out.println("insert failed");

    }

}
