package util.enums;

/**
 * 系统中使用的所有单据类型
 * 
 * @author kylin
 *
 */
public enum DocType {
	/**
	 * 寄件单
	 */
	Sending_Note,
	/**
	 * 收件单
	 */
	Receing_Note,
	/**
	 * 营业厅到达单
	 */
	Arrival_Note_On_Service,
	/**
	 * 营业厅装车单
	 */
	Load_Note_On_Service,
	/**
	 * 营业厅派件单
	 */
	Deliver_Note_On_Service,
	/**
	 * 中转中心到达单
	 */
	Arrival_Note_On_Transit,
	/**
	 * 中转中心装车单
	 */
	Load_Note_On_Transit,
	/**
	 * 中转中心中转单
	 */
	Transit_Note_On_Transit,
}
