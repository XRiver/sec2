package dataservice.logisticdataservice._Driver;

import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import dataservice.logisticdataservice._Stub.ArrivalNoteOnServiceDataService_Stub;
import po.ArrivalNoteOnServicePO;
import util.BarcodeAndState;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/20.
 */
public class ArrivalNoteOnServiceDataService_Driver {

    private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
    private ArrivalNoteOnServicePO arrivalNoteOnServicePO2;
    private ArrivalNoteOnServicePO arrivalNoteOnServicePO3;
    private ArrayList<ArrivalNoteOnServicePO> pos;

    public ArrivalNoteOnServiceDataService_Driver() {
    	ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState>();
        pos = new ArrayList<ArrivalNoteOnServicePO>();
        arrivalNoteOnServicePO = new ArrivalNoteOnServicePO("2011-11-11",true,"250000201510130000000",
        		"北京",BarcodeAndStates);
        pos.add(arrivalNoteOnServicePO);
        pos.add(arrivalNoteOnServicePO2);
        pos.add(arrivalNoteOnServicePO3);
    }


    public void drive(ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService) throws RemoteException, SQLException, ElementNotFoundException {
        if (arrivalNoteOnServiceDataService.insertArrivalNote(arrivalNoteOnServicePO).isPass()) ;
        System.out.println("insert succeed");
        if (arrivalNoteOnServiceDataService.insertArrivalNote(arrivalNoteOnServicePO2).isPass()) ;
        System.out.println("insert succeed");
    }

    public static void main(String[] args) throws RemoteException, SQLException, ElementNotFoundException {
        ArrivalNoteOnServiceDataService stub = new ArrivalNoteOnServiceDataService_Stub();
        ArrivalNoteOnServiceDataService_Driver driver = new ArrivalNoteOnServiceDataService_Driver();
        driver.drive(stub);
    }
}
