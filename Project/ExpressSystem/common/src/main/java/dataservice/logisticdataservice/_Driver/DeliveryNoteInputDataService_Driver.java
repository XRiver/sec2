package dataservice.logisticdataservice._Driver;

import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import dataservice.logisticdataservice._Stub.DeliveryNoteInputDataService_Stub;
import po.DeliveryNotePO;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/10/21.
 */
public class DeliveryNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException, SQLException, ElementNotFoundException {
        DeliveryNoteInputDataService service = new DeliveryNoteInputDataService_Stub();
        DeliveryNoteInputDataService_Driver driver = new DeliveryNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(DeliveryNoteInputDataService service) throws RemoteException, SQLException, ElementNotFoundException {
        DeliveryNotePO po1 = new DeliveryNotePO("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2,DeliverCategory.EXPRESS,5,"0000000001");

        DeliveryNotePO po2 = new DeliveryNotePO("王三狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2,DeliverCategory.EXPRESS,5,"0000000002");;
        if(service.insert(po1).getPrice() == 100)
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po2).getPrice() == 50)
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");

    }
}
