package medical.manage.store.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.collection.IsEmptyCollection;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import medical.manage.store.model.AdminToAdmin;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
//@Rollback(false)
public class AdminToAdminRepositoryTest {

	@Autowired
	private AdminToAdminRepository repository;

	/*
	 * @Test
	 * 
	 * @Rollback(false) public void testCreateJobProvider() {
	 * JobProvidersRegistration savedDetails = repository.save(new
	 * JobProvidersRegistration("Biztech","Pune","Biztech@gmail.com","9111787811",
	 * "BiztechCompany","BIZ"));
	 * 
	 * assertThat(savedDetails.getJp_id()).isGreaterThan(0); }
	 */

	@Test
	public void testGetAllProducts() {
		List<AdminToAdmin> details = (List<AdminToAdmin>) repository.findAll();
		assertThat(details, hasSize(6));
		assertThat(details.size(), is(6));

	}

}
