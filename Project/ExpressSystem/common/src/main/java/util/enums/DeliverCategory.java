package util.enums;

/**
 * 快递种类常量
 * 包括 1:经济快递，2:标准快递，3:特快专递
 * 
 * @author kylin
 *
 */
public enum DeliverCategory {
    ECNOMIC("经济快递"),
    NORMAL("标准快递"),
    EXPRESS("特快专递");

    private String category;

    DeliverCategory(String s) {
        this.category = s;
    }

    public String getStrCategory() {
        return category;
    }

    public static DeliverCategory getDeliverCategory(String s) {
        for (DeliverCategory category : values()) {
            if (category.category.equals(s))
                return category;
        }
        return null;
    }
}
