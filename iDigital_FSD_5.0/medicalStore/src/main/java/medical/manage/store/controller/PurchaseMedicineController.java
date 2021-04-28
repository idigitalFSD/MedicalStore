package medical.manage.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medical.manage.store.model.PurchaseDetails;
import medical.manage.store.service.PurchaseMedicineService;
import medical.manage.store.utils.Message;

@CrossOrigin
@RestController()
@RequestMapping("/api/v1/medicalstore/stock")
public class PurchaseMedicineController {
	@Autowired
	PurchaseMedicineService purchaseMedicineService;

	@PostMapping("/purchase")
	public Message sellingMedicine(@Valid @RequestBody List<PurchaseDetails> purchaseDetailsList) {
		purchaseMedicineService.purchaseMedicine(purchaseDetailsList);
		return new Message("medicine purchased !");
	}

}
