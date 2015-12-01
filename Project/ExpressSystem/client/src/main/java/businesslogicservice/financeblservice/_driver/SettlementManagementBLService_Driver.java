package businesslogicservice.financeblservice._driver;

import vo.IncomeNoteVO;
import businesslogicservice.financeblservice.SettlementManagementBLService;

public class SettlementManagementBLService_Driver {

	public void drive(SettlementManagementBLService service){
		service.addReceiveRecord(new IncomeNoteVO("110", "2013-05-12", null, null, null, null));
		service.find(new IncomeNoteVO("110", "2013-05-12", null, null, null, null));
	}
}
