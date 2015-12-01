package data.logisticdata;


import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import org.junit.Test;

import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;
import util.enums.GoodsState;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnTransit_Test {

    private ArrivalNoteOnTransitData service;

    public ArrivalNoteOnTransit_Test() throws RemoteException {
        service = new ArrivalNoteOnTransitData();
    }

    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException {
        BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
    	BarcodeAndState bar2=new BarcodeAndState("0123456790",GoodsState.COMPLETE);
    	BarcodeAndState bar3=new BarcodeAndState("0123456790",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
		BarcodeAndStates.add(bar2);
		BarcodeAndStates.add(bar3);
        ArrivalNoteOnTransitPO mock = new ArrivalNoteOnTransitPO(
                "025001201511260003", "025100", "2011-11-11", "北京", BarcodeAndStates);
        service.insert(mock);
    }

    @Test
    public void test(){
        System.out.println("123");
    }

}
