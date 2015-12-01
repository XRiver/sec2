package dataservice.statisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ChartPO;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;

/**
 * @author River
 */
public interface ChartOutputDataService extends Remote, Serializable {

	/**
	 * Data返回封装了详细数据的ChartPO
	 *
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public BusinessStateChartPO getBusinessStateChart(BusinessStateChartPO po)
			throws RemoteException;
	
	public CostAndProfitChartPO getCostAndProfitChart(CostAndProfitChartPO po) 
			throws RemoteException;
	
}
