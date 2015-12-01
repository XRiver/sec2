package po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 营业厅业务员的收款单PO
 * @author River
 *
 */
public class CreditNotePO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1995375081984827715L;
	public CreditNotePO(){
		
	}
	public CreditNotePO(String nameOfDeliveryMan, String date, String money) {
		super();
		this.nameOfDeliveryMan = nameOfDeliveryMan;
		this.date = date;
		this.money = money;
	}

	/**
	 * 日期用字符串表示
	 */
	String date = null;
	
	/**
	 * 为保证精度，钱数用BigDecimal表示
	 */
	String money = null;
	
	/**
	 * 快递员姓名
	 */
	String nameOfDeliveryMan = null;

	public String getDate() {
		return date;
	}

	public String getMoney() {
		return money;
	}

	public String getNameOfDeliveryMan() {
		return nameOfDeliveryMan;
	}
	
}
