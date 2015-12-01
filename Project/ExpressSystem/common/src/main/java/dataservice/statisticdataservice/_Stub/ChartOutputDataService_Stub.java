package dataservice.statisticdataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.statisticdataservice.ChartOutputDataService;
import po.ChartPO;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;

public class ChartOutputDataService_Stub implements ChartOutputDataService{

	@Override
	public BusinessStateChartPO getBusinessStateChart(BusinessStateChartPO po)
			throws RemoteException {
		System.out.println("获取经营情况表成功");
		return null;
	}

	@Override
	public CostAndProfitChartPO getCostAndProfitChart(CostAndProfitChartPO po)
			throws RemoteException {
		System.out.println("获取成本收益表成功");
		return null;
	}

	
   
}
