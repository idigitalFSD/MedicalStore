package medical.manage.store.controller;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import medical.manage.store.model.Registration;
import medical.manage.store.service.RegistrationService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RegistrationController.class)
//@WebMvcTest(value = RegistrationController.class,secure = false)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService Service;


    @Test
    public void testCreateUserData() throws Exception{
        String URI = "/userRegistration/createUserDetails";
        Registration User = new  Registration();
        User.setUserId("Nimitha25");
        User.setPassword("Nimitha@9");
        User.setEmailId("abcde@gmaill.com");
        User.setContactNo("8999999900");
        String jsonInput = this.converttoJson(User);

        Mockito.when(Service.createdata(Mockito.any(Registration.class))).thenReturn(User);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
       // Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }
   
    /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param ticket
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object User) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(User);
    }

}

