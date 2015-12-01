package businesslogic.commodity;

import java.rmi.RemoteException;

import po.StorageInPO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageInDataService;
import businesslogic.info.RuntimeUserInfo;
import businesslogicservice.commodityblservice.StorageInBLService;
import util.ResultMsg;
import util.enums.InventoryStatus;
import vo.StorageInVO;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 * 问题：StorageInDataService 没有提供库存报警相关接口
 */
public class StorageIn implements StorageInBLService {
	
	StorageInDataService dataService = null;
	
	ResultMsg alarmingMsg = null;
	boolean isAlarming = false;
	
	public StorageIn() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (StorageInDataService) getter.getObjectByName("StorageInDataService");
	}
	
    @Override
    public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo) {
        ResultMsg msg = putInStorageVo.checkFormat();
        	return msg;
    }

    @Override
    public ResultMsg submitPutInStorageDoc(StorageInVO putInStorageVo) {
    	try {
			boolean msg = dataService.insert((StorageInPO) putInStorageVo.toPO(),RuntimeUserInfo.getNum());
		} catch (RemoteException e) {
			return new ResultMsg(false,e.getMessage());
		}
    	
        return new ResultMsg(true);
    }

    /**
     * Lack of corresponding interface
     */
    @Override
    public InventoryStatus alarm() {
    	// TODO 先要修改数据层！
        return null;
    }
}
