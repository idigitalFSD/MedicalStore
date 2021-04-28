package medical.manage.store.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.model.OrderDetails;
import medical.manage.store.repository.OrderDetailsRepository;
import medical.manage.store.repository.StockRepository;
import medical.manage.store.service.SellMedicineService;

@Service
public class SellMedicineServiceImpl implements SellMedicineService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private StockRepository stockRepository;

	@Override
	public String sellMedicine(List<OrderDetails> orderDetailsList) {
		
		for (int i = 0; i < orderDetailsList.size(); i++)   
		{  
		OrderDetails orderDetails = orderDetailsList.get(i); 
		orderDetailsRepository.save(orderDetails);
		
		stockRepository.setInStockForSell(orderDetails.getInputMedicineId(), orderDetails.getInputManufacturerId(), orderDetails.getQuantityOrdered());
		stockRepository.setSoldForSell(orderDetails.getInputMedicineId(), orderDetails.getInputManufacturerId(), orderDetails.getQuantityOrdered());
		}
		return "Medicine sold !";
	}
}
