/**
 * NOTEPO
 * 所有单据的父类
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;

import util.enums.DocState;
import vo.NoteVO;

public abstract class NotePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768739830941620932L;

    // 创建这个单据的业务员信息
    private String userName;

    // 创建这个单据的业务员所在的机构名称
    private String organization;

	private DocState state;

	public DocState getState() {
		return state;
	}

	public void setState(DocState state) {
		this.state = state;
	}

    public NoteVO toVO(){
        return null;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getID() {
        return null;
    }

    public String getUserName() {
        return userName;
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
}
