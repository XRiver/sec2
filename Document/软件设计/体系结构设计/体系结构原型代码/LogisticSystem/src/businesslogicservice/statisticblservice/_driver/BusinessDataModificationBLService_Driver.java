package businesslogicservice.statisticblservice._driver;

import businesslogic.util.PriceType;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;


public class BusinessDataModificationBLService_Driver {
	
	public void drive(BusinessDataModificationBLService service){
		
		if(service.inputCityDistance("c1", "c2", 23).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.inputPrice(PriceType.PricePerKg,1.0).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		service.submitChange();
	}
}
