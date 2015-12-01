package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.ChartOutputBLService;

public class ChartOutputBLService_Driver {

	
	public void drive(ChartOutputBLService service){
		if(service.enquiryChart(null, null, null).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.getChartVO()!=null){
			System.out.println("Got chartVO");
		}else{
			System.out.println("Null return");
		}
		
		if(service.exportChart("C:/").isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
	}
}
