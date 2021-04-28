package medical.manage.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.AdminToAdmin;


@Repository
public interface AdminToAdminRepository extends JpaRepository<AdminToAdmin,Long> {

}
