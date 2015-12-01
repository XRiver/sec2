package po;

import java.io.Serializable;

/**
* @author River
* 具体实例化时，本类才有意义，故构造器在实现子类时再写
*/
public class ChartPO implements Serializable {

	private static final long serialVersionUID = -4037472160296700871L;
	
	public static final int COST_AND_PROFIT = 0;
	public static final int BUSINESS_STATE = 1;
	
	
	/**
	 * 用整数表示表格种类
	 */
	int type = -1;
	
	/**
	 * 用字符串表示开始时间、结束时间
	 */
	String startTime = null;
	String endTime = null;
	
}
