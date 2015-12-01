package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import dataservice.logisticdataservice._Stub.ArrivalNoteOnServiceDataService_Stub;
import po.ArrivalNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.GoodsState;

/**
 * Created by kylin on 15/10/20.
 */
public class ArrivalNoteOnServiceDataService_Driver {

    private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
    private ArrivalNoteOnServicePO arrivalNoteOnServicePO2;
    private ArrivalNoteOnServicePO arrivalNoteOnServicePO3;
    private ArrayList<ArrivalNoteOnServicePO> pos;

    public ArrivalNoteOnServiceDataService_Driver() {
    	ArrayList<String> barCodes = new ArrayList<String>();
        pos = new ArrayList<ArrivalNoteOnServicePO>();
        arrivalNoteOnServicePO = new ArrivalNoteOnServicePO("2011-11-11","250000201510130000000",
        		"北京",GoodsState.COMPLETE,barCodes);
        arrivalNoteOnServicePO2 = new ArrivalNoteOnServicePO("2011-11-11","250000201510130000001",
        		"北京",GoodsState.COMPLETE,barCodes);
        arrivalNoteOnServicePO3 = new ArrivalNoteOnServicePO("2011-11-11","250000201510130000002",
        		"北京",GoodsState.COMPLETE,barCodes);
        pos.add(arrivalNoteOnServicePO);
        pos.add(arrivalNoteOnServicePO2);
        pos.add(arrivalNoteOnServicePO3);
    }


    public void drive(ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService) throws RemoteException {
        if(arrivalNoteOnServiceDataService.insert(arrivalNoteOnServicePO));
        	System.out.println("insert succeed");
        if(arrivalNoteOnServiceDataService.insert(arrivalNoteOnServicePO2));
        	System.out.println("insert succeed");
        arrivalNoteOnServiceDataService.find(arrivalNoteOnServicePO);
        arrivalNoteOnServiceDataService.find(arrivalNoteOnServicePO2);
        arrivalNoteOnServiceDataService.findAll();
        if(arrivalNoteOnServiceDataService.delete(arrivalNoteOnServicePO));
        	System.out.println("delete succeed");
        if(arrivalNoteOnServiceDataService.update(arrivalNoteOnServicePO3));
        	System.out.println("update succeed");
    }

    public static void main(String[] args) throws RemoteException {
        ArrivalNoteOnServiceDataService stub = new ArrivalNoteOnServiceDataService_Stub();
        ArrivalNoteOnServiceDataService_Driver driver = new ArrivalNoteOnServiceDataService_Driver();
        driver.drive(stub);
    }
}
