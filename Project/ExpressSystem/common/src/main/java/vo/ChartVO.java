package vo;

import util.FormatCheck;

import po.ChartPO;
import util.ResultMsg;
import util.enums.ChartType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 表格VO
 * 
 * @author kylin
 *
 */
public class ChartVO {

	/**
	 * 报表类型
	 */
	ChartType type;
	
	/**
	 * 报表起止时间
	 */
	String time1;
	String time2;

    ArrayList<String> everyday;

    public ChartVO(ChartType type, String time1, String time2) {
        this.type = type;
        this.time1 = time1;
        this.time2 = time2;
        this.everyday = this.calculateDays(this.time1,this.time2);
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

    public ChartType getType() {
        return type;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    public ResultMsg checkFormat(){
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[2];
        results[0] = FormatCheck.isDate(this.time1);
        results[1] = FormatCheck.isDate(this.time2);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass())
                return results[i];
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDay = dateFormat.parse(this.time1);
            Date endDay = dateFormat.parse(this.time2);
            if(startDay.before(endDay))
                return new ResultMsg(false,"起点日期不能在终点日期之后!");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<String> getEveryday() {
        return everyday;
    }

    public void setEveryday(ArrayList<String> everyday) {
        this.everyday = everyday;
    }
}
