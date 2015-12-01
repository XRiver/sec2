package data.logisticdata.MockObject;

import po.DeliveryNotePO;
import util.enums.DeliverCategory;

/**
 * Created by kylin on 15/11/10.
 */
public class MockDeliveryNote extends DeliveryNotePO{

    public MockDeliveryNote(String senderName, String senderAddress, String senderTeleNumber,
                            String receiverName, String receiverAddress, String receiverTeleNumber,
                            String name, int goodsNumber, double weight, double volume, DeliverCategory category,
                            double packPrice, String barCode) {
        super(senderName, senderAddress, senderTeleNumber, receiverName, receiverAddress, receiverTeleNumber,
                name, goodsNumber, weight, volume, category, packPrice, barCode);
    }
}
