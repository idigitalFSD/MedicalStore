package medical.manage.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

}
