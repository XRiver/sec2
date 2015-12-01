/**
 * 处理中转中心到达件PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;

//TODO povo的统一
public class ArrivalNoteOnTransitPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7182509551136962156L;
	private String transitNum;//中转中心编号
	private String time;//货物到达日期
	private String transitNoteNum;//中转单编号
	private String from;//出发地
	private String state;//货物到达状态
	public ArrivalNoteOnTransitPO(String time,String transitNoteNum,String from,String state,String transitNum){
		this.time=time;
		this.transitNoteNum=transitNoteNum;
		this.from=from;
		this.state=state;
		this.transitNum=transitNum;
	}
	public String getTime() {
		return time;
	}
	public String getTransitNoteNum() {
		return transitNoteNum;
	}
	public String getFrom() {
		return from;
	}
	public String getState() {
		return state;
	}

	public String getTransitNum() {
		return transitNum;
	}

}