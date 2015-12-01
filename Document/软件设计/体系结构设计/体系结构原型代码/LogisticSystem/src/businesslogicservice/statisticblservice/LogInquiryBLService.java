package businesslogicservice.statisticblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.SystemLogVO;

/**
 * 查询系统日志的逻辑接口
 * 
 * @author kylin
 *
 */
public interface LogInquiryBLService {
	
	/**
	 * 根据关键字查看系统日志功能
	 *
	 * @param keywords
	 * @return
	 */
	public ResultMsg inputKeywords(SystemLogVO log);
	
	/**
	 *	显示对应关键字的系统日志
	 *
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogVO> getLogInfo(SystemLogVO log);
	
}
