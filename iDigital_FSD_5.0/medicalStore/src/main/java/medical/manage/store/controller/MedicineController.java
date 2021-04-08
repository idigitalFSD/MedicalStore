package medical.manage.store.controller;

import java.util.List;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medical.manage.store.constants.MedicalStoreConstants;
import medical.manage.store.model.Medicine;
import medical.manage.store.service.MedicineService;
import medical.manage.store.utils.Message;


@CrossOrigin
@RestController()
@RequestMapping("/api/v1/medicalstore/medicines")
public class MedicineController {

	@Autowired
	MedicineService medicineService;

	@RequestMapping("/hello")
	public String hello() {
		return MedicalStoreConstants.WELCOME_MESSAGE;
	}
	
	@PostMapping("/add")
	public Message addMedicine(@Valid @RequestBody Medicine medicine) {
		medicineService.addMedicine(medicine);
		return new Message("successfully added!!");
	}

	@GetMapping("/")
	public List<Medicine> getAllMedicine() {
		return medicineService.getAllMedicine();
	}
	
	@GetMapping("/getbyname/{medicineName}")
	public Medicine getMedicineByName(@Valid @PathVariable String medicineName) {
		return medicineService.getByMedicineName(medicineName);
	}

	@GetMapping("/getbyid/{medicineId}")
	public Medicine getMedicineById(@Valid @PathVariable int medicineId) {
		return medicineService.getById(medicineId);
	}
	
	@DeleteMapping("/delete/{medicineId}")
	public Message deleteMedicinebyId(@Valid @PathVariable int medicineId) {
		String deleteMessage = medicineService.removeById(medicineId);
		Message message = new Message(deleteMessage);
		return message;
	}

	@DeleteMapping("/deletebyname/{medicineName}")
	public Message deleteMedicinebyName(@Valid @PathVariable String medicineName) {
		String deleteMessage =medicineService.removeByMedicineName(medicineName);
		Message message = new Message(deleteMessage);
		return message;
	}
	
	@PutMapping("/modify")
	public Message modify(@Valid @RequestBody Medicine medicine) {
		medicineService.modifyMedicine(medicine);
		return new Message("Successfully modified !");
	}
}
