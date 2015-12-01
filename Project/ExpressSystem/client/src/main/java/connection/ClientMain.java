package connection;

import dataservice.infodataservice.SystemUserManagementDataService;
import po.UserPO;
import util.enums.Authority;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/21.
 */
public class ClientMain {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        RemoteObjectGetter objectGetter = new RemoteObjectGetter();
        SystemUserManagementDataService dataService =
                (SystemUserManagementDataService) objectGetter.getObjectByName("ReceivingNoteInputDataService");
        System.out.println("客户端得到SystemUserManagementDataService");
//        try {
//            ArrayList<UserPO> result = dataService.getAllUsers();
//            for (UserPO po:result) {
//                System.out.println(po);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
