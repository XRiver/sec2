package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.NoteDataService;
import po.NotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class NoteDataService_Stub implements NoteDataService {

    private NotePO po1;
    private NotePO po2;
    private ArrayList<NotePO> pos;

    public NoteDataService_Stub() {
        po1 = new NotePO();
        po2 = new NotePO();
        pos = new ArrayList<NotePO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public boolean insert(NotePO po) throws RemoteException {
        System.out.println("insert succeed!");
		return true;
    }

    @Override
    public boolean delete(NotePO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

    @Override
    public boolean update(NotePO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

    @Override
    public ArrayList<NotePO> find(NotePO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<NotePO> findAll() throws RemoteException {
        System.out.println("find All succeed!");
        return pos;
    }

    @Override
    public void init() throws RemoteException {
        System.out.println("init succeed!");
    }

    @Override
    public void finish() throws RemoteException {
        System.out.println("finish succeed!");
    }
}
