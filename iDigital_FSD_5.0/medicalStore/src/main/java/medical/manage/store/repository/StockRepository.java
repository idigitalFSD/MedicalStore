package medical.manage.store.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import medical.manage.store.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	//@Query("Select s.manufacturer, s.medicine from stock s ")
	//public List<Stock> findReport();
	
	// Try using this instead of above
//	@Query("Select s from Stock s")
//	public List<Stock> findReport();

	
	@Modifying
	@Query("update stock stk set stk.inStock =(:quantity-stk.inStock) where stk.medicine = :medId AND stk.manufacturer = :mfgId")
	int setInStockForSell(int medId, int mfgId, int quantity);
	
	@Modifying
	@Query("update stock stk set stk.sold =(:quantity+stk.sold) where stk.medicine = :medId AND stk.manufacturer = :mfgId")
	int setSoldForSell(int medId, int mfgId, int quantity);
	
	@Modifying
	@Query("update stock stk set stk.inStock =(:quantity+stk.inStock) where stk.medicine = :medId AND stk.manufacturer = :mfgId")
	int setInStockForPurchaseInteger(int medId, int mfgId, int quantity);

}


/*
 * package medical.manage.store.repository;
 * 
 * import java.util.List;
 * 
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Modifying; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.stereotype.Repository;
 * 
 * import medical.manage.store.model.Stock;
 * 
 * @Repository public interface StockRepository extends JpaRepository<Stock,
 * Integer> {
 * 
 * @Query("Select s.manufacturer, s.medicine from stock s ") public List<Stock>
 * findReport();
 * 
 * // Try using this instead of above // @Query("Select s from Stock s") //
 * public List<Stock> findReport();
 * 
 * 
 * @Modifying
 * 
 * @Query("update stock stk set stk.inStock =(:quantity-stk.inStock) where stk.medicine = :medId AND stk.manufacturer = :mfgId"
 * ) int setInStockForSell(int medId, int mfgId, int quantity);
 * 
 * @Modifying
 * 
 * @Query("update stock stk set stk.sold =(:quantity+stk.sold) where stk.medicine = :medId AND stk.manufacturer = :mfgId"
 * ) int setSoldForSell(int medId, int mfgId, int quantity);
 * 
 * @Modifying
 * 
 * @Query("update stock stk set stk.inStock =(:quantity+stk.inStock) where stk.medicine = :medId AND stk.manufacturer = :mfgId"
 * ) int setInStockForPurchaseInteger(int medId, int mfgId, int quantity);
 * 
 * }
 */