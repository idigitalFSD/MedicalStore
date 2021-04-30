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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import medical.manage.store.model.Manufacturer;
import medical.manage.store.repository.ManufacturerRepository;
import medical.manage.store.service.impl.ManufacturerServiceImpl;



//@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class ManufacturerServiceTest {
	@MockBean
	ManufacturerServiceImpl manuService;

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

	
	
	@Test
	void createManufacturerTest() {
	Manufacturer newManu = new Manufacturer();
	Manufacturer manuCheck = new Manufacturer();

		newManu.setMfgLicence("hrt7200173");
		
		manuCheck.setManufacturerId(10014);
		manuCheck.setMfgLicence("hrt7200173");

		Mockito.when(manuService.addManufacturer(newManu)).thenReturn(manuCheck);
		
		assertEquals("hrt7200173", manuCheck.getMfgLicence());

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
		
		   Mockito.when(manuService.viewAllManufacturer()).thenReturn(manufacturerList);
		    assertEquals(manufacturer.getMfgLicence(), manufacturerList.get(0).getMfgLicence());
		    assertEquals(manufacturerCheck.getMfgLicence(), manufacturerList.get(1).getMfgLicence());
	}


	
	@Test
	void updateManufacturerTest() {
		Manufacturer newManu = new Manufacturer();
		Manufacturer manuCheck = new Manufacturer();

		newManu.setMfgLicence("qkl1935027");
		
		manuCheck.setManufacturerId(10013);
		manuCheck.setMfgLicence("qkl1935027");

	   Mockito.when(manuService.updateManufacturerDetails( newManu)).thenReturn(manuCheck);
		
		assertEquals(10013,10013);
		assertEquals("qkl1935027",manuCheck.getMfgLicence());
	}


}