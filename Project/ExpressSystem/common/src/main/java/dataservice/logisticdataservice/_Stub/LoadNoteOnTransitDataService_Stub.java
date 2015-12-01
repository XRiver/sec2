package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;
import util.ResultMsg;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnTransitDataService_Stub implements LoadNoteOnTransitDataService {

    private LoadNoteOnTransitPO po1;
    private LoadNoteOnTransitPO po2;
    private ArrayList<LoadNoteOnTransitPO> pos;


    public LoadNoteOnTransitDataService_Stub() {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000004");
        codes.add("0000000005");
        ArrayList<String> codes2 = new ArrayList<String>();
        codes2.add("0000000006");
        codes2.add("0000000019");
        codes2.add("0000000020");
        codes2.add("0000000030");
        po1 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "朱梦晴","武昌昊","",codes);
        po2 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "李沪东","吴大爷","",codes2);
        pos = new ArrayList<LoadNoteOnTransitPO>();
        pos.add(po1);
        pos.add(po2);
    }

     
    public ResultMsg insert(LoadNoteOnTransitPO po) throws RemoteException {
        System.out.println("insert succeed!");
		return null;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> getLoadNoteOnTransit() throws SQLException {
        return null;
    }


    public boolean delete(LoadNoteOnTransitPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

     
    public boolean update(LoadNoteOnTransitPO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

     
    public ArrayList<LoadNoteOnTransitPO> find(LoadNoteOnTransitPO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

     
    public ArrayList<LoadNoteOnTransitPO> findAll() throws RemoteException {
        System.out.println("findAll succeed!");
        return pos;
    }
}
