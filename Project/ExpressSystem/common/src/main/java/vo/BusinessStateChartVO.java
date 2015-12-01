package vo;

import util.enums.ChartType;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/21.
 */
public class BusinessStateChartVO extends ChartVO{

    private ArrayList<Double> profix;
    private ArrayList<Double> growthRate;

    public BusinessStateChartVO(String starttime, String endtime, ArrayList<Double> profix,
                                ArrayList<Double> growthRate) {
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
        this.profix = profix;
        this.growthRate = growthRate;
    }

    public BusinessStateChartVO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
    }

    public ArrayList<Double> getProfix() {
        return profix;
    }

    public ArrayList<Double> getGrowthRate() {
        return growthRate;
    }

}
