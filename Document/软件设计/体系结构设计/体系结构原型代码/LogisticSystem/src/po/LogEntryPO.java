package po;

import java.io.Serializable;
/**
 * 用于查询系统日志的PO
 * @author River
 *
 */
public class LogEntryPO implements Serializable {


	private static final long serialVersionUID = 8123672483324893530L;
	
	public LogEntryPO(String time, String record) {
		super();
		Time = time;
		this.record = record;
	}

	/**
	 * 记录时间
	 */
	String Time = null;
	
	/**
	 * 记录信息
	 */
	String record = null;
	
	public String getTime() {
		return Time;
	}

	public String getRecord() {
		return record;
	}

}
