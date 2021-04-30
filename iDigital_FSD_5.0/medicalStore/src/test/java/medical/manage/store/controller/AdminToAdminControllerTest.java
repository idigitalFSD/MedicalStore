package medical.manage.store.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import medical.manage.store.model.AdminToAdmin;




@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminToAdminControllerTest {
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// View all Admin Test
	
	@Test
	public void getAllAdminDetailsTest() throws Exception {
		MvcResult result  = mockMvc.perform(get("/adminDetails").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
				
	}
	
	
	

	   
	    // Delete Admin Test
	
	@Test
	public void deleteAdminByadminIdTest() throws Exception{
		MvcResult result = mockMvc.perform(delete("/adminDetails/deleteadmin/14").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	
	// Get Admin Details by ID Test
	
	@Test 
	public void getAdminDetailsByIdTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/adminDetails/24").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	
	
}


























