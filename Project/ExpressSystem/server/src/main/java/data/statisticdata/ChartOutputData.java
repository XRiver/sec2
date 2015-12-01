package data.statisticdata;
/**
 * @author wwz
 * @date 2015/11/14
 */
import java.rmi.RemoteException;

import po.ChartPO;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;
import dataservice.statisticdataservice.ChartOutputDataService;

public class ChartOutputData implements ChartOutputDataService{

	@Override
	public BusinessStateChartPO getBusinessStateChart(BusinessStateChartPO po)
			throws RemoteException {
        String startTime = po.getStartTime();
        String endTime = po.getEndTime();

		return null;
	}

	@Override
	public CostAndProfitChartPO getCostAndProfitChart(CostAndProfitChartPO po)
			throws RemoteException {
		return null;
	}

	
}
