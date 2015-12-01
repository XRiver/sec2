package vo;

import businesslogic.util.ChartType;

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

    public ChartVO(ChartType type, String time1, String time2) {
        this.type = type;
        this.time1 = time1;
        this.time2 = time2;
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
}
