package connection;

import dataservice.exception.ElementNotFoundException;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import util.ResultMsg;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * @author River
 *
 * 实际需要使用远程对象时，只需新建此对象，然后
 * 调用getObjectByName(String name)即可
 *
 */
public class RemoteObjectGetter {

    private RMIObjectProviderService provider = null;

    public RemoteObjectGetter() {
//        try {
//            RMIHelper.tryConnect();
//            if(RMIHelper.getConnectionStatus()){
                RMIHelper helper = RMIHelper.getInstance();
                provider = helper.getProvider();
//            }else
//                System.out.println("RMIHelper.getConnectionStatus()==失败");
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        }
    }

    public Object getObjectByName(String name) {
        Object object = null;
        try {
            object = provider.getObjectByName(name);
        } catch (RemoteException e) {
            System.out.println("Got remote exception");
            e.printStackTrace();
        }
        return object;
    }


    public static void main(String[] args) throws RemoteException, NotBoundException, SQLException, ElementNotFoundException {
        RMIHelper.tryConnect();

        RemoteObjectGetter getter = new RemoteObjectGetter();
        System.out.println("GOT2");
        Object obj = getter.getObjectByName("ReceivingNoteInputDataService");
        System.out.println("Got3");
        ReceivingNoteInputDataService dataService = (ReceivingNoteInputDataService)obj;
        System.out.println("Got4");
        ResultMsg msg = dataService.insert(null);
        System.out.println(msg.isPass());
    }
}
