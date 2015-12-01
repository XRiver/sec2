package data.statisticdata.MockObject;
/**
 *@author  wwz
 * @time 2015/11/14
 */
import po.chart.CostAndProfitChartPO;
import util.enums.ChartType;

public class MockCostAndProfitChart extends CostAndProfitChartPO{


    public MockCostAndProfitChart(String starttime, String endtime,
                                  double cost, double profit) {
        super(starttime, endtime, null, null);
    }
}
