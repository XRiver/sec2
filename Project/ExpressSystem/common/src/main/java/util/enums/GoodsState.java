package util.enums;

/**
 * 货物到达状态常量
 * 
 * @author kylin
 *
 */
public enum GoodsState {
    COMPLETE("完整"),
    DAMAGED("损坏"),
    LOST("丢失");

    GoodsState(String s) {
        this.string = s;
    }

    String string;

    @Override
    public String toString() {
        return this.string;
    }

    public static GoodsState getGoodsState(String str) {
        for (GoodsState state : values()) {
            if (state.toString().equals(str)) {
                return state;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
