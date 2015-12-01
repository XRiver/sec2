package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import util.SendDocMsg;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class DeliveryNoteInputDataService_Stub implements DeliveryNoteInputDataService {

    private DeliveryNotePO po1;
    private DeliveryNotePO po2;
    private ArrayList<DeliveryNotePO> pos;

    public DeliveryNoteInputDataService_Stub() {
        po1 = new DeliveryNotePO("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2,DeliverCategory.EXPRESS,5,"0000000001");

        po2 = new DeliveryNotePO("王三狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2,DeliverCategory.EXPRESS,5,"0000000002");
        pos = new ArrayList<DeliveryNotePO>();
        pos.add(po1);
        pos.add(po2);
    }


    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException {
        System.out.println("insert succeed!");
        return new SendDocMsg(true, "pass", 100, "2015-12-12");
    }

    @Override
    public ArrayList<DeliveryNotePO> getDeliveryNote() throws SQLException {
        return null;
    }


    public boolean delete(DeliveryNotePO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

     
    public boolean update(DeliveryNotePO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

     
    public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

     
    public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
        System.out.println("find all succeed!");
        return pos;
    }
}
