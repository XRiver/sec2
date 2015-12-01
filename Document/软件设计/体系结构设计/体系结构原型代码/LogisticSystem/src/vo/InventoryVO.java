package vo;

import java.util.ArrayList;

public class InventoryVO {
	
    /**
     * 出库数量
     */
	private String outNum;
	
	/**
	 * 入库数量
	 */
	private String inNum;
	
	/**
	 * 时间段内货物金额
	 */
	private String money;
	
	/**
	 * 货物位置信息
	 */
	private ArrayList<CommodityGoodsVO> goodsInfo;
	
	/**
	 * 构造方法
	 * @param outNum
	 * @param inNum
	 * @param money
	 * @param place
	 */
	public InventoryVO(String outNum, String inNum,String money,ArrayList<CommodityGoodsVO> goodsInfo){
		this.outNum = outNum;
		this.inNum = inNum;
		this.money = money;
		this.goodsInfo = goodsInfo;
		
	}

	public String getOutNum() {
		return outNum;
	}

	public void setOutNum(String outNum) {
		this.outNum = outNum;
	}

	public String getInNum() {
		return inNum;
	}

	public void setInNum(String inNum) {
		this.inNum = inNum;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public ArrayList<CommodityGoodsVO> getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(ArrayList<CommodityGoodsVO> goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
}
