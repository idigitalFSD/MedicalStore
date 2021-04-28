package medical.manage.store.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.exceptions.AlreadyExistsException;
import medical.manage.store.exceptions.ResourceNotFoundException;
import medical.manage.store.model.Stock;
import medical.manage.store.repository.StockRepository;
import medical.manage.store.service.StockService;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository stockRepository;
	
	/**
	 * Get Stock method
	 * 
	 * @return stockList
	 */

	@Override
	public List<Stock> getStock(){
		List<Stock> stock = stockRepository.findAll();
		if (stock.isEmpty()) {
			throw new ResourceNotFoundException("Stock is Empty!!!");
		}
		else {
			return stock;
		}
	}

	/**
	 * Adds stock to stock table
	 * 
	 * @return stockCreation
	 */

	@Override
	public Stock addStock(Stock stock){
		if(stockRepository.existsById(stock.getStockId())) {
			throw new AlreadyExistsException("Stock Already Exists By Id!!!");
		}
		else {
			Stock newstock = stockRepository.save(stock);
			return newstock;
		}
	
	}

	/**
	 * remove stock from stock table
	 * 
	 * @return stcok deleted
	 */
	@Override
	public Optional<Stock> removeById(@Valid int stockId) {
		if(stockRepository.existsById(stockId)) {
			Optional<Stock> s=stockRepository.findById(stockId);
			stockRepository.deleteById(stockId);
			return s;
		}
		else {
			throw new ResourceNotFoundException("Stock not found with given Id");
		}
	}

	/**
	 * modify stock to stock table
	 * 
	 * @return modified stock
	 */
	@Override
	public Stock modifyStock(@Valid Stock stock) {
		if(stockRepository.existsById(stock.getStockId())) {
			return stockRepository.saveAndFlush(stock);
		}
		else {
			throw new ResourceNotFoundException("Stock not found with given Id");
		}
	
	}

	/**
	 * get stock by id in stock table
	 * 
	 * @return get stock
	 */
	@Override
	public Stock getStockById(@Valid int stockId) {
		if(stockRepository.existsById(stockId)) {
			return stockRepository.getOne(stockId);
		}
		else {
			throw new ResourceNotFoundException("Stock not found with given Id");
		}
		
	}

}


/*
 * package medical.manage.store.service.impl;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.TransactionSystemException;
 * 
 * import medical.manage.store.constants.MedicalStoreConstants; import
 * medical.manage.store.exceptions.AlreadyExistsException; import
 * medical.manage.store.exceptions.ResourceNotFoundException; import
 * medical.manage.store.model.Stock; import
 * medical.manage.store.repository.StockRepository; import
 * medical.manage.store.service.StockService;
 * 
 * @Service public class StockServiceImpl implements StockService{
 * 
 * @Autowired StockRepository stockRepository;
 * 
 *//**
	 * Get Report method
	 * 
	 * @return report
	 */
/*
 * 
 * @Override public List<Stock> getReport() throws TransactionSystemException{
 * List<Stock> report = stockRepository.findReport(); for(Stock i: report) {
 * System.out.println(i.getManufacturer()); System.out.println(i.getMedicine());
 * } if (report.isEmpty()) { throw new
 * ResourceNotFoundException("No Reports!!!"); } else { return report; } }
 * 
 *//**
	 * Adds stock to stock table
	 * 
	 * @return stockCreation
	 *//*
		 * 
		 * @Override public Stock addStock(Stock stock) throws
		 * TransactionSystemException{
		 * if(stockRepository.existsById(stock.getStockId())) { throw new
		 * AlreadyExistsException("Stock Already Exists By Id!!!"); } else { Stock
		 * newstock = stockRepository.save(stock); return newstock; }
		 * 
		 * 
		 * }
		 * 
		 * }
		 */