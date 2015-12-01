package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNoteInputPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class DeliveryNoteInputDataService_Stub implements DeliveryNoteInputDataService {

    private DeliveryNoteInputPO po1;
    private DeliveryNoteInputPO po2;
    private ArrayList<DeliveryNoteInputPO> pos;

    public DeliveryNoteInputDataService_Stub() {
        po1 = new DeliveryNoteInputPO("王二狗","江苏省南京市栖霞区南京大学仙林校区","南京大学仙林校区",
                "150052120000","1",0.5,20,"离散数学","书籍",5,"1234567890");
        po2 = new DeliveryNoteInputPO("kylin","江苏省南京市栖霞区南京大学仙林校区","南京大学仙林校区",
                "150052126666","1",0.5,20,"head first java","书籍",5,"1234567891");
        pos = new ArrayList<DeliveryNoteInputPO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public boolean insert(DeliveryNoteInputPO po) throws RemoteException {
        System.out.println("insert succeed!");
		return true;
    }

    @Override
    public boolean delete(DeliveryNoteInputPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

    @Override
    public boolean update(DeliveryNoteInputPO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

    @Override
    public ArrayList<DeliveryNoteInputPO> find(DeliveryNoteInputPO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<DeliveryNoteInputPO> findAll() throws RemoteException {
        System.out.println("find all succeed!");
        return pos;
    }
}
