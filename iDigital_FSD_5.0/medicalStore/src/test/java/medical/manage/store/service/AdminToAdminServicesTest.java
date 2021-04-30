package medical.manage.store.services;
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

import medical.manage.store.model.AdminToAdmin;

import medical.manage.store.repository.AdminToAdminRepository;
import medical.manage.store.service.impl.AdminToAdminServiceImpl;



//@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class AdminToAdminServicesTest {
	@MockBean
	AdminToAdminServiceImpl adminToAdminService;

	@MockBean
	AdminToAdminRepository adminToAdminRepository;

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
	void createNewAdminTest() {
	AdminToAdmin newAdmin = new AdminToAdmin();
		AdminToAdmin adminCheck = new AdminToAdmin();

		newAdmin.setAdminName("Rahul Soni");
		
		adminCheck.setAdminId(25L);
		adminCheck.setAdminName("Rahul Soni");

		Mockito.when(adminToAdminService.createNewAdmin(newAdmin)).thenReturn(adminCheck);
		
		assertEquals("Rahul Soni", adminCheck.getAdminName());

	}

	@Test
	void ViewAllManufacturerTest() {
		AdminToAdmin newAdmin = new AdminToAdmin();
		AdminToAdmin adminCheck = new AdminToAdmin();

	newAdmin.setAdminName("Mahima singh");
		adminCheck.setAdminName("Lakshika Ahire");
		


		List<AdminToAdmin> adminList = new ArrayList<>();
		adminList.add(newAdmin);
		adminList.add(adminCheck);
		
		   Mockito.when(adminToAdminService.getAllAdminDetails()).thenReturn(adminList);
		    assertEquals(newAdmin.getAdminName(), adminList.get(0).getAdminName());
		    assertEquals(adminCheck.getAdminName(), adminList.get(1).getAdminName());
	}


	
	@Test
	void updateManufacturerTest() {
		AdminToAdmin newAdmin = new AdminToAdmin();
		AdminToAdmin adminCheck = new AdminToAdmin();

		newAdmin.setAdminName("kavya jain");
		
		adminCheck.setAdminId(24L);
		adminCheck.setAdminName("kavya jain");

	   Mockito.when(adminToAdminService.updateOrSaveAdminDetails( newAdmin,24L)).thenReturn(adminCheck);
		
		assertEquals(24L,24L);
		assertEquals("kavya jain",adminCheck.getAdminName());
	}


}
