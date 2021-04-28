package medical.manage.store.service;

import java.util.List;

import medical.manage.store.model.PurchaseDetails;

public interface PurchaseMedicineService {

	String purchaseMedicine(List<PurchaseDetails> purchaseDetailsList);

}
