package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import dataservice.financedataservice.BankAccountManagementDataService;
import vo.BankAccountVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.BankAccountManagementBLService;

public class BankAccountManagemntBLService_Stub implements
		BankAccountManagementBLService {

	BankAccountManagementDataService data = null;
	
	public BankAccountManagemntBLService_Stub() {
	}
	
	public BankAccountManagemntBLService_Stub(BankAccountManagementDataService data) {
		this();
		this.data = data;
	}
	
	
	@Override
	public ArrayList<BankAccountVO> find(BankAccountVO vo) {
		System.out.println("find Success");
		BankAccountVO ac = new BankAccountVO(null, null, 0);
		ArrayList<BankAccountVO> list = new ArrayList<BankAccountVO>();
		list.add(ac);
		return list;
	}

	@Override
	public ResultMsg add(BankAccountVO vo) {
		System.out.println("add Success");
		ResultMsg result = null;
		return result;
	}

	@Override
	public ResultMsg delete(BankAccountVO vo) {
		System.out.println("delete Success");
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ResultMsg update(BankAccountVO vo) {
		System.out.println("update Success");
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ArrayList<BankAccountVO> show() {
		System.out.println("show Success");
		ArrayList<BankAccountVO> list = new ArrayList<>();
		return list;
	}

}
