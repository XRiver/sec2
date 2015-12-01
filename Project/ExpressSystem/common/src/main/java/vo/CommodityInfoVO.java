package vo;

import java.util.ArrayList;

import po.CommodityGoodsPO;

/**
 * 期初建账使用的仓库信息VO
 * 
 * @author kylin
 *
 */
public class CommodityInfoVO {

	/**
	 * 仓库名称
	 */
	private String name;
	
	/**
	 * 货物信息
	 */
	private ArrayList<CommodityGoodsPO> goodsInfo;

	public CommodityInfoVO(String name, ArrayList<CommodityGoodsPO> goodsInfo) {
		super();
		this.name = name;
		this.goodsInfo = goodsInfo;
	}

	public String getName() {
		return name;
	}

	public ArrayList<CommodityGoodsPO> getGoodsInfo() {
		return goodsInfo;
	}
	
	
	
}
