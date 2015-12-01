package businesslogicservice.financeblservice._driver;

import vo.BankAccountVO;
import businesslogicservice.financeblservice.BankAccountManagementBLService;

public class BankAccountManagemntBLService_Driver  {

	public void drive(BankAccountManagementBLService service){
		if(service.add(new BankAccountVO("sd", "1234567", 1.50)).isPass()){
			System.out.println("Pass");
		}else{
			System.out.println("Fail to add bank account");
		}
		
		if(service.delete(new BankAccountVO("sd", "1234567", 1.50)).isPass()){
			System.out.println("Pass");
		}else{
			System.out.println("Fail to delete bank account");
		}
		
		if(service.find(new BankAccountVO("sd", "1234567", 1.50))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Fail to find");
		}
		
		if(service.update(new BankAccountVO("sd", "1234567", 1.50)).isPass()){
			System.out.println("Pass");
		}else{
			System.out.println("Fail to update bank account");
		}

		if(service.show()!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Fail to find");
		}
		
	}
	
}
