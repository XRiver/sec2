
/**
 * 处理营业厅到达件PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.util.GoodsState;

public class ArrivalNoteOnServicePO extends NotePO implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -7187002330817151504L;

	/**
	 * 到达日期
	 */
	private String date;

	/**
	 * 中转单编号（装车单编号）
	 */
	private String TransferNumber;
	
	/**
	 * 出发地
	 */
	private String from;
	
	/**
	 * 到达状态
	 */
	private GoodsState GoodsState;

	/**
	 * 货物托运条形码
	 */
	private ArrayList<String> barCodes;

	public ArrivalNoteOnServicePO(String date, String transferNumber, String from, GoodsState state,
			ArrayList<String> barCodes) {
		super();
		this.date = date;
		TransferNumber = transferNumber;
		this.from = from;
		this.GoodsState = state;
		this.barCodes = barCodes;
	}

	public String getDate() {
		return date;
	}

	public String getTransferNumber() {
		return TransferNumber;
	}

	public String getFrom() {
		return from;
	}

	public GoodsState getGoodsState() {
		return GoodsState;
	}

	public ArrayList<String> getBarCodes() {
		return barCodes;
	}



	
}