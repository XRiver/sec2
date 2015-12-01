package businesslogicservice.statisticblservice._stub;

import businesslogicservice.statisticblservice.ChartOutputBLService;
import util.ResultMsg;
import util.enums.ChartType;
import vo.ChartVO;

public class ChartOutputBLService_Stub implements ChartOutputBLService {

	
	public ResultMsg enquiryChart(ChartType chartType,String time1,String time2){
		System.out.println("enquirying chart:" );
		return new ResultMsg(true, "Success!");
	}

	public ChartVO getChartVO(ChartType chartType, String time1, String time2) {
		System.out.println("getChartVO!");
		return new ChartVO(ChartType.BUSINESS_STAT_CHART,"2015-10-22","2015-11-1");
	}

    @Override
    public ResultMsg exportChart(ChartVO inputChartVO, String path) {
        return null;
    }

}
