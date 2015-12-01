package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import vo.IncomeNoteVO;
import businesslogicservice.financeblservice.SettlementManagementBLService;
import util.ResultMsg;

public class SettlementManagementBLService_Stub implements
		SettlementManagementBLService {

	public ResultMsg addReceiveRecord(IncomeNoteVO vo) {
		System.out.println("ReceiveRecord added!");
		return new ResultMsg(true, "Success!");
	}


	public ArrayList<IncomeNoteVO> find(IncomeNoteVO vo) {
		
		System.out.println("found ");
		return new ArrayList<IncomeNoteVO>();
	}


}
