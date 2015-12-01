package vo;

/**
 * 付款记录
 * 
 * @author kylin
 *
 */
public class PaymentRecordVO {
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * jine
	 */
	private String money;
	
	/**
	 * 付款人
	 */
	private String payer;
	
	/**
	 * 银行账号
	 */
	private String accountNum;
	
	/**
	 * 付款方式
	 */
	private String paymentMethod;
	
	/**
	 * 构造方法
	 * @param date
	 * @param money
	 * @param payer
	 * @param accountNum
	 * @param paymentMethod
	 */
	public PaymentRecordVO(String date,String money,String payer,String accountNum,
			String paymentMethod){
		this.date = date;
		this.money = money;
		this.payer = payer;
		this.accountNum = accountNum;
		this.paymentMethod = paymentMethod;
	}

	public String getDate() {
		return date;
	}

	public String getMoney() {
		return money;
	}

	public String getPayer() {
		return payer;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
}
