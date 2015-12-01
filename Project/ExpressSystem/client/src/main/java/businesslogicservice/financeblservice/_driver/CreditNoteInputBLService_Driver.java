package businesslogicservice.financeblservice._driver;

import vo.CreditNoteVO;
import businesslogicservice.financeblservice.CreditNoteInputBLService;

public class CreditNoteInputBLService_Driver {

	public void drive(CreditNoteInputBLService service){
		service.addReceipeDoc(new CreditNoteVO("2005-02-21", "32", null, null));
		service.submitReceipeDoc(new CreditNoteVO("2005-02-21", "32", null, null));
	}

}
