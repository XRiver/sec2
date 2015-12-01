package util.enums;

/**
 * Created by kylin on 15/11/24.
 */
public enum StaffType {

    DELIVERY_MAN(1),
    HALL_ASSISTANT(2),

    TRANSIT_ASSISTANT(3),
    WAREHOUSE_MANAGER(4),

    ACCOUNTANT(5),
    MANAGER(6),

    SYSTEM_MANAGER(7);

    private int intStaffType;

    StaffType(int i) {
        this.intStaffType = i;
    }

    public int getIntStaffType() {
        return intStaffType;
    }

    public static StaffType getStaffType(int i) {
        for(StaffType a:values()) {
            if(a.intStaffType==i) return a;
        }
        return null;
    }
}
