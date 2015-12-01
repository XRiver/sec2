package vo;

import java.util.ArrayList;

import businesslogic.util.GoodsState;

/**
 * 营业厅到达单VO
 * 
 * @author kylin
 *
 */
public class ArrivalNoteOnServiceVO extends NoteVO{
	
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

	public ArrivalNoteOnServiceVO(String date, String transferNumber, String from, GoodsState state,
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
