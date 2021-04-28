package medical.manage.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Registration;

	@Repository
	public interface LoginRepository extends JpaRepository<Registration, String>
	{ 
		/*
		 * This method for checking whether userId present in database or not
		 */
		
	@Query("select t from Registration t where t.userId=:userId")
	Registration findByID(@Param("userId") String userId);

	}
