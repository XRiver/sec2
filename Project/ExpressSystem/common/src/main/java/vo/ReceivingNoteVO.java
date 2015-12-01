package vo;
import util.FormatCheck;
import po.ReceivingNotePO;
import util.ResultMsg;

/**
 * 收件单VO
 * 
 * @author kylin
 *
 */
public class ReceivingNoteVO extends NoteVO {

	/**
	 * 收件单号(唯一标识)
	 */
	private String barcode;
	
	/**
	 * 收件人姓名
	 */
	private String receiveCustomer;

	/**
	 * 收件时间
	 */
	private String time;

	public ReceivingNoteVO(String barcode, String receiveCustomer, String time) {
		super();
		this.barcode = barcode;
		this.receiveCustomer = receiveCustomer;
		this.time = time;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getReceiveCustomer() {
		return receiveCustomer;
	}

	public String getTime() {
		return time;
	}

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[3];
        results[0] = FormatCheck.isBarcode(this.barcode);
        results[1] = FormatCheck.isChineseName(this.receiveCustomer);
        results[2] = FormatCheck.isReceiveTime(this.time);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass()){
                return results[i];
            }
        }
        return result;
    }

    @Override
    public ReceivingNotePO toPO() {
        return new ReceivingNotePO(this.getBarcode(),this.getReceiveCustomer(),this.getTime());
    }
}
