package vo;

import po.PaymentPO;
import util.FormatCheck;
import util.ResultMsg;

import java.math.BigDecimal;

/**
 * 付款记录
 * 
 * @author kylin
 *
 */
public class PaymentVO {
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 金额
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
	public PaymentVO(String date,String money,String payer,String accountNum,
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
	
	public ResultMsg checkFormat() {
		
		ResultMsg[] msg = new ResultMsg[4];
		
		msg[0] = FormatCheck.isDate(date);
		msg[1] = FormatCheck.isMoney(money);
		msg[2] = FormatCheck.isChineseName(payer);
		msg[3] = FormatCheck.isBankAccount(accountNum);
		
		for(int i=0;i<msg.length;i++) {
			if(!msg[i].isPass()) return msg[i];
		}
		
		return new ResultMsg(true);
		
	}
	
	public Object toPO(){
		return new PaymentPO(date, payer, accountNum,
                BigDecimal.valueOf(Double.parseDouble(money)), paymentMethod, "");
	}
}
