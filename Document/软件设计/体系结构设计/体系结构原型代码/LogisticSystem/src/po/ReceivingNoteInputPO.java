
/**
 * 输入收件单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;

public class ReceivingNoteInputPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4632266724829914064L;

	/**
	 * 收件单号
	 */
	private String barcode;
	
	/**
	 * 收件人姓名
	 */
	private String receiveCustomer;

	/**
	 * 收件时间
	 */
	private String time;

	public ReceivingNoteInputPO(String barcode, String receiveCustomer, String time) {
		super();
		this.barcode = barcode;
		this.receiveCustomer = receiveCustomer;
		this.time = time;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getReceiveCustomer() {
		return receiveCustomer;
	}

	public String getTime() {
		return time;
	}
	
}