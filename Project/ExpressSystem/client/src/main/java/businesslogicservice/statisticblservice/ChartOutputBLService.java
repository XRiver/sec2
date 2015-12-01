package businesslogicservice.statisticblservice;

import util.ResultMsg;
import util.enums.ChartType;
import vo.ChartVO;

/**
 * 财务人员或者总经理（以下简称用户）获取统计报表逻辑接口
 * 
 * @author kylin
 *
 */
public interface ChartOutputBLService {

	/**
	 * 查看报表操作
	 *
	 * @param chartType 报表类型
	 * @param time1 起点时间
	 * @param time2 终点时间
	 * @return
	 */
	public ResultMsg enquiryChart(ChartType chartType,String time1,String time2);
	
	/**
	 * 系统显示起止时间内的相应类型的报表信息
	 *
	 * @return
	 */
	public ChartVO getChartVO(ChartType chartType,String time1,String time2);
	
	/**
	 * 导出报表操作
	 *
	 * @param path
	 */
	public ResultMsg exportChart(ChartVO inputChartVO, String path);
}
