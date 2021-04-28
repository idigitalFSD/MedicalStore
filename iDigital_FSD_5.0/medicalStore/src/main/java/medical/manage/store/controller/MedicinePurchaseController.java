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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import medical.manage.store.constants.MedicalStoreConstants;
import medical.manage.store.model.MedicinePurchased;
import medical.manage.store.service.MedicinePurchasedService;
import medical.manage.store.utils.Message;

@Api(value = "Medicine", tags = { "MedicineAPI" })
@CrossOrigin
@RestController()
@RequestMapping("/api/v1/medicalstore/medicines")
public class MedicinePurchaseController {

	@Autowired
	MedicinePurchasedService medicineService;

	@GetMapping("/hello")
	public String hello() {
		return MedicalStoreConstants.WELCOME_MESSAGE;
	}
	
	@ApiOperation(value = "Adding a medicine", notes = "Add the medicine and display message- successfully added", response = MedicinePurchased.class)
	@PostMapping("/add")
	public Message addMedicine(@Valid @RequestBody MedicinePurchased medicine) {
		medicineService.addMedicine(medicine);
		return new Message("successfully added!!");
	}

	@ApiOperation(value = "Getting all the medicines", notes = "Get all the medicines present in database and display", response = MedicinePurchased.class)
	@GetMapping("/get_all_medicine")
	public List<MedicinePurchased> getAllMedicine() {
		return medicineService.getAllMedicine();
	}
	
	@ApiOperation(value = "Searching a medicine by its name", notes = "Get the medicine present in database by its name, else display not found", response = MedicinePurchased.class)
	@GetMapping("/getbyname/{medicineName}")
	public MedicinePurchased getMedicineByName(@Valid @PathVariable String medicineName) {
		return medicineService.getByMedicineName(medicineName);
	}

	@ApiOperation(value = "Searching a medicine by its ID", notes = "Get the medicine present in database by its ID, else display not found", response = MedicinePurchased.class)
	@GetMapping("/getbyid/{medicineId}")
	public MedicinePurchased getMedicineById(@Valid @PathVariable int medicineId) {
		return medicineService.getById(medicineId);
	}
	
	@ApiOperation(value = "Deleting a medicine searched by its ID", notes = "Deleting the medicine present in database by its ID, else display not found", response = MedicinePurchased.class)
	@DeleteMapping("/delete/{medicineId}")
	public Message deleteMedicinebyId(@Valid @PathVariable int medicineId) {
		String deleteMessage = medicineService.removeById(medicineId);
		Message message = new Message(deleteMessage);
		return message;
	}

	@ApiOperation(value = "Deleting a medicine searched by its name", notes = "Deleting the medicine present in database by its name, else display not found", response = MedicinePurchased.class)
	@DeleteMapping("/deletebyname/{medicineName}")
	public Message deleteMedicinebyName(@Valid @PathVariable String medicineName) {
		String deleteMessage =medicineService.removeByMedicineName(medicineName);
		Message message = new Message(deleteMessage);
		return message;
	}
	
	@ApiOperation(value = "Modifying medicine", notes = "Modifying the medicine present in database and display message, modified successfully/ Not found", response = MedicinePurchased.class)
	@PutMapping("/modify")
	public Message modify(@Valid @RequestBody MedicinePurchased medicine) {
		medicineService.modifyMedicine(medicine);
		return new Message("Successfully modified !");
	}
}
