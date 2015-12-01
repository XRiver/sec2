package connection;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/10.
 */
public interface RMIObjectProviderService extends Remote {
    public Object getObjectByName(String name) throws RemoteException;
}
