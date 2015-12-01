package vo;

/**
 * 系统日志VO
 * 
 * @author kylin
 *
 */
public class SystemLogVO {
    
	/**
	 * 创建时间
	 */
	String time;
	
	/**
	 * 日志内容
	 */
	String content;

	public SystemLogVO(String time, String content) {
		super();
		this.time = time;
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public String getContent() {
		return content;
	}
}
