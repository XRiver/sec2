package vo;

import po.BankAccountPO;
import util.FormatCheck;
import util.ResultMsg;

/**
 * 银行账户
 * 
 * @author kylin
 *
 */
public class BankAccountVO {
	
	/**
	 * 账户名称
	 */
	private String name;
	
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 账户余额
	 */
	private String balance;

	/**
	 * 构造方法
	 * @param name
	 * @param balance
	 */
	public BankAccountVO(String name, String account, String balance) {
		this.name = name;
		this.account = account;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getAccount() {
		return account;
	}

	public String getBalance() {
		return balance;
	}
	
	public ResultMsg checkFormat() {
		ResultMsg[] msgs = new ResultMsg[3];
		
		msgs[0] = FormatCheck.isBankAccount(account);
		msgs[1] = FormatCheck.isMoney(balance);
		msgs[2] = FormatCheck.isChineseName(name);
		
		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) return msgs[i];
		}
		
		return new ResultMsg(true);
	}
	
	public Object toPO() {
		BankAccountPO po = new BankAccountPO(name, account, balance);
		return po;
	}
}
