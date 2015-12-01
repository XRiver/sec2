package dataservice.statisticdataservice._Driver;

import java.rmi.RemoteException;

import po.NotePO;
import businesslogic.util.DocType;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author River
 */
public class NoteApprovingDataService_Driver {

	public void drive(NoteApprovingDataService data) throws RemoteException, ElementNotFoundException {
		if(data.getAllDoc()!=null){
			System.out.println("Got array list");
		}else{
			System.out.println("Failed to get list");
		}
		
		if(data.getDocByType(DocType.Arrival_Note_On_Service)!=null){
			System.out.println("Got array list");
		}else{
			System.out.println("Failed to get list");
		}
		
		if(data.passDoc(new NotePO())){
			System.out.println("Success");
		}else{
			System.out.println("Failed");
		}
		
		if(data.failDoc(new NotePO(), "不行")){
			System.out.println("Success");
		}else{
			System.out.println("Failed");
		}
	}
	
}
