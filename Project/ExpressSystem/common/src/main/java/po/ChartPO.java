package po;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.enums.ChartType;

/**
* @author River
* 具体实例化时，本类才有意义，故构造器在实现子类时再写
*/
public class ChartPO implements Serializable {

	private static final long serialVersionUID = -4037472160296700871L;
	
	public static final int COST_AND_PROFIT = 0;
	public static final int BUSINESS_STATE = 1;
	/**
	 * 用字符串表示开始时间、结束时间
	 */
	private String startTime;
	private String endTime ;
	private ChartType type;

    private ArrayList<String> everyDay;

    public ChartPO(ChartType type,String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.everyDay = this.calculateDays(this.startTime,this.endTime);
    }

    private ArrayList<String> calculateDays(String startTime, String endTime) {
        ArrayList<String> everyDay = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDay = dateFormat.parse(startTime);
            Date endDay = dateFormat.parse(endTime);
            Date days = startDay;
            String strDay = dateFormat.format(days);
            while (days.before(endDay)){
                everyDay.add(strDay);
                days = new Date(days.getTime() + 24 * 60 * 60 * 1000);
                strDay = dateFormat.format(days);
            }
            strDay = dateFormat.format(endDay);
            everyDay.add(strDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return everyDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public ChartType getType() {
        return type;
    }
}
