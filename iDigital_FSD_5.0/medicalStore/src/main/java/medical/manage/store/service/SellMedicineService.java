package medical.manage.store.service;

import java.util.List;

import medical.manage.store.model.OrderDetails;

public interface SellMedicineService {

	public String sellMedicine(List<OrderDetails> orderDetailsList);

}
