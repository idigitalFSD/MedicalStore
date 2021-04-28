package medical.manage.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.model.PurchaseDetails;
import medical.manage.store.repository.PurchaseDetailsRepository;
import medical.manage.store.repository.StockRepository;
import medical.manage.store.service.PurchaseMedicineService;

@Service
public class PurchaseMedicineServiceImpl implements PurchaseMedicineService {

	@Autowired
	private PurchaseDetailsRepository purchaseDetailsRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public String purchaseMedicine(List<PurchaseDetails> purchaseDetailsList) {
		
		for (int i = 0; i < purchaseDetailsList.size(); i++)   
		{  
			PurchaseDetails purchaseDetails = purchaseDetailsList.get(i); 
			purchaseDetailsRepository.save(purchaseDetails);
			
			stockRepository.setInStockForPurchaseInteger(purchaseDetails.getInputMedicineId(), purchaseDetails.getInputManufacturerId(), purchaseDetails.getQuantityPurchase());
		} 

		return "Medicine purchased!";
	}
}
