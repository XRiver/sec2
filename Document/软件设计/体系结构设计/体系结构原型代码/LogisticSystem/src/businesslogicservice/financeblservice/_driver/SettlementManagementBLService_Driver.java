package businesslogicservice.financeblservice._driver;

import vo.ReceiveRecordVO;
import businesslogicservice.financeblservice.SettlementManagementBLService;

public class SettlementManagementBLService_Driver {

	public void drive(SettlementManagementBLService service){
		if(service.addReceiveRecord(new ReceiveRecordVO("110", "2013-05-12", null, null, null, null)).isPass()){
			System.out.println("Pass");
		}else{
			System.out.println("Fail to add receive record");
		}
		
		if(service.find(new ReceiveRecordVO("110", "2013-05-12", null, null, null, null))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Fail to find");
		}
		
	}
}
