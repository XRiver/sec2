package data.statisticdata;
/**
 *@author  wwz
 * @time 2015/11/15
 */
import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import util.enums.ChartType;
import data.statisticdata.MockObject.MockBusinessStateChart;
import data.statisticdata.MockObject.MockCostAndProfitChart;
import dataservice.statisticdataservice.ChartOutputDataService;

public class ChartOutput_Test {
    
	private ChartOutputDataService service = new ChartOutputData();
	@Test
	public void testGetChart() throws RemoteException {
		
		MockBusinessStateChart businessStateChart = new MockBusinessStateChart("2015-01-01","2015-06-01",200000,0.05);
		
		//assertEquals("2015-01-01",service.getBusinessStateChart(businessStateChart).getStarttime());
		//assertEquals("2015-06-01",service.getBusinessStateChart(businessStateChart).getEndtime());
	    //assertEquals(ChartType.BUSINESS_STAT_CHART,service.getBusinessStateChart(businessStateChart).getType());
		
	}
    @Test
	public void testGetCostAndProfitChart() throws RemoteException{
		MockCostAndProfitChart costAndProfitChart =new MockCostAndProfitChart("2015-10-10","2015-11-11",100000,200000);
		//assertEquals("2015-10-10",service.getCostAndProfitChart(costAndProfitChart).getStarttime());
		//assertEquals("2015-11-11",service.getCostAndProfitChart(costAndProfitChart).getEndtime());
		//assertEquals(ChartType.PROFIT_CHART,service.getCostAndProfitChart(costAndProfitChart).getType());
	}

}
