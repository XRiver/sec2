package vo;

import po.DriverPO;
import po.StaffPO;
import util.FormatCheck;
import util.ResultMsg;
import util.enums.StaffType;

public class DriverVO extends StaffVO {

    /**
     * 驾照过期时间
     */
    String licenseDate = null;

    public DriverVO(String staffID,String name, String sex, String organization, StaffType postion, String IDNum,
                    int workingtime, String phoneNum, String wage, String licenseDate) {
        super(staffID,name, sex, organization, postion, IDNum, workingtime, phoneNum, wage);
        this.licenseDate = licenseDate;
    }

    public Object toPO() {
    	DriverPO po = new DriverPO((StaffPO) super.toPO(), licenseDate);
    	
        return po;
	}
	
	public ResultMsg checkFormat(){
		
		ResultMsg msg = super.checkFormat();
		if(!msg.isPass()) return msg;
		
		msg = FormatCheck.isDate(licenseDate);
		return msg;
		
	}
}
