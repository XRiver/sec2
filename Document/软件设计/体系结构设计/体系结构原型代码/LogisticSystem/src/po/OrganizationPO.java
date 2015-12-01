package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 对机构增删改查时的PO
 * @author River
 *
 */
public class OrganizationPO implements Serializable {

	private static final long serialVersionUID = 7828206175791394318L;

	public static final String SERIVICE_HALL = "营业厅";
	public static final String TRANSMIT = "中转中心";
	
	
	public OrganizationPO(String type, String code, String name,
			ArrayList<StaffPO> staff) {
		super();
		this.type = type;
		this.code = code;
		this.name = name;
		this.staff = staff;
	}
	
	/**
	 * 机构种类：引用类变量SERIVICE_HALL,TRANSMIT
	 */
	String type = null;
	
	/**
	 * 机构编码
	 */
	String code = null;
	
	/**
	 * 机构名称
	 */
	String name = null;
	
	/**
	 * 机构人员信息
	 */
	ArrayList<StaffPO> staff = null;
	
	public String getType() {
		return type;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public ArrayList<StaffPO> getStaff() {
		return staff;
	}
	
}
