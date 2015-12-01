package util.enums;

/**
 * Created by kylin on 15/11/21.
 */
public enum Authority {
    MANAGER(1),
    ACCOUNTANT_HIGH(2),
    ACCOUNTANT_LOW (3),
    WAREHOUSE_MANAGER (4),
    Financial_PERSONNEL(5),
    DELIVERY_MAN(6),
    SYSTEM_MANAGER(7);

    private int intAuthority;

    Authority(int authority) {
        this.intAuthority = authority;
    }

    public int getIntAuthority() {
        return intAuthority;
    }

    /**
     *
     * @param i
     * @return null if the integer is beyond enum range
     */
    public static Authority getAuthObject(int i) {
        for(Authority a:values()) {
            if(a.intAuthority ==i) return a;
        }
        return null;
    }
}
