package vo;

import java.util.ArrayList;

/**
 * 快递收款单
 * 
 * @author kylin
 *
 */
//TODO povo的统一
public class CreditNoteVO {
  
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 收款总数
	 */
	private String moneySum;
	
	/**
	 * 快递员姓名
	 */
	private String CourierName;
	
	/**
	 *条形码
	 */
	private ArrayList<String> barcode;
	
	/**
	 * 构造方法
	 * @param date
	 * @param moneySum
	 * @param CourierName
	 * @param barcode
	 */
	public CreditNoteVO(String date,String moneySum,String CourierName,ArrayList<String> barcode){
		this.date = date;
		this.moneySum = moneySum;
		this.CourierName =CourierName;
		this.barcode = barcode;
	}

	public String getDate() {
		return date;
	}

	public String getMoneySum() {
		return moneySum;
	}

	public String getCourierName() {
		return CourierName;
	}

	public ArrayList<String> getBarcode() {
		return barcode;
	}
}
