package data.database;

import data.statisticdata.inte.LogInsertDataService;
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

/**
 * Created by kylin on 15/11/18.
 */
public interface DatabaseFactory{

    InventoryDataService getInventoryDataService();

    StorageInDataService getStorageInDataService();

    StorageOutDataService getStorageOutDataService();

    CreditNoteInputDataService getCreditNoteInputDataService();

    PaymentInputDataService getPaymentInputDataService();

    SettlementManagementDataService getSettlementManagementDataService();

    BankAccountManagementDataService getBankAccountManagementDataService();

    DriverVehicleManagementDataService getDriverVehicleManagementDataService();

    StaffOrganizationManagementDataService getStaffOrganizationManagementDataService();

    SystemUserManagementDataService getSystemUserManagementDataService();

    ArrivalNoteOnServiceDataService getArrivalNoteOnServiceDataService();

    ArrivalNoteOnTransitDataService getArrivalNoteOnTransitDataService();

    DeliveryNoteInputDataService getDeliveryNoteInputDataService();

    LoadNoteOnServiceDataService getLoadNoteOnServiceDataService();

    LoadNoteOnTransitDataService getLoadNoteOnTransitDataService();

    ReceivingNoteInputDataService getReceivingNoteInputDataService();

    TransitNoteInputDataService getTransitNoteInputDataService();

    BaseDataBuildingDataService getBaseDataBuildingDataService();

    BusinessDataModificationDataService getBusinessDataModificationDataService();

    ChartOutputDataService getChartOutputDataService();

    LogInquiryDataService getLogInquiryDataService();

    NoteApprovingDataService getNoteApprovingDataService();

    OrderInquiryDataService getOrderInquiryDataService();

    LogInsertDataService getLogInsertDataService();
}
