/**
 * 期初建账使用的仓库信息PO
 * 
 * @author WQY
 *
 */
package po;

import java.util.ArrayList;

public class CommodityInfoPO {
	/**
	 * 仓库名称
	 */
	private String name;
	
	/**
	 * 货物信息
	 */
	private ArrayList<CommodityGoodsPO> goodsInfo;

	public CommodityInfoPO(String name, ArrayList<CommodityGoodsPO> goodsInfo) {
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
