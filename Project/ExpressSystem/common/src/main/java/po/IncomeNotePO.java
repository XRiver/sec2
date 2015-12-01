package po;

import java.io.Serializable;
import java.math.BigDecimal;

import vo.BankAccountVO;
import vo.IncomeNoteVO;
/**
 * 记录收款单的PO
 * @author River
 *
 */
public class IncomeNotePO implements Serializable {

	private static final long serialVersionUID = 8156585850190316916L;
	
	public IncomeNotePO(){
		
	}
	public IncomeNotePO(String time, String receivingOrganization,
			String incomeHandler, String incomeSource, String money,
			 BankAccountPO bankAccountPO) {
		super();
		this.time = time;
		this.receivingOrganization = receivingOrganization;
		this.incomeHandler = incomeHandler;
		this.incomeSource = incomeSource;
		this.money = money;
		this.account = bankAccountPO;
	}
	
	
	/**
	 * 日期      收款单位     收款人即财务人员       交款营业厅      金额       银行账户
	 */
	
	
	/**
	 * 收款单时间
	 */
	String time = null;
	
	/**
	 * 收款单位名
	 */
	String receivingOrganization = null;
	
	/**
	 * 收款人姓名（财务人员）
	 */
	String incomeHandler = null;
	
	/**
	 * 交款营业厅名
	 */
	String incomeSource = null;
	
	/**
	 * 金额
	 */
	String money = null;
	
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
	public String getMoney() {
		return money;
	}

	public BankAccountPO getAccount() {
		return account;
	}
	
	public Object toVO() {
		IncomeNoteVO vo = new IncomeNoteVO(money, time, receivingOrganization, 
				incomeHandler, incomeSource, (BankAccountVO)account.toVO());
		return vo;
	}
}
