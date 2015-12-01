package util;

import util.enums.Authority;

/**
 * Created by kylin on 15/11/22.
 */
public class LogInMsg {
    /**
     * 是否通过该阶段的检查
     */
    private boolean pass;

    private Authority authority;

    private String message;

    // 创建这个单据的业务员信息
    private String userName;

    // 创建这个单据的业务员所在的机构名称
    private String organization;
    
    public LogInMsg(boolean pass, Authority authority,String message) {
        this.pass = pass;
        this.authority = authority;
        this.message = message;
    }

    public LogInMsg(boolean pass, Authority authority, String message, String userName, String organization) {
        this.pass = pass;
        this.authority = authority;
        this.message = message;
        this.userName = userName;
        this.organization = organization;
    }

    public boolean isPass() {
        return pass;
    }

    public Authority getAuthority() {
        return authority;
    }
    
    public String getMessage() {
    	return message;
    }

    public String getUserName() {
        return userName;
    }

    public String getOrganization() {
        return organization;
    }
}
