package medical.manage.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Customer;

@Repository
public interface AdminToCustomerRepository extends JpaRepository<Customer, Integer> {

	//Optional<Customer> findByCustName(String customerName);

	Optional<Customer> findByCustPhoneNum(String customerName);

	Optional<Customer> findByCustName(String custName);



	

	





}
