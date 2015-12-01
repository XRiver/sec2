package businesslogicservice.statisticblservice._stub;

import java.util.ArrayList;

import businesslogicservice.statisticblservice.LogInquiryBLService;
import util.ResultMsg;
import vo.SystemLogVO;

public class LogInquiryBLService_Stub implements LogInquiryBLService {

	public ResultMsg inputKeywords(SystemLogVO log) {
		System.out.println("received time keywords: " + log.getTime());
		System.out.println("received content keywords: " + log.getContent());
		return new ResultMsg(true, "Success!");
	}


	public ArrayList<SystemLogVO> getLogInfo(SystemLogVO log) {
		System.out.println("returning info");
		System.out.println("received content" + log.getContent());
		return new ArrayList<SystemLogVO>();
	}
	
}
