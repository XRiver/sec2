/**
 * 库存查看
 * @author wwz
 * @data  2015/10/17
 */

package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.InventoryVO;

public interface StorageInquiryPartBLService {
	
	/**
	 * 输入查看时间段
	 * @param time1
	 * @param time2
	 * @return
	 */
  public ResultMsg inputTime(String time1,String time2);
 
  /**
   * 显示该时间段的信息
   * @param time1
   * @param time2
   * @return
   */
  public ArrayList<InventoryVO> show(String time1,String time2);
  
}
