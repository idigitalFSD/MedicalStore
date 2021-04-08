package medical.manage.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	Optional<Medicine> findByMedicineName(String name);

	void deleteByMedicineName(String medicineName);

}
