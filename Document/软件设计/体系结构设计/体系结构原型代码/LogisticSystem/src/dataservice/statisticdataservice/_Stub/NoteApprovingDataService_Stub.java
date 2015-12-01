package dataservice.statisticdataservice._Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.NotePO;
import businesslogic.util.DocType;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author River
 */
public class NoteApprovingDataService_Stub implements NoteApprovingDataService{

	@Override
	public ArrayList<NotePO> getAllDoc() throws RemoteException {
		System.out.println("returning all note that require approvement");
		return new ArrayList<>();
	}

	@Override
	public ArrayList<NotePO> getDocByType(DocType type) throws RemoteException {
		System.out.println("returning docs of:" + type.toString());
		return new ArrayList<>();
	}

	@Override
	public boolean passDoc(NotePO docPO) throws RemoteException,
			ElementNotFoundException {
		System.out.println("docPO passed");
		return true;
	}

	@Override
	public boolean failDoc(NotePO docPO, String comment)
			throws RemoteException, ElementNotFoundException {
		System.out.println("docPO failed");
		return true;
	}

}
