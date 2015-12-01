package businesslogicservice.commodityblservice._Stub;

import vo.StorageOutVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.commodityblservice.StorageOutBLService;

public class StorageOutBLService_Stub implements StorageOutBLService{


	@Override
	public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo) {
		if(storageOutVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"输入的出库单格式正确");
		else
			return new ResultMsg(false,"输入的出库单格式不正确");
	}

	@Override
	public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo) {
		if(storageOutVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
