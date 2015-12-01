package data.infodata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.database.DatabaseManager;
import data.database.SqlHelper;
import po.OrganizationPO;
import po.StaffPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import util.enums.OrganizationType;
import util.enums.StaffType;

public class StaffOrganizationManagementData implements
		StaffOrganizationManagementDataService {

    public StaffOrganizationManagementData() throws RemoteException {
        super();
    }

    @Override
	public boolean addStaff(StaffPO staff) throws RemoteException,
            InterruptWithExistedElementException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `staff` ( `gender`, `salary`, `position`, `organization`," +
                " `workHour`, `staff_id`, `idCardNumber`, `name`, `phoneNumber`) " +
                "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        int gender = staff.getGender().equals("男") ? 0 : 1;
        statement.setInt(1, gender);
        statement.setDouble(2, staff.getSalary());
        statement.setInt(3, staff.getPosition().getIntStaffType());
        statement.setString(4, staff.getOrganization());
        statement.setDouble(5, staff.getWorkHour());
        statement.setString(6, staff.getStaffID());
        statement.setString(7, staff.getIDCardNumber());
        statement.setString(8, staff.getName());
        statement.setString(9, staff.getPhoneNumber());
        int result = statement.executeUpdate();
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

	@Override
	public boolean addOrganization(OrganizationPO org) throws RemoteException,
            InterruptWithExistedElementException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `organization` (type,name,organization_id) " +
                "values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,org.getType().getType());
        statement.setString(2,org.getName());
        statement.setString(3,org.getCode());
        int result = statement.executeUpdate();
        DatabaseManager.releaseConnection(connection,statement,null);
		return result>0;
	}

	@Override
	public boolean removeStaff(StaffPO staff) throws RemoteException,
            ElementNotFoundException, SQLException {
        String sql = "DELETE from `staff` where staff_id = " + staff.getStaffID();
        return SqlHelper.excUpdate(sql);
    }

	@Override
	public boolean removeOrganization(OrganizationPO org)
            throws RemoteException, ElementNotFoundException, SQLException {
        String sql = "DELETE from `organization` where organization_id = "+org.getCode();
        return SqlHelper.excUpdate(sql);
    }

    @Override
    public boolean modifyStaff(StaffPO staff) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException {
        int gender = staff.getGender().equals("男") ? 0 : 1;
        String sql = "UPDATE staff SET name = '" + staff.getName() + "'," +
                " organization = '" + staff.getOrganization() + "'," +
                " gender = '" + gender + "'," +
                " idCardNumber = '" + staff.getIDCardNumber() + "'," +
                " salary = '" + staff.getSalary() + "'," +
                " phoneNumber = '" + staff.getPhoneNumber() + "'," +
                " position = '" + staff.getPosition().getIntStaffType() + "'," +
                " workHour = '" + staff.getWorkHour() + "'" +
                " WHERE staff_id = '" + staff.getStaffID() + "'";
        return SqlHelper.excUpdate(sql);
    }

    @Override
    public boolean modifyOrganization(OrganizationPO org) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException {
        String sql = "UPDATE organization SET type = '" + org.getType().getType() + "'," +
                " name = '" + org.getName() + "'" +
                " WHERE organization_id = '" + org.getCode() + "'";
        return SqlHelper.excUpdate(sql);
    }

	@Override
	public ArrayList<StaffPO> findStaff(StaffPO info) throws RemoteException,
            ElementNotFoundException, SQLException {
        String sql = "";
        if (info.getName() != null)
            sql = "SELECT * FROM staff WHERE name LIKE '%" + info.getName() + "%'";
        else if (info.getOrganization() != null)
            sql = "SELECT * FROM staff WHERE organization LIKE '%" + info.getOrganization() + "%'";
        else if (info.getGender() != null) {
            int gender = info.getGender().equals("男") ? 0 : 1;
            sql = "SELECT * FROM staff WHERE gender =" + gender;
        } else if (info.getIDCardNumber() != null)
            sql = "SELECT * FROM staff WHERE idCardNumber LIKE '%" + info.getIDCardNumber() + "%'";
        else if (info.getSalary() != 0.0)
            sql = "SELECT * FROM staff WHERE salary LIKE '%" + info.getSalary() + "%'";
        else if (info.getPhoneNumber() != null)
            sql = "SELECT * FROM staff WHERE phoneNumber LIKE '%" + info.getPhoneNumber() + "%'";
        else if (info.getPosition() != null)
            sql = "SELECT * FROM staff WHERE position LIKE '%" + info.getPosition().getIntStaffType() + "%'";
        else if (info.getWorkHour() != 0)
            sql = "SELECT * FROM staff WHERE workHour LIKE '%" + info.getWorkHour() + "%'";
        return this.excFindStaffStatement(sql);
    }

	@Override
	public ArrayList<OrganizationPO> findOrganization(OrganizationPO info)
            throws RemoteException, ElementNotFoundException, SQLException {
        String sql = "";
        if (info.getName() != null)
            sql = "SELECT * FROM organization WHERE name LIKE '%" + info.getName() + "%'";
        else if (info.getType() != null)
            sql = "SELECT * FROM organization WHERE type = +info.getType().getType()";
        return this.excFindOrgStatement(sql);
    }

	@Override
    public ArrayList<StaffPO> getAllStaff() throws RemoteException, SQLException {
        String sql = "SELECT * from `staff`";
        return this.excFindStaffStatement(sql);
    }

	@Override
	public ArrayList<OrganizationPO> getAllOrganizations()
            throws RemoteException, SQLException {
        String sql = "SELECT * from organization";
        return this.excFindOrgStatement(sql);
    }

    private ArrayList<StaffPO> excFindStaffStatement(String str) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(str);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<StaffPO> result = new ArrayList<>();
        while (resultSet.next()) {
            String staff_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String orgnization = resultSet.getString(3);
            int intGender = resultSet.getInt(4);
            String idCardNumber = resultSet.getString(5);
            double salary = resultSet.getDouble(6);
            String phone = resultSet.getString(7);
            int intPosition = resultSet.getInt(8);
            double workhour = resultSet.getDouble(9);
            String strGender = intGender == 0 ? "男" : "女";
            StaffPO po = new StaffPO(staff_id, name, orgnization, strGender,
                    idCardNumber, salary, phone, StaffType.getStaffType(intPosition), workhour);
            result.add(po);
        }
        DatabaseManager.releaseConnection(connection,statement,resultSet);
        return result;
    }

    private ArrayList<OrganizationPO> excFindOrgStatement(String str) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(str);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<OrganizationPO> result = new ArrayList<>();
        while (resultSet.next()) {
            int organization_id = resultSet.getInt(1);
            int intType = resultSet.getInt(2);
            String name = resultSet.getString(3);
            OrganizationType type = OrganizationType.getOrgType(intType);
            OrganizationPO po = new OrganizationPO(Integer.toString(organization_id), type, name);
            result.add(po);
        }
        DatabaseManager.releaseConnection(connection,statement,resultSet);
        return result;
    }


}
