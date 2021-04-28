package medical.manage.store.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.constants.MedicalStoreConstants;
import medical.manage.store.exceptions.AlreadyExistsException;
import medical.manage.store.exceptions.ResourceNotFoundException;
import medical.manage.store.model.Customer;
import medical.manage.store.repository.AdminToCustomerRepository;
import medical.manage.store.service.AdminToCustomerService;

@Service
public class AdminToCustomerServiceImpl implements AdminToCustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminToCustomerServiceImpl.class);

	@Autowired
	private AdminToCustomerRepository customerRepo;
	
			
/**
 * Add Customer Method
 * 
 * @return customerCreation
 */
	@Override
	public Customer addCustomer(Customer customer) {
		String customerName = customer.getCustPhoneNum();
		Optional<Customer> optionalCustomer = customerRepo.findByCustPhoneNum(customerName);

		if (optionalCustomer.isPresent()) {
			logger.error("customer already exists");

			throw new AlreadyExistsException(MedicalStoreConstants.CUSTOMER_EXISTS);
		}

		else {
			Customer newCustomer = customerRepo.save(customer);
			logger.info("customer added successfully");
			return newCustomer;
		}

	}
	

	/**
	 * Get all customers method
	 * 
	 * @return allcustomers
	 */

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerRepo.findAll();
		if (allCustomers.isEmpty()) {
			logger.error("could not find customer");
			throw new ResourceNotFoundException(MedicalStoreConstants.CUSTOMER_NOT_FOUND);
		}
		
		return allCustomers;
	}

	/**
	 * Get customer by customerId method
	 * 
	 * @return customer
	 */
	@Override
	public Optional<Customer> getById(int custId) {
		Optional<Customer> optionalCustomer = customerRepo.findById(custId);
		if (!optionalCustomer.isPresent()) {
			logger.error("customer with " + custId + " does not exist");
			throw new ResourceNotFoundException("Customer does not exist!");
		}
		return optionalCustomer;
	}

	/**
	 * Remove customer by Id method
	 * 
	 * @return void
	 */
	@Override
	public String deleteById(int custId) {
		Optional<Customer> optionalCustomer = customerRepo.findById(custId);
		if (!optionalCustomer.isPresent()) {
			logger.error("customer with " + custId + " does not exist");
			throw new ResourceNotFoundException(MedicalStoreConstants.CUSTOMER_NOT_FOUND);
		} else {
			logger.info("customer details deleted");
			customerRepo.deleteById(custId);
			return "Customer is deleted!";
		}
	}

	
	/**
	 * Modify customer by Id method
	 * 
	 * @return customer
	 */
	
	@Override
	public Customer modifyCustomerById(int custId, Customer customer) {
		Optional<Customer> optionalCustomer = customerRepo.findById(custId);

		if (!optionalCustomer.isPresent()) {
			logger.error("customer with " + custId + " does not exist");
			throw new ResourceNotFoundException(MedicalStoreConstants.CUSTOMER_NOT_FOUND);
		} 
		else {
		
			//newCustomer.setCustId(custId);
			//newCustomer.setCustName(optionalCustomer.get().getCustName());
			//newCustomer.setCustGender(optionalCustomer.get().getCustGender());
			//newCustomer.setCustCity(optionalCustomer.get().getCustCity());
			//newCustomer.setCustAge(optionalCustomer.get().getCustAge());
			//newCustomer.setCustPhoneNum(optionalCustomer.get().getCustPhoneNum());
			
			customer.setCustId(custId);
			customer.setCustName(customer.getCustName());
			customer.setCustGender(customer.getCustGender());
			customer.setCustCity(customer.getCustCity());
			customer.setCustAge(customer.getCustAge());
			customer.setCustPhoneNum(customer.getCustPhoneNum());
			
		}
		logger.info("customer details Modified");
		return customerRepo.save(customer);
	}

	

	@Override
	public Customer updatecustomerDetails(@Valid Customer customer) {
		if(customerRepo.existsById(customer.getCustId())) {
			logger.info("customer details Modified");
			return customerRepo.saveAndFlush(customer);
		}
		else {
			throw new ResourceNotFoundException(MedicalStoreConstants.CUSTOMER_NOT_FOUND);
		}
	}

}
