package vo;

import java.util.ArrayList;

import util.FormatCheck;
import po.ArrivalNoteOnTransitPO;
import po.NotePO;
import util.BarcodeAndState;
import util.ResultMsg;

/**
 * 中转中心到达单VO
 * 
 * @author kylin
 *
 */
public class ArrivalNoteOnTransitVO extends NoteVO {
	
	/**
	 * 中转单编号(唯一标示符)
	 */
	private String transferNumber;
	
	/**
	 * 中转中心编号
	 */
	private String centerNumber;

	/**
	 * 货物到达日期
	 */
	private String date;
	
	/**
	 * 货物出发地
	 */
	private String departurePlace;
	
	/**
	 * 条形码与货物状态
	 */
	private ArrayList<BarcodeAndState> BarcodeAndStates;

	public ArrivalNoteOnTransitVO(String transferNumber, String centerNumber, String date, String departurePlace,
			ArrayList<BarcodeAndState> barcodeAndStates) {
		super();
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		this.departurePlace = departurePlace;
		BarcodeAndStates = barcodeAndStates;
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public String getDate() {
		return date;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public ArrayList<BarcodeAndState> getBarcodeAndStates() {
		return BarcodeAndStates;
	}

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[5];
        results[0] = FormatCheck.isTransitNoteNumber(this.transferNumber);
        results[1] = FormatCheck.isCenterNumber(this.centerNumber);
        results[2] = FormatCheck.isDate(this.date);
        results[3] = FormatCheck.isCity(this.departurePlace);
        results[4] = new ResultMsg(true);
        ResultMsg barcodes;
        for(BarcodeAndState barcodeAndState:this.BarcodeAndStates){
            barcodes = FormatCheck.isBarcode(barcodeAndState.getBarcode());
            if(!barcodes.isPass()){
                results[3] = barcodes;
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
    public ArrivalNoteOnTransitPO toPO() {
        return new ArrivalNoteOnTransitPO(this.getTransferNumber(),this.getCenterNumber(),
                this.getDate(),this.getDeparturePlace(),this.getBarcodeAndStates());
    }
}
