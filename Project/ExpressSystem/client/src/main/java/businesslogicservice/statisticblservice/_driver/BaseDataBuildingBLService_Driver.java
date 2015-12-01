package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.BaseDataBuildingBLService;

public class BaseDataBuildingBLService_Driver {
	
	public void drive(BaseDataBuildingBLService service){
		if(service.restartWithoutBasis().isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}

		if(service.restartWithBasis().isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}

	}
}
