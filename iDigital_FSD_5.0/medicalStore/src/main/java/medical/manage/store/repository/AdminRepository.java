package medical.manage.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
