/*
 * package medical.manage.store.service;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mockito; import
 * org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.annotation.Rollback; import
 * org.springframework.test.context.junit.jupiter.SpringExtension;
 * 
 * import medical.manage.store.model.Manufacturer; import
 * medical.manage.store.model.MedicinePurchased; import
 * medical.manage.store.model.Stock; import
 * medical.manage.store.repository.ManufacturerRepository; import
 * medical.manage.store.repository.MedicinePurchasedRepository; import
 * medical.manage.store.repository.StockRepository; import
 * medical.manage.store.service.impl.StockServiceImpl;
 * 
 * @ExtendWith(MockitoExtension.class)
 * 
 * @ExtendWith(SpringExtension.class)
 * 
 * @SpringBootTest class StockServiceTest {
 * 
 * @InjectMocks private StockServiceImpl stockService;
 * 
 * @MockBean private StockRepository stockRepo;
 * 
 * @Autowired private ManufacturerRepository mRepository;
 * 
 * 
 * @Autowired private MedicinePurchasedRepository mRepo;
 * 
 * // @Test // public void testAddStock() { //test for adding stock // Stock
 * stock = new Stock(); // stock.setCostEach(10); // stock.setInStock(3); //
 * stock.setSold(2); // // List<Manufacturer> manufacturerList=new
 * ArrayList<Manufacturer>(); // Manufacturer m1=new
 * Manufacturer("Cipla","abcd","Malad west"); // Manufacturer
 * m3=mRepository.save(m1); // manufacturerList.add(m3); //
 * stock.setManufacturer(manufacturerList); // // List<Medicine>
 * medicineList=new ArrayList<Medicine>(); // Medicine m2=new
 * Medicine("Paracetamol"); // Medicine m4=mRepo.save(m2); //
 * medicineList.add(m4); // stock.setMedicine(medicineList); // //
 * Mockito.when(stockRepo.save(stock)).thenReturn(stock); //
 * assertThat(stock).isEqualTo(stock); // }
 * 
 * 
 * @Test
 * 
 * @Rollback(true) public void testGetReport() { //test for viewing report Stock
 * stock1 = new Stock(); stock1.setCostEach(10); stock1.setInStock(3);
 * stock1.setSold(2);
 * 
 * List<Manufacturer> manufacturerList=new ArrayList<Manufacturer>();
 * Manufacturer m1=new Manufacturer("Cipla","abcd","Malad west"); Manufacturer
 * m3=mRepository.save(m1); manufacturerList.add(m3);
 * stock1.setManufacturer(manufacturerList);
 * 
 * List<MedicinePurchased> medicineList=new ArrayList<MedicinePurchased>();
 * MedicinePurchased m2=new MedicinePurchased("Paracetamol"); MedicinePurchased
 * m4=mRepo.save(m2); medicineList.add(m4); stock1.setMedicine(medicineList);
 * 
 * Stock stock2 = new Stock(); stock2.setCostEach(10); stock2.setInStock(3);
 * stock2.setSold(2);
 * 
 * List<Manufacturer> manufacturerList1=new ArrayList<Manufacturer>();
 * Manufacturer man1=new Manufacturer("Cipla","abcd","Malad west"); Manufacturer
 * man2=mRepository.save(man1); manufacturerList1.add(man2);
 * stock2.setManufacturer(manufacturerList1);
 * 
 * List<MedicinePurchased> medicineList1=new ArrayList<MedicinePurchased>();
 * MedicinePurchased med1=new MedicinePurchased("Paracetamol");
 * MedicinePurchased med2=mRepo.save(med1); medicineList1.add(med2);
 * stock1.setMedicine(medicineList1);
 * 
 * List<Stock> stockList=new ArrayList<>(); stockList.add(stock1);
 * stockList.add(stock2);
 * 
 * Mockito.when(stockRepo.findAll()).thenReturn(stockList);
 * assertThat(stockService.getReport()).isEqualTo(stockList); }
 * 
 * }
 * 
 */