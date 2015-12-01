package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.enums.OrganizationType;
import vo.OrganizationInfoVO;

/**
 * 对机构增删改查时的PO
 * @author River
 *
 */
public class OrganizationPO implements Serializable {

	private static final long serialVersionUID = 7828206175791394318L;

	public OrganizationPO(String code,OrganizationType type,String name) {
		super();
		this.type = type;
		this.code = code;
		this.name = name;
	}


    /**
     * 机构编码
     */
    String code = null;

	/**
	 * 机构种类：引用类变量SERIVICE_HALL,TRANSMIT
	 */
	OrganizationType type = null;

	/**
	 * 机构名称
	 */
	String name = null;

	public OrganizationType getType() {
		return type;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}

	public Object toVO() {
		//TODO PO是否应该包含所有员工信息
		OrganizationInfoVO vo = new OrganizationInfoVO(code, type, name, null);
		
		return vo;
	}
	
}
