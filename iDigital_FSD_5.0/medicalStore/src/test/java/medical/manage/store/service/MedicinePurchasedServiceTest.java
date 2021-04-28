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

import medical.manage.store.model.MedicinePurchased;
import medical.manage.store.repository.MedicinePurchasedRepository;

@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class MedicinePurchasedServiceTest {

//	Medicine medicine;

	@MockBean
	MedicinePurchasedService medicineService;

	@MockBean
	MedicinePurchasedRepository medicineRepository;

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
	void testAddMedicine2() {
		MedicinePurchased medicine = new MedicinePurchased();
		MedicinePurchased medicineMatch = new MedicinePurchased();

		medicine.setMedicineName("Metformin");
		
		medicineMatch.setMedicineId(1);
		medicineMatch.setMedicineName("Metformain");

		Mockito.when(medicineService.addMedicine(medicine)).thenReturn(medicineMatch);
		assertEquals(1, medicineMatch.getMedicineId());
		assertEquals("Metformin", medicineMatch.getMedicineName());

	}
	
	/**
	 * Testing to find all users
	 */
////	@Test
//	void testGetAllMedicines1() {
//		List<Medicine> medicineList = new ArrayList<>();
//		medicineList.add(medicine);
//		when(medicineService.getAllMedicine()).thenReturn(medicineList);
//		medicineService.getAllMedicine();
//		verify(medicineService, times(1)).getAllMedicine();
//		assertEquals(1, medicineList.size());
//		assertNotNull(medicineList);
//	}

//	@Test
	void testGetAllMedicines2() {
		MedicinePurchased medicine1 = new MedicinePurchased();
		MedicinePurchased medicine2 = new MedicinePurchased();

		medicine1.setMedicineName("Glimipride");
		medicine2.setMedicineName("Methyle Cobalamine");


		List<MedicinePurchased> medicineList = new ArrayList<>();
		medicineList.add(medicine1);
		medicineList.add(medicine2);
		
		   Mockito.when(medicineService.getAllMedicine()).thenReturn(medicineList);
		    assertEquals(medicine1.getMedicineName(), medicineList.get(0).getMedicineName());
		    assertEquals(medicine2.getMedicineName(), medicineList.get(1).getMedicineName());
	}
	
//	@Test
	void testPositiveGetByName() {
		MedicinePurchased medicine1 = new MedicinePurchased();

		String medicineName="Glimipride";
		
		medicine1.setMedicineId(2);
		medicine1.setMedicineName(medicineName);

		   Mockito.when(medicineService.getByMedicineName(medicineName)).thenReturn(medicine1);
		   assertEquals(medicineName,medicine1.getMedicineName());
	}

//    @Test
	  void testNegativeGetByName() {
			
		  MedicinePurchased medicine = new MedicinePurchased();
		  
			   Mockito.when(medicineService.getByMedicineName("XYZ")).thenReturn(medicine);
			   assertNotEquals("XYZ",medicine.getMedicineName());
	}

//	@Test
	void testPositiveGetById() {
		MedicinePurchased medicine1 = new MedicinePurchased();
		
		int medicineId = 2;
		
		medicine1.setMedicineId(medicineId);
		medicine1.setMedicineName("Glimipride");

		   Mockito.when(medicineService.getById(medicineId)).thenReturn(medicine1);
		   assertEquals(medicineId,medicine1.getMedicineId());
	}

//  @Test
	void testNegativeGetById() {
		MedicinePurchased medicine = new MedicinePurchased();
		
		   Mockito.when(medicineService.getById(100)).thenReturn(medicine);
		   assertNotEquals(100,medicine.getMedicineId());
	}
	
//	@Test
	void testRemoveByMedicineName() throws Exception {

  Mockito.when(medicineService.removeByMedicineName("Glimipride")).thenReturn("Medicine is deleted!");
  
}

//	@Test
	void testDeleteById() throws Exception {

	  Mockito.when(medicineService.removeById(2)).thenReturn("Medicine is deleted!");
}
	
//	@Test
	void testModify() {
		MedicinePurchased medicine = new MedicinePurchased();
		MedicinePurchased medicineMatch = new MedicinePurchased();

		medicine.setMedicineName("Metformin");
		
		medicineMatch.setMedicineId(1);
		medicineMatch.setMedicineName("Metformain");

	   Mockito.when(medicineService.modifyMedicine(medicine)).thenReturn(medicineMatch);
		
		assertEquals(6, medicineMatch.getMedicineId());
		assertEquals("Metformin", medicineMatch.getMedicineName());
	}

}