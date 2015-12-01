
package businesslogicservice.infoblservice._driver;

import businesslogicservice.infoblservice.SystemUserManagementBLService;
import vo.UserVO;

public class SystemUserManagementBLService_Driver {

	public void drive(SystemUserManagementBLService service){
		
		service.add(new UserVO("0012122", null, null));
		service.delete(new UserVO("0012122", null, null));
		service.find(new UserVO("0012122", null, null));
		service.modify(new UserVO("0012122", null, null),new UserVO("0012122", null, null));
		
	}
	
}
