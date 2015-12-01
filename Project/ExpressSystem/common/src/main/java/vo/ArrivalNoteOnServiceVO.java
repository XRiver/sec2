package vo;

import java.util.ArrayList;

import po.ArrivalNoteOnServicePO;
import util.BarcodeAndState;
import util.FormatCheck;
import util.ResultMsg;

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
     * 区分中转单编号(true)
     */
    private boolean isTransit;

	/**
	 * 中转单编号（装车单编号）(唯一标示符)
	 */
	private String TransferNumber;
	
	/**
	 * 出发地
	 */
	private String from;
	
	/**
	 * 条形码与货物状态
	 */
	private ArrayList<BarcodeAndState> BarcodeAndStates;

    public ArrivalNoteOnServiceVO(String date, boolean isTransit, String transferNumber,
                                  String from, ArrayList<BarcodeAndState> barcodeAndStates) {
        this.date = date;
        this.isTransit = isTransit;
        this.TransferNumber = transferNumber;
        this.from = from;
        this.BarcodeAndStates = barcodeAndStates;
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

	public ArrayList<BarcodeAndState> getBarcodeAndStates() {
		return BarcodeAndStates;
	}

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[4];
        results[0] = FormatCheck.isDate(this.date);
        if(isTransit)
            results[1] = FormatCheck.isServiceHallLoadNumber(this.TransferNumber);
        else
            results[1] = FormatCheck.isTransitNoteNumber(this.TransferNumber);
        results[2] = FormatCheck.isCity(this.from);
        results[3] = new ResultMsg(true);
        ResultMsg barcodes;
        for(BarcodeAndState barcodeAndState:this.BarcodeAndStates){
            barcodes = FormatCheck.isBarcode(barcodeAndState.getBarcode());
            if(!barcodes.isPass()){
                results[3] = barcodes;
                break;
            }
        }
        for (ResultMsg result1 : results) {
            if (!result1.isPass()) {
                return result1;
            }
        }
        return result;
    }

    @Override
    public ArrivalNoteOnServicePO toPO() {
        return new ArrivalNoteOnServicePO(this.getDate(),isTransit,this.getTransferNumber(),
                this.getFrom(),this.getBarcodeAndStates());
    }
}
