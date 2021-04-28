package medical.manage.store.service;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import medical.manage.store.model.Registration;
import medical.manage.store.repository.RegistrationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationServiceTest {

    @MockBean
    private RegistrationRepository RegistrationJpaRepository;

    @Autowired
    private RegistrationService RegistrationService;

    @Test
    public void testCreateUserData(){
    	 Registration data = new  Registration();
         data.setUserId("Nimitha25");
         data.setPassword("Nimitha@9");
         data.setEmailId("abcde@gmail.com");
         data.setContactNo("8999999900");
        Mockito.when(RegistrationJpaRepository.save(data)).thenReturn(data);
        assertThat(RegistrationService.createdata(data)).isEqualTo(data);
    } 
}

