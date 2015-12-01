package dataservice.infodataservice._Driver;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.infodataservice._Stub.StaffOrganizationManagementDataService_Stub;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;

public class StaffOrganizationMangaementDataService_Driver {
	private StaffPO staffPO1;
	private StaffPO staffPO2;
	private OrganizationPO orPO;
	private ArrayList<StaffPO> staffList = new ArrayList<StaffPO>();
	private ArrayList<OrganizationPO> orList = new ArrayList<OrganizationPO>();
	
	public StaffOrganizationMangaementDataService_Driver() {
		staffPO1 = new StaffPO("吴秦月","苏州营业厅","320318199601297895",7000.0,"18362926754","营业厅业务员",10.0);
		staffPO2 = new StaffPO("金三胖","苏州营业厅","320319199401287995",7000.0,"18362457854","营业厅业务员",10.0);
		staffList.add(staffPO1);
		staffList.add(staffPO2);
		orPO = new OrganizationPO("营业厅","0250101","苏州营业厅",staffList);
		orList.add(orPO);
	}
	
	public void drive(StaffOrganizationManagementDataService somDataService) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		somDataService.addOrganization(orPO);
		somDataService.addStaff(staffPO1);
		somDataService.addStaff(staffPO2);
		somDataService.removeStaff(staffPO1);
		somDataService.removeOrganization(orPO);
		somDataService.modifyOrganization(orPO, orPO);
		somDataService.modifyStaff(staffPO1, staffPO2);
		somDataService.findStaff(new StaffPO(null, null, null, 0, null, null, 0));
		somDataService.findOrganization(new OrganizationPO(null, null, null, null));	
		
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
	    if(somDataService.modifyOrganization(orPO, orPO))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    if(somDataService.modifyStaff(staffPO1, staffPO2))
    	        System.out.println("success");
        else
      	    System.out.println("fail");
	    
	}
	
	public static void  main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		StaffOrganizationManagementDataService_Stub stub = new StaffOrganizationManagementDataService_Stub();
		StaffOrganizationMangaementDataService_Driver driver  = new StaffOrganizationMangaementDataService_Driver();
		driver.drive(stub);
		
		
	}

}
