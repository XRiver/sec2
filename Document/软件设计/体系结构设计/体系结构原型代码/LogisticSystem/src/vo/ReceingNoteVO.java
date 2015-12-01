package vo;

/**
 * 收件单VO
 * 
 * @author kylin
 *
 */
public class ReceingNoteVO extends NoteVO {

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

	public ReceingNoteVO(String barcode, String receiveCustomer, String time) {
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
