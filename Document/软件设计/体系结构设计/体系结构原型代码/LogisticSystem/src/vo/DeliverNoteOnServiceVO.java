package vo;

import java.util.ArrayList;

/**
 * 营业厅派件单VO
 * 
 * @author kylin
 *
 */
public class DeliverNoteOnServiceVO extends NoteVO {
	
	/**
	 * 货物到达日期
	 */
	private String date;

	/**
	 * 货物托运条形号码
	 */
	private ArrayList<String> BarCode;

	/**
	 * 派件员
	 */
	private String DeliveryMan;

	public DeliverNoteOnServiceVO(String date, ArrayList<String> barCode, String deliveryMan) {
		super();
		this.date = date;
		BarCode = barCode;
		DeliveryMan = deliveryMan;
	}

    public String getDate() {
        return date;
    }

    public ArrayList<String> getBarCode() {
        return BarCode;
    }

    public String getDeliveryMan() {
        return DeliveryMan;
    }
}
