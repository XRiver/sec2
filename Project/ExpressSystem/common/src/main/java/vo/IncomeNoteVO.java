package vo;

import po.BankAccountPO;
import po.IncomeNotePO;
import util.FormatCheck;
import util.ResultMsg;

/**
 * 收款记录
 * 
 * @author kylin
 *
 */
public class IncomeNoteVO {
     

	/**
	 * 金额
	 */
	private String money;
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 收款单位
	 */
	private String institution;
	
	/**
	 * 收款人（即财务人员）
	 */
	private String payee;
	
	/**
	 * 交款营业厅
	 */
	private String payService;
	
	
	private BankAccountVO bankAccount;
	
	/**
	 * 构造方法
	 * @param money
	 * @param date
	 * @param institution
	 * @param payee
	 * @param payService
	 * @param place
	 */
	public IncomeNoteVO(String money,String date,String institution,
			String payee,String payService,BankAccountVO bankAccount){
		this.date = date;
		this.institution =institution;
		this.money = money;
		this.payee = payee;
		this.payService = payService;
		this.bankAccount = bankAccount;
	}

	public String getMoney() {
		return money;
	}

	public String getDate() {
		return date;
	}

	public String getInstitution() {
		return institution;
	}

	public String getPayee() {
		return payee;
	}

	public String getPayService() {
		return payService;
	}



	public BankAccountVO getBankAccount() {
		return bankAccount;
	}
	
	public ResultMsg checkFormat(){
		ResultMsg[] msgs = new ResultMsg[7];
		msgs[0] = FormatCheck.isDate(date);
		msgs[1] = FormatCheck.isOrganizationName(institution);
		msgs[2] = FormatCheck.isMoney(money);
		msgs[3] = FormatCheck.isChineseName(payee);
		msgs[4] = FormatCheck.isServiceHall(payService);
		msgs[6] = bankAccount.checkFormat();
		
		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) return msgs[i];
		}
		
		return new ResultMsg(true);
	}
	
	public Object toPO() {
		IncomeNotePO po = new IncomeNotePO(date, institution, payee, 
				payService, money,(BankAccountPO) bankAccount.toPO());
		return po;
	}
	
}
