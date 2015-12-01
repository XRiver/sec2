/**
 * 输入寄件单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import util.enums.DeliverCategory;
import vo.DeliveryNoteVO;
import vo.NoteVO;

import java.io.Serializable;

public class DeliveryNotePO extends NotePO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 3326557217189374031L;

	/**
	 * 客户(寄件人)姓名
	 */
	private String senderName;

	/**
	 * 客户(寄件人)地址
	 */
	private String senderAddress;

	/**
	 * 客户(寄件人)电话（手机）号码
	 */
	private String senderTeleNumber;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人地址
     */
    private String receiverAddress;

    /**
     * 收件人电话（手机）号码
     */
    private String receiverTeleNumber;

    /**
     * 货物内件品名
     */
    private String name;

	/**
	 * 寄件件数
	 */
	private int goodsNumber;

	/**
	 * 货物实际重量
	 */
	private double weight;

	/**
	 * 货物体积
	 */
	private double volume;

	/**
	 * 快递种类
	 */
	private DeliverCategory category;

	/**
	 * 包装费用
	 */
	private double packPrice;

	/**
	 * 货物条形码
	 */
	private String barCode;

    public DeliveryNotePO(String senderName, String senderAddress, String senderTeleNumber, String receiverName, String receiverAddress, String receiverTeleNumber, String name, int goodsNumber, double weight, double volume, DeliverCategory category, double packPrice, String barCode) {
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderTeleNumber = senderTeleNumber;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverTeleNumber = receiverTeleNumber;
        this.name = name;
        this.goodsNumber = goodsNumber;
        this.weight = weight;
        this.volume = volume;
        this.category = category;
        this.packPrice = packPrice;
        this.barCode = barCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderTeleNumber() {
        return senderTeleNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public String getReceiverTeleNumber() {
        return receiverTeleNumber;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public DeliverCategory getCategory() {
        return category;
    }

    public double getPackPrice() {
        return packPrice;
    }

    public String getBarCode() {
        return barCode;
    }

    @Override
    public NoteVO toVO() {
        return new DeliveryNoteVO(this.senderName, this.senderAddress, this.senderTeleNumber, this.receiverName,
                this.receiverAddress, this.receiverTeleNumber, this.name, this.goodsNumber, this.weight,
                this.volume, this.category, this.packPrice, this.barCode);
    }

    @Override
    public String getID() {
        return this.barCode;
    }

}