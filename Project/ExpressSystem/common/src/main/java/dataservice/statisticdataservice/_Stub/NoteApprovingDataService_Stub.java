package dataservice.statisticdataservice._Stub;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.*;
import util.enums.DocType;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author River
 */
public class NoteApprovingDataService_Stub implements NoteApprovingDataService{

	 
	public ArrayList<NotePO> getAllDoc() throws RemoteException {
		System.out.println("returning all note that require approvement");
		return new ArrayList<NotePO>();
	}

	 
	public ArrayList<NotePO> getDocByType(DocType type) throws RemoteException {
		System.out.println("returning docs of:" + type.toString());
		return new ArrayList<NotePO>();
	}


    @Override
    public ArrayList<ArrivalNoteOnServicePO> getArrivalNoteOnServicePO() throws RemoteException, SQLException {
        return null;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> getDeliverNoteOnServicePO() throws RemoteException, SQLException {
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> getArrivalNoteOnTransitPO() throws RemoteException, SQLException {
        return null;
    }

    @Override
    public ArrayList<DeliveryNotePO> getDeliveryNotePO() throws RemoteException, SQLException {
        return null;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> getLoadNoteOnServicePO() throws RemoteException, SQLException {
        return null;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> getLoadNoteOnTransitPO() throws RemoteException, SQLException {
        return null;
    }

    @Override
    public ArrayList<ReceivingNotePO> getReceivingNotePO() throws RemoteException, SQLException {
        return null;
    }

    @Override
    public ArrayList<TransitNotePO> getTransitNotePO() throws RemoteException, SQLException {
        return null;
    }

    public boolean passDoc(NotePO docPO) throws RemoteException,
			ElementNotFoundException {
		System.out.println("docPO passed");
		return true;
	}

	 
	public boolean failDoc(NotePO docPO, String comment)
			throws RemoteException, ElementNotFoundException {
		System.out.println("docPO failed");
		return true;
	}

}
