package medical.manage.store.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,String> {
    
	
}
