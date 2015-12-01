package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.LogInquiryBLService;
import vo.SystemLogVO;

public class LogInquiryBLService_Driver {
	

	public void drive(LogInquiryBLService service){
		
		if(service.inputKeywords(new SystemLogVO("2015-02-12",null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.getLogInfo(new SystemLogVO("2015-02-12",null))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Null return");
		}
	}
	
}
