package medical.manage.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.MedicinePurchased;

@Repository
public interface MedicinePurchasedRepository extends JpaRepository<MedicinePurchased, Integer> {

	Optional<MedicinePurchased> findByMedicineName(String medicineName);

	void deleteByMedicineName(String medicineName);

}
