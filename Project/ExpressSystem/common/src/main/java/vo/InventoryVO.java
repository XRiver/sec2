package vo;

import java.util.ArrayList;

import po.CommodityGoodsPO;
import po.InventoryPO;
import util.FormatCheck;
import util.ResultMsg;

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
	
	public ResultMsg checkFormat() {
		ResultMsg[] msgs = new ResultMsg[3];
		
		msgs[0] = FormatCheck.isProperNumber(inNum);
		msgs[1] = FormatCheck.isProperNumber(outNum);
		msgs[2] = FormatCheck.isMoney(money);
		
		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) return msgs[i];
		}
		
		ResultMsg msg = null;
		for(CommodityGoodsVO vo:goodsInfo) {
			msg = vo.checkFormat();
			if(!msg.isPass()) return msg;
		}
		
		return new ResultMsg(true);
	}
	
	public Object toPO() {
		ArrayList<CommodityGoodsPO> list = new ArrayList<>();
		
		for(CommodityGoodsVO vo:goodsInfo) {
			list.add((CommodityGoodsPO) vo.toPO());
		}
		
		InventoryPO po = new InventoryPO(outNum, inNum, money, list);
		
		return po;
	}
}
