package util.enums;

/**
 * Created by kylin on 15/11/24.
 */
public enum  OrganizationType {

    SERVICE_HALL(1),
    TRANSIT_CENTER(2),
    STORE_HOUSE(3),
    HEADQUARTERS(4);

    private int type;

    OrganizationType(int i) {
        this.type = i;
    }

    public int getType() {
        return type;
    }

    public static OrganizationType getOrgType(int type){
        for(OrganizationType org:values()){
            if(org.getType() == type)
                return org;
        }
        return null;
    }
}
