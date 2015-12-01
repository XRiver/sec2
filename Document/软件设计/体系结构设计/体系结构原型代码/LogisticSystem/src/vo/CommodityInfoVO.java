package vo;

import java.util.ArrayList;

import po.GoodsPO;

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
	private ArrayList<GoodsPO> goodsInfo;

	public CommodityInfoVO(String name, ArrayList<GoodsPO> goodsInfo) {
		super();
		this.name = name;
		this.goodsInfo = goodsInfo;
	}

	public String getName() {
		return name;
	}

	public ArrayList<GoodsPO> getGoodsInfo() {
		return goodsInfo;
	}
	
	
	
}
