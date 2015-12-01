package businesslogicservice.statisticblservice;

import businesslogic.util.ResultMsg;
import vo.CommodityInfoVO;
import vo.FinanceVO;
import vo.InstitutionInfoVO;

/**
 * 期初建账逻辑接口
 * 
 * @author kylin
 *
 */
public interface BaseDataBuildingBLService {
	
	/**
	 * 无基础期初建账，输入全新的机构，库存，财务信息
	 * 
	 * @return
	 */
	public ResultMsg restartWithoutBasis();
	
	/**
	 * 财务人员开始无基础期初建账操作，输入机构信息
	 * 
	 * @param institutionVO
	 * @return
	 */
	public ResultMsg addInstitutionInfo(InstitutionInfoVO institutionVO);
	
	/**
	 * 无基础期初建账操作，输入库存信息
	 * 
	 * @param commodityInfoVO
	 * @return
	 */
	public ResultMsg addCommodityInfo(CommodityInfoVO commodityInfoVO);
	
	/**
	 * 无基础期初建账操作，输入财务信息
	 * 
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMsg addFinanceInfo(FinanceVO financeInfoVO);
	
	/**
	 * 有基础期初建账，输入修改后的或者未修改的的机构，库存，财务信息
	 * 
	 */
	public ResultMsg restartWithBasis();
	
	/**
	 * 有基础期初建账，输入机构信息
	 * 
	 * @param institutionVO
	 * @return
	 */
	public ResultMsg changeInstitutionInfo(InstitutionInfoVO institutionVO);
	
	/**
	 * 有基础期初建账，输入库存信息
	 * 
	 * @param commodityInfoVO
	 * @return
	 */
	public ResultMsg changeCommodityInfo(CommodityInfoVO commodityInfoVO);
	
	/**
	 * 有基础期初建账，输入财务信息
	 * 
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMsg changeFinanceInfo(FinanceVO financeInfoVO);
	
	/**
	 * 结束期初建账信息
	 * @return
	 */
	public ResultMsg endDataBuilding();
}
