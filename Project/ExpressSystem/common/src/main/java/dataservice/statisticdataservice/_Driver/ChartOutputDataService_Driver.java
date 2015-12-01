package dataservice.statisticdataservice._Driver;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.statisticdataservice.ChartOutputDataService;
import dataservice.statisticdataservice._Stub.ChartOutputDataService_Stub;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;

public class ChartOutputDataService_Driver {
	private BusinessStateChartPO po1;
	private CostAndProfitChartPO po2;

	public ChartOutputDataService_Driver() {
		 po1 = new BusinessStateChartPO("2015-10-10","2015-11-11",null,null);
		
		 //po2 = new CostAndProfitChartPO("2015-10-10","2015-11-11",2000.0,3000.0);
	}
	
	public void drive(ChartOutputDataService coDataService) throws RemoteException {
		coDataService.getBusinessStateChart(po1);
		//coDataService.getCostAndProfitChart(po2);
	}
	
	public static void main(String[] args) throws RemoteException {
		ChartOutputDataService_Stub stub = new ChartOutputDataService_Stub();
		ChartOutputDataService_Driver driver = new ChartOutputDataService_Driver();
		driver.drive(stub);
	}
	
	
	

}
