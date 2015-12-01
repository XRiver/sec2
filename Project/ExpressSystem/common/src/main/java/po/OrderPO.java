package po;

import util.enums.GoodsState;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 用于传递订单历史记录（轨迹）的PO
 * @author River
 *
 */
public class OrderPO implements Serializable {


	private static final long serialVersionUID = -164650701484223427L;
	
	/**
	 * 条形码用字符串表示
	 */
	String barcode = null;
	
	/**
     * 当前货物状态
     */
    GoodsState goodsState = null;

    /**
     * 货运历史的表示:
     * 每条信息格式:时间,详细信息;
     * 例如:
     * 2015-12-12 13:20,仙林营业厅已收件;
     * 2015-12-13 14:00 由中转中心发往营业厅;
     * 2015-12-14 14:00 王二已签收;
     * 每一条信息就是一个String
     * 界面需要把每一个String按照,隔开
     *
     */
    private ArrayList<String> history;

    public OrderPO(String barcode, GoodsState goodsState, ArrayList<String> history) {
        this.barcode = barcode;
        this.goodsState = goodsState;
        this.history = history;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBarcode() {
        return barcode;
    }

    public GoodsState getGoodsState() {
        return goodsState;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setGoodsState(GoodsState goodsState) {
        this.goodsState = goodsState;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
