package businesslogicservice.infoblservice._stub;

import java.util.ArrayList;

import vo.BankAccountVO;
import businesslogicservice.infoblservice.BankAccountManagementBLService;
import dataservice.infodataservice.BankAccountManagementDataService;
import util.ResultMsg;

public class BankAccountManagemntBLService_Stub implements
		BankAccountManagementBLService {

	BankAccountManagementDataService data = null;
	
	public BankAccountManagemntBLService_Stub() {
	}
	
	public BankAccountManagemntBLService_Stub(BankAccountManagementDataService data) {
		this();
		this.data = data;
	}
	
	
	public ArrayList<BankAccountVO> find(BankAccountVO vo) {
		System.out.println("find Success");
		BankAccountVO ac = new BankAccountVO(null, null, null);
		ArrayList<BankAccountVO> list = new ArrayList<BankAccountVO>();
		list.add(ac);
		return list;
	}

	public ResultMsg add(BankAccountVO vo) {
		System.out.println("add Success");
		ResultMsg result = null;
		return result;
	}

	public ResultMsg delete(BankAccountVO vo) {
		System.out.println("delete Success");
		return new ResultMsg(true, "Success!");
	}

	public ResultMsg update(BankAccountVO vo) {
		System.out.println("update Success");
		return new ResultMsg(true, "Success!");
	}

	public ArrayList<BankAccountVO> show() {
		System.out.println("show Success");
		ArrayList<BankAccountVO> list = new ArrayList<BankAccountVO>();
		return list;
	}

}
