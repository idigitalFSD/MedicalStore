package medical.manage.store.service;

import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import medical.manage.store.model.Manufacturer;
import medical.manage.store.repository.ManufacturerRepository;

@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class ManufacturerServiceTest {

	@MockBean
	ManufacturerService manufacturerService;

	@MockBean
	ManufacturerRepository manufacturerRepository;

	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {

	}

	/**
	 * Testing add medicine
	 */
////	 @Test
//	void testAddMedicine1() {
//		medicineService.addMedicine(medicine);
//		verify(medicineService, times(1)).addMedicine(medicine);
//		assertEquals("Metformin", medicine.getMedicineName());
//		when(medicineRepository.save(medicine)).thenReturn(medicine);
//		assertEquals(medicine, medicineService.addMedicine(medicine));
//	}

	@Test
	void addManufacturerTest() {
		Manufacturer manufacturer = new Manufacturer();
		Manufacturer manufacturerCheck = new Manufacturer();

		manufacturer.setMfgLicence("fdp4917706");
		
		manufacturerCheck.setManufacturerId(10007);
		manufacturerCheck.setMfgLicence("fdp4917706");

		Mockito.when(manufacturerService.addManufacturer(manufacturer)).thenReturn(manufacturerCheck);
		assertEquals(1, manufacturerCheck.getManufacturerId());
		assertEquals("Metamorfene", manufacturerCheck.getMfgLicence());

	}

	@Test
	void ViewAllManufacturerTest() {
		Manufacturer manufacturer = new Manufacturer();
		Manufacturer manufacturerCheck = new Manufacturer();

		manufacturer.setMfgLicence("qkl1935027");
		manufacturerCheck.setMfgLicence("hai5720063");


		List<Manufacturer> manufacturerList = new ArrayList<>();
		manufacturerList.add(manufacturer);
		manufacturerList.add(manufacturerCheck);
		
		   Mockito.when(manufacturerService.viewAllManufacturer()).thenReturn(manufacturerList);
		    assertEquals(manufacturer.getMfgLicence(), manufacturerList.get(0).getMfgLicence());
		    assertEquals(manufacturerCheck.getMfgLicence(), manufacturerList.get(1).getMfgLicence());
	}

	/*
	 * @Test void deleteManufacturerTest() throws Exception {
	 * 
	 * Mockito.when(manufacturerService.deleteManufacturer(2)).
	 * thenReturn("Medicine is deleted!"); }
	 */
	
	@Test
	void updateManufacturerTest() {
		Manufacturer manufacturer = new Manufacturer();
		Manufacturer manufacturerCheck = new Manufacturer();

		manufacturer.setMfgLicence("hqt37832057");
		
		manufacturerCheck.setManufacturerId(10007);
		manufacturerCheck.setMfgLicence("hqt37832057");

	   Mockito.when(manufacturerService.updateManufacturerDetails(manufacturer)).thenReturn(manufacturerCheck);
		
		assertEquals(6, manufacturerCheck.getManufacturerId());
		assertEquals("Metformin", manufacturerCheck.getMfgLicence());
	}

}
