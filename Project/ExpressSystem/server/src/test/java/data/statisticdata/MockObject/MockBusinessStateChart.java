package data.statisticdata.MockObject;
/**
 * @author wwz
 * @time 2015/11/15
 */
import po.chart.BusinessStateChartPO;
import util.enums.ChartType;

public class MockBusinessStateChart extends BusinessStateChartPO{

    public MockBusinessStateChart(String starttime, String endtime, double profix, double growthRate) {
        super(starttime, endtime, null,null);
    }
}

