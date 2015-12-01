package vo;

import businesslogic.util.DocState;

/**
 * 所有单据VO的父类
 * 
 * @author kylin
 *
 */
public abstract class NoteVO {
	// 创建这个单据的业务员信息
	private String userName;
	
	private DocState state;

	public String getUserName() {
		return userName;
	}

	public boolean isAppproved() {
		return state == DocState.PASSED;
	}

	public DocState getState() {
		return state;
	}

	public void setState(DocState state) {
		this.state = state;
	}
	
}
