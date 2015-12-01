package businesslogicservice.statisticblservice;

import util.ResultMsg;
import vo.CommodityInfoVO;
import vo.FinanceVO;
import vo.InstitutionInfoVO;

import java.rmi.RemoteException;

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
     * 无基础期初建账，输入全新的机构，库存，财务信息
     *
     * @return
     */
    public ResultMsg restartWithBasis();

	/**
	 * 结束期初建账信息
	 * @return
	 */
	public ResultMsg endDataBuilding();
}
