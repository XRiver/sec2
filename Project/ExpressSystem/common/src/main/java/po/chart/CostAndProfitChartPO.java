package po.chart;

import po.ChartPO;
import util.enums.ChartType;

import java.util.ArrayList;

public class CostAndProfitChartPO extends ChartPO {

	private static final long serialVersionUID = 7891756031310926806L;
    private ArrayList<Double> cost;
    private ArrayList<Double> profit;

    public CostAndProfitChartPO(String starttime, String endtime, ArrayList<Double> cost,
                                ArrayList<Double> profit) {
        super(ChartType.PROFIT_CHART,starttime,endtime);
        this.cost = cost;
        this.profit = profit;
    }

    public ArrayList<Double> getCost() {
        return cost;
    }

    public ArrayList<Double> getProfit() {
        return profit;
    }

    public CostAndProfitChartPO(String starttime, String endtime){
        super(ChartType.PROFIT_CHART,starttime,endtime);
    }
	
}
