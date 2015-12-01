package data.infodata.MockObject;

import po.DriverPO;
import util.enums.StaffType;

public class MockDriver extends DriverPO{

    public MockDriver(String staffID, String name, String organization, String gender, String IDCardNumber, double salary,
                      String phoneNumber, StaffType position, double workHour, String licenseDate) {
        super(staffID, name, organization, gender, IDCardNumber, salary, phoneNumber, position, workHour, licenseDate);
    }
}
