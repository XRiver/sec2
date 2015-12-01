package po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 付款单PO
 */
public class PaymentPO implements Serializable {

	private static final long serialVersionUID = 8277049058138246140L;
	
	public PaymentPO(String date, String nameOfPayer, String accountNumber,
			BigDecimal amountOfMoney, String type, String comment) {
		super();
		this.date = date;
		this.nameOfPayer = nameOfPayer;
		this.accountNumber = accountNumber;
		this.amountOfMoney = amountOfMoney;
		this.type = type;
		this.comment = comment;
	}
	
	/**
	 * 付款单日期
	 */
	String date = null;
	
	/**
	 * 付款人名称
	 */
	String nameOfPayer = null;
	
	/**
	 * 付款账户的账号
	 */
	String accountNumber = null;
	
	/**
	 * 付款数额
	 */
	BigDecimal amountOfMoney = null;
	
	/**
	 * 付款种类
	 */
	String type = null;
	
	/**
	 * 备注信息
	 */
	String comment = null;
	
	
	public String getDate() {
		return date;
	}
	public String getNameOfPayer() {
		return nameOfPayer;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public BigDecimal getAmountOfMoney() {
		return amountOfMoney;
	}
	public String getType() {
		return type;
	}
	public String getComment() {
		return comment;
	}
	
}
