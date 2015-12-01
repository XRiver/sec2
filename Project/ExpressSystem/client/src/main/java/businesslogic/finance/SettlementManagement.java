package businesslogic.finance;

import businesslogicservice.financeblservice.SettlementManagementBLService;
import util.ResultMsg;
import vo.IncomeNoteVO;

import java.util.ArrayList;

import po.IncomeNotePO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.financedataservice.SettlementManagementDataService;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 */
public class SettlementManagement implements SettlementManagementBLService {
	
	SettlementManagementDataService dataService = null;
	
	public SettlementManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (SettlementManagementDataService) getter.getObjectByName("SettlementManagementDataService");
	}
	
    @Override
    public ResultMsg addReceiveRecord(IncomeNoteVO vo) {
    	ResultMsg msg = vo.checkFormat();
    	return msg;
    }

    @Override
    public ArrayList<IncomeNoteVO> find(IncomeNoteVO vo) {
    	
    	ArrayList<IncomeNoteVO> result = new ArrayList<>();
    	ArrayList<IncomeNotePO> get = null;
    	try {
    		get = dataService.findAll();
    	} catch (Exception e) {
    		System.err.println("获取收款单失败：");
    		System.err.println(e.getMessage());
    		return result;
    	}
    	
    	for(IncomeNotePO po:get) {
    		result.add((IncomeNoteVO)po.toVO());
    	}
    	
    	
        return result;
    }
}
