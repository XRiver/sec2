package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;
import util.ResultMsg;
import util.enums.TransitType;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class TransitNoteInputDataService_Stub implements TransitNoteInputDataService {

    private TransitNotePO po1;
    private TransitNotePO po2;
    private ArrayList<TransitNotePO> pos;

    public TransitNoteInputDataService_Stub() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("0000111110");
        list.add("0000111111");
        list.add("0000111112");
        list.add("0000111113");
        ArrayList<String> list2 = new ArrayList<String>();
        list.add("2000111110");
        list.add("2000111111");
        list.add("3000111112");
        list.add("4000111113");
        pos = new ArrayList<TransitNotePO>();
        po1 = new TransitNotePO("2015-10-23", "025100201510200000012", "CA1206", TransitType.Aircraft, "南京",
                "西安", "0120", null);
        po2 = new TransitNotePO("2015-10-24", "025100201510200000013", "CZ3151", TransitType.Aircraft, "南京",
                "深圳", "0122", null);
        pos.add(po1);
        pos.add(po2);
    }

     
    public ResultMsg insert(TransitNotePO po) throws RemoteException {
        System.out.println("insert succeed!");
		return null;
    }

    @Override
    public ArrayList<TransitNotePO> getTransitNotePO() throws SQLException {
        return null;
    }


    public boolean delete(TransitNotePO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

     
    public boolean update(TransitNotePO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

     
    public ArrayList<TransitNotePO> find(TransitNotePO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

     
    public ArrayList<TransitNotePO> findAll() throws RemoteException {
        System.out.println("find all succeed!");
        return pos;
    }
}
