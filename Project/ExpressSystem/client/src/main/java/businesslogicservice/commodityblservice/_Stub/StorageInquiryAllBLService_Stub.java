package businesslogicservice.commodityblservice._Stub;

import java.util.ArrayList;

import businesslogicservice.commodityblservice.StorageInquiryAllBLService;
import util.ResultMsg;
import vo.InventoryVO;

public class StorageInquiryAllBLService_Stub implements StorageInquiryAllBLService {

	public ResultMsg inputFirst(String firstTime) {
		if(firstTime.equals("2011-11-11"))
			return new ResultMsg(true,"success");
		else
			return new ResultMsg(false,"failure");
	}

	public ArrayList<InventoryVO> request() {
		return null;
	}
}
