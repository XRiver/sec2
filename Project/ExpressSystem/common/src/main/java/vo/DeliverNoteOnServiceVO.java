package vo;

import util.FormatCheck;
import po.DeliverNoteOnServicePO;
import po.NotePO;
import util.ResultMsg;

import java.util.ArrayList;

/**
 * 营业厅派件单VO
 * 
 * @author kylin
 *
 */
public class DeliverNoteOnServiceVO extends NoteVO {

    /**
     * 唯一ID
     */
    private String DeliverNoteOnServiceID;

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

	public DeliverNoteOnServiceVO(String deliverNoteOnServiceID,String date, ArrayList<String> barCode, String deliveryMan) {
		super();
        this.DeliverNoteOnServiceID = deliverNoteOnServiceID;
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

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[3];
        results[0] = FormatCheck.isDate(this.date);
        results[1] = FormatCheck.isChineseName(this.DeliveryMan);
        results[2] = new ResultMsg(true);
        ResultMsg msg;
        for(String barcode:BarCode){
            msg = FormatCheck.isBarcode(barcode);
            if(!msg.isPass()){
                results[2] = msg;
                break;
            }
        }
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass()){
                return results[i];
            }
        }
        return result;
    }

    @Override
    public DeliverNoteOnServicePO toPO() {
        return new DeliverNoteOnServicePO(this.DeliverNoteOnServiceID,this.getDate(),
                this.getBarCode(),this.getDeliveryMan());
    }
}
