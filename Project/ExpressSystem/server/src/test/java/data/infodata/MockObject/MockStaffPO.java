package data.infodata.MockObject;

import po.StaffPO;
import util.enums.StaffType;

public class MockStaffPO extends StaffPO {

    public MockStaffPO(String staffID, String name, String organization, String gender, String IDCardNumber,
                       double salary, String phoneNumber, StaffType position, double workHour) {
        super(staffID, name, organization, gender, IDCardNumber, salary, phoneNumber, position, workHour);
    }
}
