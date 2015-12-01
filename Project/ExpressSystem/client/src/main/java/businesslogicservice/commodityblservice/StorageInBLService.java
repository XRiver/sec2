/**
 * 入库处理业务逻辑接口
 * @author wwz
 * @data 2015/10/17
 */
package businesslogicservice.commodityblservice;

import util.ResultMsg;
import util.enums.InventoryStatus;
import vo.StorageInVO;

public interface StorageInBLService {
	
	/**
	 * 新增入库单
	 * @param putInStorageVo
	 * @return
	 */
	public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo);
	
	/**
	 * 提交入库单信息
	 * @param putInStorageVo
	 * @return
	 */
   public ResultMsg submitPutInStorageDoc(StorageInVO putInStorageVo);
   
   /**
    * 库存报警
    * @return
    */
   public InventoryStatus alarm();

      
}
