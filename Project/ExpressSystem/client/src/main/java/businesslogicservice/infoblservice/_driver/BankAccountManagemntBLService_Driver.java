package businesslogicservice.infoblservice._driver;

import vo.BankAccountVO;
import businesslogicservice.infoblservice.BankAccountManagementBLService;

public class BankAccountManagemntBLService_Driver  {

	public void drive(BankAccountManagementBLService service){
		service.add(new BankAccountVO("sd", "1234567", "1.50"));
		service.delete(new BankAccountVO("sd", "1234567","1.50"));
		service.find(new BankAccountVO("sd", "1234567", "1.50"));
		service.show();
		service.update(new BankAccountVO("sd", "1234567", "1.50"));
	}
	
}
