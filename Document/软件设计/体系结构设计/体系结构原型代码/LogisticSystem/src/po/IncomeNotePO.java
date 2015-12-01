package po;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 记录收款单的PO
 * @author River
 *
 */
//TODO VO PO的统一问题
public class IncomeNotePO implements Serializable {

	private static final long serialVersionUID = 8156585850190316916L;

	
	public IncomeNotePO(String time, String receivingOrganization,
			String incomeHandler, String incomeSource, BigDecimal money,
			String location, BankAccountPO account) {
		super();
		this.time = time;
		this.receivingOrganization = receivingOrganization;
		this.incomeHandler = incomeHandler;
		this.incomeSource = incomeSource;
		this.money = money;
		this.location = location;
		this.account = account;
	}
	
	/**
	 * 收款单时间
	 */
	String time = null;
	
	/**
	 * 收款单位编号
	 */
	String receivingOrganization = null;
	
	/**
	 * 收款人姓名
	 */
	String incomeHandler = null;
	
	/**
	 * 交款营业厅编号
	 */
	String incomeSource = null;
	
	/**
	 * 收款数目
	 */
	BigDecimal money = null;
	
	/**
	 * 收款地点
	 */
	String location = null;
	
	/**
	 * 收款账号
	 */
	BankAccountPO account = null;
	
	public String getTime() {
		return time;
	}
	public String getReceivingOrganization() {
		return receivingOrganization;
	}
	public String getIncomeHandler() {
		return incomeHandler;
	}
	public String getIncomeSource() {
		return incomeSource;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public String getLocation() {
		return location;
	}
	public BankAccountPO getAccount() {
		return account;
	}
	
	
}
