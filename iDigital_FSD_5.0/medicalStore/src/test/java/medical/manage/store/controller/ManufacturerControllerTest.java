package medical.manage.store.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import medical.manage.store.model.Manufacturer;
import medical.manage.store.service.ManufacturerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManufacturerControllerTest {
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private ManufacturerService service;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// View all Manufacturers Test
	
	  @Test public void viewAllManufacturerTest() throws Exception { MvcResult
	  result =
	  mockMvc.perform(get("/view_all_manufacturers").content(MediaType
	  .APPLICATION_JSON_VALUE)) .andExpect(status().isOk()).andReturn();
	  assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	  
	  }
	 
	 
	/*
	 * @Test public void viewAllManufacturerTest() throws Exception {
	 * List<Manufacturer> manu = new ArrayList<>(); Manufacturer manufacturer = new
	 * Manufacturer(); manufacturer.setManufacturerId(100011);
	 * manufacturer.setManufacturerName("Aditya Medical Corporation");
	 * manufacturer.setMfgLicence("thr3722910");
	 * manufacturer.setAddress("A-31C Industrial Colony, Pune");
	 * manu.add(manufacturer);
	 * Mockito.when(service.viewAllManufacturer()).thenReturn(manu); MvcResult
	 * result =
	 * mockMvc.perform(get("/view_all_manufacturers")).andExpect(status().isOk()).
	 * andReturn(); assertEquals(HttpStatus.OK.value(),
	 * result.getResponse().getStatus()); //andExpect(jsonPath("$",
	 * Matchers.hasSize(1))) // .andExpect(jsonPath("$[0].name",
	 * Matchers.equalTo("Aditya Medical Corporation")));
	 * 
	 * }
	 */
	
	// Add Manufacturer Test
	
	  @Test public void addManufacturerTest() throws Exception { Manufacturer
	  manufacturer = new Manufacturer();
	  manufacturer.setManufacturerName("Aditya Medical Corporation");
	  manufacturer.setMfgLicence("abc5892510");
	  manufacturer.setAddress("A-31C Industrial Colony, Pune");
	  
	  String jsonRequest = om.writeValueAsString(manufacturer);
	  
	  MvcResult result =
	  mockMvc.perform(post("/add_manufacturer").content(jsonRequest)
	  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
	  andExpect(status().isOk()) .andReturn(); assertEquals(HttpStatus.OK.value(),
	  result.getResponse().getStatus()); }
	 
	 
	
	// Delete Manufacturer Test
	
	@Test
	public void deleteManufacturerTest() throws Exception{
		MvcResult result = mockMvc.perform(delete("/delete_manufacturer/10006").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	
	// Get Manufacturer by ID Test
	
	@Test 
	public void GetManufacturerByIdTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/get_manufacturer_by_id/10006").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	
	// Update Manufacturer Test
	
	@Test
	public void updateManufacturerTest() throws Exception {
		Manufacturer manufacturer = new Manufacturer();
		int id= 10004;
		manufacturer.setMfgLicence("xyz6492201");
		String jsonRequest = om.writeValueAsString(id);
		MvcResult result = mockMvc.perform(put("/update_Manufacturer/10006").content(jsonRequest)
				.content(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

}
