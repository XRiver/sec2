package businesslogicservice.statisticblservice;

import util.ResultMsg;
import util.enums.PriceType;

/**
 * 总经理调整业务数据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface BusinessDataModificationBLService {
	
	/**
	 * 总经理要求价格常量
	 *
	 * @param price
	 * @return
	 */
	public ResultMsg inputPrice(PriceType type,double price);
	
	/**
	 * 总经理修改城市之间距离
	 *
	 * @param city1
	 * @param city2
	 * @param distance
	 * @return
	 */
	public ResultMsg inputCityDistance(String city1,String city2,double distance);
	
	/**
	 * 总经理核对新的业务数据，要求提交
	 *
	 */
    public ResultMsg submitPrice(PriceType type, double price);

    public ResultMsg submitCityDistance(String city1, String city2, double distance);
}
