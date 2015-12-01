package dataservice.logisticdataservice._Stub;


import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/20.
 */
public class ArrivalNoteOnServiceDataService_Stub implements ArrivalNoteOnServiceDataService {
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO2;
	private ArrayList<ArrivalNoteOnServicePO> pos;

	public ArrivalNoteOnServiceDataService_Stub() {
		BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
        pos = new ArrayList<ArrivalNoteOnServicePO>();
        arrivalNoteOnServicePO = new ArrivalNoteOnServicePO("2011-11-11",true,"250000201510130000000",
        		"北京",BarcodeAndStates);
        arrivalNoteOnServicePO2 = new ArrivalNoteOnServicePO("2011-11-12",true,"250000201510130000000",
                "北京",BarcodeAndStates);
		pos.add(arrivalNoteOnServicePO);
        pos.add(arrivalNoteOnServicePO2);
	}


    @Override
    public ResultMsg insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
        System.out.println("insertArrivalNote success");
        return new ResultMsg(true);
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> getArrivalNoteOnService() throws SQLException {
        return null;
    }

    @Override
    public ResultMsg insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        System.out.println("insertDeliverNote success");
        return null;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> getDeliverNoteOnService() throws SQLException {
        return null;
    }

}
