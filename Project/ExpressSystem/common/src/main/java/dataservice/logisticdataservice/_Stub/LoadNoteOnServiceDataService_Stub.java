package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import po.LoadNoteOnServicePO;
import util.ResultMsg;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnServiceDataService_Stub implements LoadNoteOnServiceDataService {

    private LoadNoteOnServicePO po1;
    private LoadNoteOnServicePO po2;
    private ArrayList<LoadNoteOnServicePO> pos;

    public LoadNoteOnServiceDataService_Stub() {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000001");
        codes.add("0000000002");
        codes.add("0000000003");
        po1 = new LoadNoteOnServicePO("2015-10-22","0251001","0251001201510220001","上海","苏A 00001","泰勒",
                "小李子",codes);
        po2 = new LoadNoteOnServicePO("2015-10-23","0251001","0251001201510220002","上海","苏A 00002","Tom Hanks",
                "Bridy",codes);
        pos = new ArrayList<LoadNoteOnServicePO>();
        pos.add(po1);
        pos.add(po2);
    }

     
    public ResultMsg insert(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("insert succeed!");
		return null;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> getLoadNoteOnService() throws SQLException {
        return null;
    }


    public boolean delete(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

     
    public boolean update(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

     
    public ArrayList<LoadNoteOnServicePO> find(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

     
    public ArrayList<LoadNoteOnServicePO> findAll() throws RemoteException {
        System.out.println("show succeed!");
        return pos;
    }
}
