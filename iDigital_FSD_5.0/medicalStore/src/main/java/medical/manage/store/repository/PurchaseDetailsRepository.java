package medical.manage.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.PurchaseDetails;

@Repository
public interface PurchaseDetailsRepository  extends JpaRepository<PurchaseDetails, Integer>{

}
