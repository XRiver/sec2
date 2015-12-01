package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.ChartOutputBLService;
import util.enums.ChartType;

public class ChartOutputBLService_Driver {


	public void drive(ChartOutputBLService service){
		if(service.enquiryChart(ChartType.BUSINESS_STAT_CHART, "2015-10-22", "2015-11-1").isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.getChartVO(ChartType.BUSINESS_STAT_CHART, "2015-10-22", "2015-11-1")!=null){
			System.out.println("Got chartVO");
		}else{
			System.out.println("Null return");
		}

		
	}
}
