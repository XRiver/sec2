package businesslogicservice.statisticblservice._stub;

import businesslogicservice.statisticblservice.BaseDataBuildingBLService;
import util.ResultMsg;
import vo.CommodityInfoVO;
import vo.FinanceVO;
import vo.InstitutionInfoVO;

public class BaseDataBuildingBLService_Stub implements BaseDataBuildingBLService {
	

	public ResultMsg restartWithoutBasis(){
		System.out.println("restarting without basis");
		return new ResultMsg(true, "granted");
	};
	
	
	public ResultMsg addInstitutionInfo(InstitutionInfoVO institutionVO){
		System.out.println("adding institution");
		return new ResultMsg(true, "Success");
	};
	
	
	public ResultMsg addCommodityInfo(CommodityInfoVO commodityInfoVO){
		System.out.println("adding commodity");
		return new ResultMsg(true, "Success");
	};
	
	
	public ResultMsg addFinanceInfo(FinanceVO financeInfoVO){
		System.out.println("adding finance");
		return new ResultMsg(true, "Success");
	};
	
	
	public ResultMsg restartWithBasis(){
		System.out.println("restarting with basis");
		return new ResultMsg(true, "Success");
	};
	
	
	public ResultMsg changeInstitutionInfo(InstitutionInfoVO institutionVO){
		System.out.println("changeing institution");
		return new ResultMsg(true, "Success");
	};
	
	
	public ResultMsg changeCommodityInfo(CommodityInfoVO commodityInfoVO){
		System.out.println("changeing commodity");
		return new ResultMsg(true, "Success");
	};
	
	
	public ResultMsg changeFinanceInfo(FinanceVO financeInfoVO){
		System.out.println("changeing finance");
		return new ResultMsg(true, "Success");
	}


	public ResultMsg endDataBuilding() {
		System.out.println("endDataBuilding");
		return new ResultMsg(true, "Success");
	};
}
