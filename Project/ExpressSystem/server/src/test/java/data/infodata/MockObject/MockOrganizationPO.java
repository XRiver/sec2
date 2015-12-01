package data.infodata.MockObject;

import java.util.ArrayList;

import po.OrganizationPO;
import po.StaffPO;
import util.enums.OrganizationType;

public class MockOrganizationPO extends OrganizationPO {


    public MockOrganizationPO(String code, OrganizationType type, String name) {
        super(code, type, name);
    }
}
