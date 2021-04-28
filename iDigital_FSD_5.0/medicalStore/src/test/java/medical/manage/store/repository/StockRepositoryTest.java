/*
 * package medical.manage.store.repository;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.Assert.assertNotNull;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
 * import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.
 * Replace; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.test.annotation.Rollback; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import medical.manage.store.exceptions.ResourceNotFoundException; import
 * medical.manage.store.model.Manufacturer; import
 * medical.manage.store.model.MedicinePurchased; import
 * medical.manage.store.model.Stock; import
 * medical.manage.store.repository.ManufacturerRepository; import
 * medical.manage.store.repository.MedicinePurchasedRepository; import
 * medical.manage.store.repository.StockRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @AutoConfigureTestDatabase(replace = Replace.NONE)
 * 
 * @DataJpaTest class StockRepositoryTest {
 * 
 * @Autowired private StockRepository stockRepository;
 * 
 * @Autowired private ManufacturerRepository mRepository;
 * 
 * 
 * @Autowired private MedicinePurchasedRepository mRepo;
 * 
 * public Stock viewStock() { Stock stock = new Stock(); stock.setCostEach(10);
 * stock.setInStock(3); stock.setSold(2);
 * 
 * List<Manufacturer> manufacturerList=new ArrayList<Manufacturer>();
 * Manufacturer m1=new Manufacturer("Cipla","abcd","Malad west"); Manufacturer
 * m3=mRepository.save(m1); manufacturerList.add(m3);
 * stock.setManufacturer(manufacturerList);
 * 
 * List<MedicinePurchased> medicineList=new ArrayList<MedicinePurchased>();
 * MedicinePurchased m2=new MedicinePurchased("Paracetamol"); MedicinePurchased
 * m4=mRepo.save(m2); medicineList.add(m4); stock.setMedicine(medicineList);
 * 
 * return stock; }
 * 
 * @Test
 * 
 * @Rollback(true) public void testAddStock() { Stock s = viewStock(); Stock
 * actual = stockRepository.save(s); Stock expected =
 * stockRepository.getOne(actual.getStockId());
 * assertThat(actual).isEqualTo(expected); }
 * 
 * @Test public void testGetReport() { List<Stock> stockList =
 * stockRepository.findAll(); assertNotNull(stockList);
 * assertThat(stockList).size().isGreaterThan(0); }
 * 
 * 
 * 
 * 
 * }
 * 
 */