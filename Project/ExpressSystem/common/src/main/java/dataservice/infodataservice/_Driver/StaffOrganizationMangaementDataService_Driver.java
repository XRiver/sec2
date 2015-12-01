package dataservice.infodataservice._Driver;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.infodataservice._Stub.StaffOrganizationManagementDataService_Stub;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;
import util.enums.OrganizationType;
import util.enums.StaffType;

public class StaffOrganizationMangaementDataService_Driver {
	private StaffPO staffPO1;
	private StaffPO staffPO2;
	private OrganizationPO orPO;
	private ArrayList<StaffPO> staffList = new ArrayList<StaffPO>();
	private ArrayList<OrganizationPO> orList = new ArrayList<OrganizationPO>();
	
	public StaffOrganizationMangaementDataService_Driver() {
		staffPO1 = new StaffPO("0002","吴秦月","苏州营业厅","女",
                "320318199601297895", 7000.0, "18362926754", StaffType.ACCOUNTANT, 10.0);
        staffPO2 = new StaffPO("0001","吴秦月","苏州营业厅","女",
                "320318199601297895", 7000.0, "18362926754", StaffType.ACCOUNTANT, 10.0);
        staffList.add(staffPO1);
		staffList.add(staffPO2);
		orPO = new OrganizationPO("营业厅", OrganizationType.HEADQUARTERS,"苏州营业厅");
		orList.add(orPO);
	}
	
	public void drive(StaffOrganizationManagementDataService somDataService) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException, SQLException {
		somDataService.addOrganization(orPO);
		somDataService.addStaff(staffPO1);
		somDataService.addStaff(staffPO2);
		somDataService.removeStaff(staffPO1);
		somDataService.removeOrganization(orPO);
		somDataService.modifyOrganization(orPO);
		somDataService.modifyStaff(staffPO1);
		somDataService.findStaff(new StaffPO("0001","吴秦月","苏州营业厅","女",
                "320318199601297895", 7000.0, "18362926754", StaffType.ACCOUNTANT, 10.0));
        somDataService.findOrganization(new OrganizationPO("营业厅", OrganizationType.HEADQUARTERS,"苏州营业厅"));
		
	    if(somDataService.addOrganization(orPO))
	    	    System.out.println("success");
	    else
	      	System.out.println("fail");
	    if(somDataService.addStaff(staffPO1))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    if(somDataService.addStaff(staffPO2))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    if(somDataService.removeStaff(staffPO1))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    if(somDataService.removeOrganization(orPO))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    if(somDataService.modifyOrganization(orPO))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    if(somDataService.modifyStaff(staffPO1))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    
	}
	
	public static void  main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException, SQLException {
		StaffOrganizationManagementDataService_Stub stub = new StaffOrganizationManagementDataService_Stub();
		StaffOrganizationMangaementDataService_Driver driver  = new StaffOrganizationMangaementDataService_Driver();
		driver.drive(stub);
	}

}
