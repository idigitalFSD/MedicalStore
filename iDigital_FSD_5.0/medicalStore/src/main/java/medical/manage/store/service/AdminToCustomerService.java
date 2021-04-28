package medical.manage.store.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import medical.manage.store.model.Customer;

public interface AdminToCustomerService {

	/**
	 * Adds customer to customer table
	 * 
	 * @return customerCreation
	 */
	Customer addCustomer(Customer customer);

	/**
	 * Get all customers method
	 * 
	 * @return allCustomers
	 */
	List<Customer> getAllCustomers();

	/**
	 * Get customer by customerbyId method
	 * 
	 * @return customer
	 */
	Optional<Customer> getById(int id);

	/**
	 * Remove customer by Id method
	 * 
	 * @return void
	 */
	String deleteById(int id);
	
	/**
	 * Modify customerById method
	 * @param customer 
	 * 
	 * @return customerModified
	 */
	Customer modifyCustomerById(int custId, Customer customer);



	/**
	 * Modify customer method
	 * @param customer 
	 * 
	 * @return customerModified
	 */
    Customer updatecustomerDetails(@Valid Customer customer);

	

	

}
