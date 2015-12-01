package data.infodata;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.sql.SQLException;

import dataservice.exception.ElementNotFoundException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import org.junit.Test;

import po.OrganizationPO;
import dataservice.exception.InterruptWithExistedElementException;
import po.StaffPO;
import util.enums.OrganizationType;
import util.enums.StaffType;

public class StaffOrganizationManagementData_Test {

    private StaffOrganizationManagementDataService dataService;

    public StaffOrganizationManagementData_Test() throws RemoteException {
        dataService = new StaffOrganizationManagementData();
    }

    @Test
    public void testAddOrg(){
        try {
            OrganizationPO po = new OrganizationPO("0516003",OrganizationType.SERVICE_HALL,
                    "徐州市营业厅1");
            assertEquals(dataService.addOrganization(po),true);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void testDeleteOrg() throws RemoteException, InterruptWithExistedElementException, SQLException, ElementNotFoundException {
        OrganizationPO po = new OrganizationPO("0516002", OrganizationType.SERVICE_HALL,
                "徐州市沛县汤沐路营业厅");
        assertEquals(dataService.removeOrganization(po), true);
    }

//    @Test
    public void testUpdateOrg() throws RemoteException, InterruptWithExistedElementException, SQLException, ElementNotFoundException {
        OrganizationPO po = new OrganizationPO("0516001", OrganizationType.HEADQUARTERS,
                "徐州市沛县中学");
        dataService.modifyOrganization(po);
//        assertEquals(dataService.modifyOrganization(po),true);
    }

//    @Test
    public void testAddStaff() throws RemoteException, InterruptWithExistedElementException, SQLException {
        StaffPO po = new StaffPO("0002", "一只麟", "南京总部", "男", "320322199501201123", 88888.0,
                "18795853923", StaffType.MANAGER, 1000);
        assertEquals(dataService.addStaff(po), true);
    }

//    @Test
    public void testDeleteStaff() throws RemoteException, InterruptWithExistedElementException, SQLException, ElementNotFoundException {
        StaffPO po = new StaffPO("0002", "一只麟", "南京总部", "男", "320322199501201123", 88888.0,
                "18795853923", StaffType.MANAGER, 1000);
        assertEquals(dataService.removeStaff(po), true);
    }

//    @Test
    public void testUpdateStaff() throws RemoteException, InterruptWithExistedElementException, SQLException, ElementNotFoundException {
        StaffPO po = new StaffPO("0002", "二只麟", "南京总部", "男", "88888", 9999.0,
                "8888", StaffType.MANAGER, 888);
        assertEquals(dataService.modifyStaff(po), true);
    }

}
