package businesslogicservice.commodityblservice._Stub;

import businesslogic.util.ResultMsg;
import businesslogicservice.commodityblservice.StorageInquiryAllBLService;

public class StorageInquiryAllBLService_Stub implements StorageInquiryAllBLService {

	@Override
	public ResultMsg inputFirst(String firstTime) {
		if(firstTime.equals("2011-11-11"))
			return new ResultMsg(true,"success");
		else
			return new ResultMsg(false,"failure");
	}

	@Override
	public ResultMsg request() {
			return new ResultMsg(true,"提交成功");
	}

}
