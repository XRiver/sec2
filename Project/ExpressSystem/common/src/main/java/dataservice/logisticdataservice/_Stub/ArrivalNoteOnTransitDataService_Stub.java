package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class ArrivalNoteOnTransitDataService_Stub implements ArrivalNoteOnTransitDataService {

    private ArrivalNoteOnTransitPO po1;
    private ArrivalNoteOnTransitPO po2;
    private ArrayList<ArrivalNoteOnTransitPO> pos;

    public ArrivalNoteOnTransitDataService_Stub() {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
        po1 = new ArrivalNoteOnTransitPO("025100201510200000001","025100","2011-11-11","北京",BarcodeAndStates);
        po2 = new ArrivalNoteOnTransitPO("025100201510200000002","025100","2011-11-11","上海",BarcodeAndStates);
        pos = new ArrayList<ArrivalNoteOnTransitPO>();
        pos.add(po1);
        pos.add(po2);
    }


    public ResultMsg insert(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("insert succeed!");
        return new ResultMsg(true);
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> getArrivalNoteOnTransit() throws SQLException {
        return null;
    }


    public boolean delete(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

     
    public boolean update(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

     
    public ArrayList<ArrivalNoteOnTransitPO> find(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

     
    public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException {
        System.out.println("findAll succeed!");
        return pos;
    }
}
