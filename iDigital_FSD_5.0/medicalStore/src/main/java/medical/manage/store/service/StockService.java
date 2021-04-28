package medical.manage.store.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import medical.manage.store.model.Stock;

public interface StockService {

	/**
	 * Get Stock method
	 * 
	 * @return Stock
	 */
	public List<Stock> getStock();

	/**
	 * Add Stock method
	 * 
	 * @return Stock
	 */
	public Stock addStock(@Valid Stock stock);

	public Optional<Stock> removeById(@Valid int stockId);

	public Stock modifyStock(@Valid Stock stock);

	public Stock getStockById(@Valid int stockId);

	
}


/*
 * package medical.manage.store.service;
 * 
 * import java.util.List;
 * 
 * import javax.validation.Valid;
 * 
 * import medical.manage.store.model.Stock;
 * 
 * public interface StockService {
 * 
 *//**
	 * Get Report method
	 * 
	 * @return Report
	 *//*
		 * public List<Stock> getReport();
		 * 
		 * public Stock addStock(@Valid Stock stock); }
		 */