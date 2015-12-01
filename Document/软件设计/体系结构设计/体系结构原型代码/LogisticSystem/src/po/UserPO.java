package po;

import java.io.Serializable;

/**
 * 用于登录验证的系统用户PO
 * @author River
 *
 */
public class UserPO implements Serializable {

	private static final long serialVersionUID = 3758641678884304726L;

	public static final int SYSTEM_MANAGER = 0;
	public static final int MANAGER = 1;
	public static final int ACCOUNTANT_HIGH = 2;
	public static final int ACCOUNTANT_LOW = 3;
	public static final int WAREHOUSE_MANAGER = 4;
	public static final int CLERK = 5;
	public static final int DELIVERY_MAN = 6;
	
	public UserPO(String account, String password, int authority) {
		super();
		this.account = account;
		this.password = password;
		this.authority = authority;
	}

	/**
	 * 用户账号
	 */
	String account = null;
	
	/**
	 * 用户密码
	 */
	String password = null;
	
	/**
	 * 用户请求权限
	 */
	int authority = -1;

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public int getAuthority() {
		return authority;
	}
	
	
}
