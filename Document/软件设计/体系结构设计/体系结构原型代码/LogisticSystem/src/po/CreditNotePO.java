package po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 营业厅业务员的收款单PO
 * @author River
 *
 */
//TODO povo的统一
public class CreditNotePO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1995375081984827715L;

	public CreditNotePO(String nameOfDeliveryMan, String date, BigDecimal money) {
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
	BigDecimal money = null;
	
	/**
	 * 快递员姓名
	 */
	String nameOfDeliveryMan = null;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getNameOfDeliveryMan() {
		return nameOfDeliveryMan;
	}

	public void setNameOfDeliveryMan(String nameOfDeliveryMan) {
		this.nameOfDeliveryMan = nameOfDeliveryMan;
	}
	
}
