package businesslogicservice.financeblservice._driver;

import vo.CreditNoteVO;
import businesslogicservice.financeblservice.CreditNoteInputBLService;

public class CreditNoteInputBLService_Driver {

	public void drive(CreditNoteInputBLService service){
		if(service.addReceipeDoc(new CreditNoteVO("2005-02-21", "32", null, null)).isPass()){
			System.out.println("Pass");
		}else{
			System.out.println("Fail to add receipe doc");
		}
		
		if(service.submitReceipeDoc(new CreditNoteVO("2005-02-21", "32", null, null)).isPass()){
			System.out.println("Pass");
		}else{
			System.out.println("Fail to submit receipe doc");
		}
	}

}
