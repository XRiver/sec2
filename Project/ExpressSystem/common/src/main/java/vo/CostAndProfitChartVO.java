package vo;

import util.enums.ChartType;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/21.
 */
public class CostAndProfitChartVO extends ChartVO {

    private ArrayList<Double> cost;
    private ArrayList<Double> profit;

    public CostAndProfitChartVO(String starttime, String endtime, ArrayList<Double> cost,
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

    public CostAndProfitChartVO(String starttime, String endtime){
        super(ChartType.PROFIT_CHART,starttime,endtime);
    }
}
