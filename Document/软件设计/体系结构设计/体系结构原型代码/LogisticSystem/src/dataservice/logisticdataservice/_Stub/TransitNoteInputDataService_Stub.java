package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNoteInputPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class TransitNoteInputDataService_Stub implements TransitNoteInputDataService {

    private TransitNoteInputPO po1;
    private TransitNoteInputPO po2;
    private ArrayList<TransitNoteInputPO> pos;

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
        pos = new ArrayList<TransitNoteInputPO>();
        po1 = new TransitNoteInputPO("2015-10-23","025100201510200000012","CA1206","南京",
                "西安","0120","王小二",list);
        po2 = new TransitNoteInputPO("2015-10-24","025100201510200000013","CZ3151","南京",
                "深圳","0122","西北狼",list2);
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public boolean insert(TransitNoteInputPO po) throws RemoteException {
        System.out.println("insert succeed!");
		return true;
    }

    @Override
    public boolean delete(TransitNoteInputPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

    @Override
    public boolean update(TransitNoteInputPO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

    @Override
    public ArrayList<TransitNoteInputPO> find(TransitNoteInputPO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<TransitNoteInputPO> findAll() throws RemoteException {
        System.out.println("find all succeed!");
        return pos;
    }
}
