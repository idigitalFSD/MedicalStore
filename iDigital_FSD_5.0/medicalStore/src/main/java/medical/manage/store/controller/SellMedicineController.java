package medical.manage.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medical.manage.store.model.OrderDetails;
import medical.manage.store.service.SellMedicineService;
import medical.manage.store.utils.Message;

@CrossOrigin
@RestController()
@RequestMapping("/api/v1/medicalstore/stock")
public class SellMedicineController {

	@Autowired
	SellMedicineService sellMedicineService;

	@PostMapping("/sell")
	public Message sellingMedicine(@Valid @RequestBody List<OrderDetails>orderDetailsList) {
		sellMedicineService.sellMedicine(orderDetailsList);
		return new Message("medicine sold !");
	}

}