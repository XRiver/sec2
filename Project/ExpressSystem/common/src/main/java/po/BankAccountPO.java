package po;

import java.io.Serializable;

import vo.BankAccountVO;

public class BankAccountPO implements Serializable {
	public BankAccountPO(){
		
	}
	public BankAccountPO(String name, String number, String balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2348048532115826364L;

	/**
	 * 账户名称用字符串表示
	 */
	private String name = null;
	
	/**
	 * 账号用字符串表示
	 */
	private String number = null;
	
	/**
	 * 余额
	 */
	private String balance = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public Object toVO() {
		BankAccountVO vo = new BankAccountVO(name, number, balance);
		return vo;
	}
	
}
