package connection;

import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseFactory;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.commoditydataservice.StorageOutDataService;
import dataservice.financedataservice.CreditNoteInputDataService;
import dataservice.financedataservice.PaymentInputDataService;
import dataservice.financedataservice.SettlementManagementDataService;
import dataservice.infodataservice.BankAccountManagementDataService;
import dataservice.infodataservice.DriverVehicleManagementDataService;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.logisticdataservice.*;
import dataservice.statisticdataservice.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Created by kylin on 15/11/10.
 *
 * provider应该也是单例的,多个客户端,但只有一个provider
 */
public class RMIObjectProvider extends UnicastRemoteObject implements RMIObjectProviderService {

    private static final long serialVersionUID = -7307932469937624078L;

    private HashMap<String, Serializable> objMap =
            new HashMap<>();

    public RMIObjectProvider() throws RemoteException {
        initiateMap();
    }

    private void initiateMap() throws RemoteException {
        DatabaseFactory databaseFactory = DatabaseFactoryMysqlImpl.getInstance();

        //commodity
        InventoryDataService inventoryDataService = databaseFactory.getInventoryDataService();
        StorageInDataService storageInDataService = databaseFactory.getStorageInDataService();
        StorageOutDataService storageOutDataService = databaseFactory.getStorageOutDataService();

        objMap.put("InventoryDataService",inventoryDataService);
        objMap.put("StorageInDataService",storageInDataService);
        objMap.put("StorageOutDataService",storageOutDataService);

        //finance
        CreditNoteInputDataService creditNoteInputDataService = databaseFactory.getCreditNoteInputDataService();
        PaymentInputDataService paymentInputDataService = databaseFactory.getPaymentInputDataService();
        SettlementManagementDataService settlementManagementDataService = databaseFactory.getSettlementManagementDataService();

        objMap.put("CreditNoteInputDataService",creditNoteInputDataService);
        objMap.put("PaymentInputDataService",paymentInputDataService);
        objMap.put("SettlementManagementDataService",settlementManagementDataService);

        //info
        BankAccountManagementDataService bankAccountManagementDataService = databaseFactory.getBankAccountManagementDataService();
        DriverVehicleManagementDataService driverVehicleManagementDataService = databaseFactory.getDriverVehicleManagementDataService();
        StaffOrganizationManagementDataService staffOrganizationManagementDataService = databaseFactory.getStaffOrganizationManagementDataService();
        SystemUserManagementDataService systemUserManagementDataService = databaseFactory.getSystemUserManagementDataService();

        objMap.put("BankAccountManagementDataService",bankAccountManagementDataService);
        objMap.put("DriverVehicleManagementDataService",driverVehicleManagementDataService);
        objMap.put("StaffOrganizationManagementDataService",staffOrganizationManagementDataService);
        objMap.put("SystemUserManagementDataService",systemUserManagementDataService);

        //logistic
        ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService = databaseFactory.getArrivalNoteOnServiceDataService();
        ArrivalNoteOnTransitDataService arrivalNoteOnTransitDataService = databaseFactory.getArrivalNoteOnTransitDataService();
        DeliveryNoteInputDataService deliveryNoteInputDataService = databaseFactory.getDeliveryNoteInputDataService();
        LoadNoteOnServiceDataService loadNoteOnServiceDataService = databaseFactory.getLoadNoteOnServiceDataService();
        LoadNoteOnTransitDataService loadNoteOnTransitDataService = databaseFactory.getLoadNoteOnTransitDataService();
        ReceivingNoteInputDataService receivingNoteInputDataService = databaseFactory.getReceivingNoteInputDataService();
        TransitNoteInputDataService transitNoteInputDataService = databaseFactory.getTransitNoteInputDataService();

        objMap.put("ArrivalNoteOnServiceDataService",arrivalNoteOnServiceDataService);
        objMap.put("ArrivalNoteOnTransitDataService",arrivalNoteOnTransitDataService);
        objMap.put("DeliveryNoteInputDataService",deliveryNoteInputDataService);
        objMap.put("LoadNoteOnServiceDataService",loadNoteOnServiceDataService);
        objMap.put("LoadNoteOnTransitDataService",loadNoteOnTransitDataService);
        objMap.put("ReceivingNoteInputDataService",receivingNoteInputDataService);
        objMap.put("TransitNoteInputDataService",transitNoteInputDataService);

        //statistic
        BaseDataBuildingDataService baseDataBuildingDataService = databaseFactory.getBaseDataBuildingDataService();
        BusinessDataModificationDataService businessDataModificationDataService = databaseFactory.getBusinessDataModificationDataService();
        ChartOutputDataService chartOutputDataService = databaseFactory.getChartOutputDataService();
        LogInquiryDataService logInquiryDataService = databaseFactory.getLogInquiryDataService();
        NoteApprovingDataService noteApprovingDataService = databaseFactory.getNoteApprovingDataService();
        OrderInquiryDataService orderInquiryDataService = databaseFactory.getOrderInquiryDataService();

        objMap.put("BaseDataBuildingDataService",baseDataBuildingDataService);
        objMap.put("BusinessDataModificationDataService",businessDataModificationDataService);
        objMap.put("ChartOutputDataService",chartOutputDataService);
        objMap.put("LogInquiryDataService",logInquiryDataService);
        objMap.put("NoteApprovingDataService",noteApprovingDataService);
        objMap.put("OrderInquiryDataService",orderInquiryDataService);

        System.out.println("RMIObjectProvider-objMap 初始化完毕");
    }

    @Override
    public Object getObjectByName(String name) throws RemoteException {
        return objMap.get(name);
    }
}
