package po;

import java.io.Serializable;

/**
 * 用于传递订单历史记录（轨迹）的PO
 * @author River
 *
 */
public class OrderPO implements Serializable {


	private static final long serialVersionUID = -164650701484223427L;
	
	public OrderPO(String barcode, String stateOfTransport,
			String[] historicalRecords) {
		super();
		this.barcode = barcode;
		this.stateOfTransport = stateOfTransport;
		this.historicalRecords = historicalRecords;
	}
	
	/**
	 * 条形码用字符串表示
	 */
	String barcode = null;
	
	/**
	 * 当前运送状态：“已收货”，“正在送货”，“已签收”
	 */
	String stateOfTransport = null;
	
	/**
	 * 保存了所有历史记录的字符串数组
	 */
	String[] historicalRecords = null;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBarcode() {
		return barcode;
	}
	public String getStateOfTransport() {
		return stateOfTransport;
	}
	public String[] getHistoricalRecords() {
		return historicalRecords;
	}
	
}
