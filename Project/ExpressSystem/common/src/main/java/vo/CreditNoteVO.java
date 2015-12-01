package vo;

import java.security.spec.RSAKeyGenParameterSpec;
import java.util.ArrayList;

import po.CreditNotePO;
import util.FormatCheck;
import util.ResultMsg;

/**
 * 快递收款单
 * 
 * @author kylin
 *
 */
public class CreditNoteVO {
  
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 收款总数
	 */
	private String moneySum;
	
	/**
	 * 快递员姓名
	 */
	private String CourierName;
	
	/**
	 *条形码
	 */
	private ArrayList<String> barcode;
	
	/**
	 * 构造方法
	 * @param date
	 * @param moneySum
	 * @param CourierName
	 * @param barcode
	 */
	public CreditNoteVO(String date,String moneySum,String CourierName,ArrayList<String> barcode){
		this.date = date;
		this.moneySum = moneySum;
		this.CourierName =CourierName;
		this.barcode = barcode;
	}

	public String getDate() {
		return date;
	}

	public String getMoneySum() {
		return moneySum;
	}

	public String getCourierName() {
		return CourierName;
	}

	public ArrayList<String> getBarcode() {
		return barcode;
	}
	
	public ResultMsg checkFormat() {
		ResultMsg[] msgs = new ResultMsg[3];
		
		msgs[0] = FormatCheck.isDate(date);
		msgs[1] = FormatCheck.isChineseName(CourierName);
		msgs[2] = FormatCheck.isMoney(moneySum);
		
		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) return msgs[i];
		}
		
		ResultMsg msg = null;
		for(String s: barcode) {
			msg = FormatCheck.isBarcode(s);
			if(!msg.isPass()) return msg;
		}
		
		
		return new ResultMsg(true);
	}
	
	public Object toPO(){
		CreditNotePO po = new CreditNotePO(CourierName, date, moneySum);
		return po;
	}
}
