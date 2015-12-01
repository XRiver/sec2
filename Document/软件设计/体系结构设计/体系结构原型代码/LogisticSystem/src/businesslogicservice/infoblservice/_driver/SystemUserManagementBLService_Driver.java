
package businesslogicservice.infoblservice._driver;

import businesslogicservice.infoblservice.SystemUserManagementBLService;
import vo.UserVO;

public class SystemUserManagementBLService_Driver {

	public void drive(SystemUserManagementBLService service){
		if(service.add(new UserVO("0012122", null, null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.delete(new UserVO("0012122", null, null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.modify(new UserVO("0012122", null, null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.find(new UserVO("0012122", null, null))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Null return");
		}

	}
	
}
