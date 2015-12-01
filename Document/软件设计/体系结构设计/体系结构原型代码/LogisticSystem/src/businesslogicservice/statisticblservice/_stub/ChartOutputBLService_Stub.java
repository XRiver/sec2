package businesslogicservice.statisticblservice._stub;

import businesslogic.util.ChartType;
import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.ChartOutputBLService;
import vo.ChartVO;

public class ChartOutputBLService_Stub implements ChartOutputBLService {

	
	public ResultMsg enquiryChart(ChartType chartType,String time1,String time2){
		System.out.println("enquirying chart:" );
		return new ResultMsg(true, "Success!");
	};
	
	
	public ChartVO getChartVO(){
		System.out.println("returning chart");
		return new ChartVO(null, null, null);
	};
	
	
	public ResultMsg exportChart(String path){
		System.out.println("Exported!");
		return new ResultMsg(true, "Success!");
	};
}
