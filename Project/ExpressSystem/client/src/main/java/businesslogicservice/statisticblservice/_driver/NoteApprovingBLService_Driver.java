package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import vo.NoteVO;

public class NoteApprovingBLService_Driver {

	public void drive(NoteApprovingBLService service){

		if(service.getAllDoc()!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Null return");
		}

		
		service.passAllDoc();

		service.passDoc(new NoteVO(){});
		
		service.inputAdvice(new NoteVO(){}, "declined");
	}
	
}
