package medical.manage.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Purchase;

@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase, Integer>{

}
