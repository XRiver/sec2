package businesslogicservice.commodityblservice;

import businesslogic.util.ResultMsg;
import vo.StorageOutVO;

public interface StorageOutBLService {
		
	/**
	 * 输入出库单信息
	 * @param storageOutVo
	 * @return
	 */
	public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo);
	
	/**
	 * 提交出库单
	 * @param storageOutVo
	 * @return
	 */
	public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo);
	
}
