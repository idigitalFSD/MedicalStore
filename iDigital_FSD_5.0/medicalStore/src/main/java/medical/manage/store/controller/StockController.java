package medical.manage.store.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import medical.manage.store.model.Stock;
import medical.manage.store.service.StockService;
import medical.manage.store.utils.Message;

@CrossOrigin
@RestController()
@RequestMapping("/api/v1/medicalstore/stocks")
public class StockController {

	
	@Autowired
	StockService stockService;
	
	@ApiOperation(value = "Adding a stock", notes = "Add the stock and display message- successfully added", response = Stock.class)
	@PostMapping("/add")
	public Message addStock(@Valid @RequestBody Stock stock) {
		stockService.addStock(stock);
		return new Message("successfully added!!");
	}

	@ApiOperation(value = "Getting a stock", notes = "Get the stock and return stock list", response = Stock.class)
	@GetMapping("/")
	public List<Stock> getStock() {
		return stockService.getStock();
	}
	
	@ApiOperation(value = "Getting a stock", notes = "Get the stock and return stock list", response = Stock.class)
	@GetMapping("/{stockId}")
	public Stock getStockById(@Valid @PathVariable int stockId) {
			return stockService.getStockById(stockId);
	}
	
	@ApiOperation(value = "Deleting a stock searched by its ID", notes = "Deleting the stock present in database by its ID, else display not found", response = Stock.class)
	@DeleteMapping("/delete/{stockId}")
	public Message deleteStockbyId(@Valid @PathVariable int stockId) {
		Optional<Stock> s = stockService.removeById(stockId);
		if(s!=null) {
			Message message = new Message("stock deleted");
			return message;
		}
		return new Message("stock with given id does not exists");
		
	}

	
	@ApiOperation(value = "Modifying stock", notes = "Modifying the stock present in database and display message, modified successfully/ Not found", response = Stock.class)
	@PutMapping("/modify")
	public Message modify(@Valid @RequestBody Stock stock) {
		stockService.modifyStock(stock);
		return new Message("Successfully modified !");
	}
}


/*
 * package medical.manage.store.controller;
 * 
 * import java.util.List;
 * 
 * import javax.validation.Valid;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import medical.manage.store.model.Stock; import
 * medical.manage.store.service.StockService; import
 * medical.manage.store.utils.Message;
 * 
 * @CrossOrigin
 * 
 * @RestController()
 * 
 * @RequestMapping("/api/v1/medicalstore/stocks") public class StockController {
 * 
 * 
 * @Autowired StockService stockService;
 * 
 * 
 * @PostMapping("/add") public Message addStock(@Valid @RequestBody Stock stock)
 * { stockService.addStock(stock); return new Message("successfully added!!"); }
 * 
 * 
 * 
 * @GetMapping("/") public List<Stock> getReport() { return
 * stockService.getReport(); } }
 */