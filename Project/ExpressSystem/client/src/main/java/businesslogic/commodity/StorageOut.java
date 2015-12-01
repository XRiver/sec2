package businesslogic.commodity;

import po.StorageOutPO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageOutDataService;
import businesslogic.info.RuntimeUserInfo;
import businesslogicservice.commodityblservice.StorageOutBLService;
import util.ResultMsg;
import vo.StorageOutVO;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 */
public class StorageOut implements StorageOutBLService {
	
	StorageOutDataService dataService = null;
	
	public StorageOut() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (StorageOutDataService) getter.getObjectByName("StorageOutDataService");
	}
	
    @Override
    public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo) {
    	ResultMsg msg = storageOutVo.checkFormat();
        	return msg;
    }

    @Override
    public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo) {
        try {
        	boolean result = dataService.insert((StorageOutPO) storageOutVo.toPO(),RuntimeUserInfo.getNum());
        	if(!result) {
        		return new ResultMsg(false,"提交出库单失败，请重试");
        	}
        } catch (Exception e) {
        	return new ResultMsg(false,e.getMessage());
        }
        
        return new ResultMsg(true);
    }
}
