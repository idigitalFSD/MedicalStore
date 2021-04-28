package medical.manage.store.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import medical.manage.store.model.Registration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RegistrationRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUserData() throws Exception{
    	Registration data = getdata();
        Registration saveInDb = testEntityManager.persist(data);
       assertNotNull(saveInDb);
    } 
    private Registration getdata() {
    	Registration data = new Registration();
        data.setUserId("Nimitha25");
        data.setPassword("Nimitha@9");
        data.setEmailId("abcde@gmaill.com");
        data.setContactNo("8999999900");
        return data;
    }
}
