package vo;

import java.math.BigDecimal;

/**
 * 期初建账使用的财务信息
 * 
 * @author kylin
 *
 */
public class FinanceVO {
	/**
	 * 账户名称用字符串表示
	 */
	private String name = null;
	
	/**
	 * 账号用字符串表示
	 */
	private String number = null;
	
	/**
	 * 为保证精度，余额用BigDecimal表示
	 */
	private BigDecimal balance = null;

	public FinanceVO(String name, String number, BigDecimal balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
}
