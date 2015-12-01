package util.enums;

/**
 * Created by kylin on 15/10/22.
 */
public enum PriceType {
	/**
	 * 每公里的运费
	 */
    PricePerKg("PricePerKg"),
    /**
	 * 纸箱价格
	 */
    PaperBox("PaperBox"),
    /**
	 * 木箱价格
	 */
    WoodenBox("WoodenBox"),
    /**
	 * 快递袋价格
	 */
    Bag("Bag");

    private String type;

    PriceType(String s) {
        type = s;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
