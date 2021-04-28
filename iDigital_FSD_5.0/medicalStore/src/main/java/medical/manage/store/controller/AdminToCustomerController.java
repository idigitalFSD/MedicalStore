package medical.manage.store.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medical.manage.store.model.Customer;
import medical.manage.store.service.AdminToCustomerService;
import medical.manage.store.utils.Message;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
@RequestMapping("/api/customer")
public class AdminToCustomerController {

	@Autowired
	AdminToCustomerService customerService;

	@PostMapping("/add")
	public List<Customer> add(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}

	@GetMapping("/")
	public List<Customer> fetchAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return customers;

	}

	@GetMapping("/customerById/{custId}")
	public Optional<Customer> getCustomerById(@Valid @PathVariable int custId) {
		return customerService.getById(custId);

	}

	@DeleteMapping("/delete/{custId}")
	public String deleteCustomer(@Valid @PathVariable int custId) {
		customerService.deleteById(custId);
		return ("Customer successfully deleted");

	}

	@PutMapping("/modify/{custId}")
	public ResponseEntity<String> modifyCustomerById(@Valid @PathVariable int custId, @RequestBody Customer customer) {
		customerService.modifyCustomerById(custId, customer);
		return new ResponseEntity<String>("Customer modified Successfully. ", HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public Message modify(@Valid @RequestBody Customer customer) {
		customerService.updatecustomerDetails(customer);
		return new Message("Successfully modified !");
	}

}
