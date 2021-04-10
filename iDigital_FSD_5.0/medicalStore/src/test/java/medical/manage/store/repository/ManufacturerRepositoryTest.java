package medical.manage.store.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import medical.manage.store.model.Manufacturer;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ManufacturerRepositoryTest {
	
	@Autowired
	private ManufacturerRepository manufacturerRepo;
	
	// Add Manufacturer test
	
	@Test
	public void testCreateProduct() {
		Manufacturer manufacturer = manufacturerRepo.save(
				new Manufacturer("Jeevan Medical store","guw3710445","Shri Vilas Area, Jaipur"));
	     
	    assertThat(manufacturer.getManufacturerId()).isGreaterThan(0);
	}

	// View all manufacturer test
	
	@Test
	public void testViewManufacturer() {
	    List<Manufacturer> products = (List<Manufacturer>) manufacturerRepo.findAll();
	    assertThat(products).size().isGreaterThan(0);
	}
	
	// Delete manufacturer test
	
	@Test
	public void testDeleteManufacturer() {
		Manufacturer manufacturer = manufacturerRepo.findByManufacturerId(10006);
	     
		manufacturerRepo.deleteById(manufacturer.getManufacturerId());
	     
	    Manufacturer deletedManufacturer = manufacturerRepo.findByManufacturerId(10006);
	     
	    assertThat(deletedManufacturer).isNull();    
	}
	
	// Update manufacturer test
	
	@Test
	public void testUpdateProduct() {
		Manufacturer manufacturer = manufacturerRepo.findByManufacturerId(10006);
		manufacturer.setMfgLicence("gfp5913305");
	     
	    manufacturerRepo.save(manufacturer);
	     
	    Manufacturer updatedManufacturer = manufacturerRepo.findByManufacturerId(10006);
	     
	    assertThat(updatedManufacturer.getMfgLicence()).isEqualTo("gfp5913305");
	}
}
