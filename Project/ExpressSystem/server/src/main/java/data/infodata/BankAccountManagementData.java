package data.infodata;

import data.database.DatabaseFactory;
import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseManager;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.BankAccountManagementDataService;
import po.BankAccountPO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class BankAccountManagementData implements BankAccountManagementDataService{

    private Connection connection;

    public BankAccountManagementData() throws RemoteException {
        super();
        
    }

    @Override
    public boolean addBankAccount(BankAccountPO account) throws RemoteException, InterruptWithExistedElementException, SQLException {
    	connection = DatabaseManager.getConnection();
        LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        try {
            if(findBankAccount(account).size()>0) {
                logIns.insertSystemLog("试图新增银行账户:"+account.getName()+","+account.getNumber()+"，但银行账户已存在，取消操作");
                DatabaseManager.releaseConnection(connection,null,null);
                throw new InterruptWithExistedElementException();
            }
        } catch (ElementNotFoundException e1) {
            // That's OK
        }

        String stat = "insert into BankAccounts (name,number,balance) values ('"+account.getNumber()+"','"+
                account.getNumber()+"','"+account.getBalance()+"')";
        PreparedStatement statement = connection.prepareStatement(stat);

        int result = 0;
        try {
            result = statement.executeUpdate();
        } catch (SQLException e) {
            logIns.insertSystemLog("新增银行账户失败");
            DatabaseManager.releaseConnection(connection,statement,null);
            return false;
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

    @Override
    public boolean removeBankAccount(BankAccountPO account) throws RemoteException, ElementNotFoundException, SQLException {
    	connection = DatabaseManager.getConnection();
    	LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        if(findBankAccount(account).size()==0) {
        	DatabaseManager.releaseConnection(connection,null,null);
        	throw new ElementNotFoundException("未找到此银行账户，删除操作取消");
        }

        String stmt = "delete from BankAccounts where number='"+account.getNumber()+"'";
        PreparedStatement stat = connection.prepareStatement(stmt);
        int result = 0;
        try {
            result = stat.executeUpdate();
        } catch (SQLException e) {
            logIns.insertSystemLog("删除银行账户失败");
            DatabaseManager.releaseConnection(connection,stat,null);
            return false;
        }
        DatabaseManager.releaseConnection(connection,stat,null);
        return result >0;

    }


    @Override
    public ArrayList<BankAccountPO> findBankAccount(BankAccountPO accountInfo) throws RemoteException, ElementNotFoundException, SQLException {
    	connection = DatabaseManager.getConnection();
    	LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        String stmt = "select * from BankAccounts ";

        if(accountInfo==null) {
            //Just get all acccounts.
        } else {
            stmt = stmt + "where ";
            if(accountInfo.getName()!=null) {
                stmt = stmt + "(name LIKE '%"+accountInfo.getName()+"%') ";
            }
            if(accountInfo.getNumber()!=null) {
                if(accountInfo.getName()!=null) stmt = stmt + " OR ";
                stmt = stmt + "(number='"+accountInfo.getNumber()+"')";
            }
        }


        PreparedStatement stat = connection.prepareStatement(stmt);
        ResultSet set = stat.executeQuery();

        ArrayList<BankAccountPO> result = new ArrayList<>();

        while(set.next()) {
            result.add(new BankAccountPO(set.getString("name"), set.getString("number"), set.getString("balance")));
        }

        logIns.insertSystemLog("查找了银行账户：name="+accountInfo.getName()+",number="+accountInfo.getNumber());
        DatabaseManager.releaseConnection(connection,stat,set);
        return result;
    }

    @Override
    public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException, ElementNotFoundException, SQLException {
        return findBankAccount(null);
    }

    @Override
    public boolean modifyBankAccount(BankAccountPO account)	throws RemoteException, ElementNotFoundException,
            InterruptWithExistedElementException, SQLException {
    	connection = DatabaseManager.getConnection();
    	LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        BankAccountPO searched = new BankAccountPO(null, account.getNumber(), null);
        if(findBankAccount(searched).size()==0){
            logIns.insertSystemLog("修改银行账户,但账户不存在");
            DatabaseManager.releaseConnection(connection,null,null);
            throw new ElementNotFoundException("未找到银行账户，修改操作取消");
        }

        String stmt = "update BankAccounts name='"+account.getName()+"' where number='"+account.getNumber()+"'";
        PreparedStatement stat = connection.prepareStatement(stmt);
        int result = stat.executeUpdate();

        logIns.insertSystemLog("修改银行账户,number='"+account.getNumber()+"',name="+account.getName());
        DatabaseManager.releaseConnection(connection,stat,null);
        return result > 0;
    }
}
