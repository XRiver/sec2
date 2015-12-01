package vo;

import po.ArrivalNoteOnServicePO;
import po.NotePO;
import util.ResultMsg;

/**
 * 所有单据VO的父类
 * 
 * @author kylin
 *
 */
public abstract class NoteVO {
	// 创建这个单据的业务员信息
	private String userName;

    // 创建这个单据的业务员所在的机构名称
    private String organization;

	// 总经理是否已经通过该单据的审批
	private boolean appproved;

	public String getUserName() {
		return userName;
	}

	public boolean isAppproved() {
		return appproved;
	}

    public ResultMsg checkFormat() {
        return null;
    }

    public NotePO toPO() {
        return  null;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setAppproved(boolean appproved) {
        this.appproved = appproved;
    }
}
