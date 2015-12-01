package vo;

import java.util.ArrayList;

import businesslogic.util.DeliveryState;

/**
 * 查询单据结果vo
 * 
 * @author kylin
 *
 */
public class NoteHistoryVO {
	
	/**
	 * 订单状态
	 */
	private DeliveryState state;

	/**
	 * 订单历史轨迹
	 */
	private ArrayList<String> history;

	public NoteHistoryVO(DeliveryState state, ArrayList<String> history) {
		super();
		this.state = state;
		this.history = history;
	}

	public DeliveryState getState() {
		return state;
	}

	public ArrayList<String> getHistory() {
		return history;
	}
	
}
