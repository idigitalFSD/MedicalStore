package medical.manage.store.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import medical.manage.store.model.AdminToAdmin;
import medical.manage.store.repository.AdminToAdminRepository;
import medical.manage.store.service.AdminToAdminService;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;

@AutoConfigureRestDocs
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AdminToAdminControllerTest {
	
	 @InjectMocks
	   AdminToAdminService adminToAdminService;
	     
	    @Mock
	    AdminToAdminRepository repository;
	    
	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void createNewAdminTest()
	    {
	        AdminToAdmin admin = new AdminToAdmin(1L,"kavya jain","23","12/09/2020","Kavya@C12","9876948822");
	         
	        adminToAdminService.createNewAdmin(admin);
	         
	        //verify(adminToAdminService, times(1)).createNewAdmin(admin);
	    }
	}
	    
	    
	    
		/*private MockMvc mockMvc;
		@Autowired
		private WebApplicationContext context;
  
		ObjectMapper om = new ObjectMapper();

		@Before
		public void setup() {
			mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		}


	

	//@MockBean
	//private AdminToAdminService adminService;
	

	/*@Test
	public void TestgetAllAdminDetails() throws Exception {
		
		AdminToAdmin e1=new AdminToAdmin(1L,"Mahima","23","12/01/2020","Mahima@129","9892276541");
	
		List<AdminToAdmin> adminList=Arrays.asList(e1);
		when(adminService.getAllAdminDetails()).thenReturn(adminList);
		
		String URI="/adminDetails";
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON); 
	
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson=this.mapToJson(adminList);
		String outputInJson=result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedJson);
		
	}*/

	/*private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}*/
		
	/*private static void printJSON(Object object) {
        String result;
        try {
            result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }*/
	/*@Test
	public void createNewAdminTest() throws Exception {
		AdminToAdmin newAdmin = new AdminToAdmin();
		newAdmin.setAdminName("kavya");
		newAdmin.setAdminAge("20");
		newAdmin.setAdminJoiningDate("12/09/2020");
		newAdmin.setAdminPassword("kavya@C12");
		
		newAdmin.setAdminPhoneNum("8985089718");

		String jsonRequest = om.writeValueAsString(newAdmin);

		MvcResult result = mockMvc.perform(post("/adminDetails/registration").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	*/




