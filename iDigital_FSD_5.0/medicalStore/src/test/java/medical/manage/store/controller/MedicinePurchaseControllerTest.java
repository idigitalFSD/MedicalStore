package medical.manage.store.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import medical.manage.store.model.MedicinePurchased;
import medical.manage.store.service.MedicinePurchasedService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicinePurchaseControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	MedicinePurchasedService medicineService;
	
	String jsonInput;
	
	MedicinePurchased medicine = new MedicinePurchased();
	
	@BeforeEach
	void setUp() throws JsonProcessingException {

		medicine.setMedicineName("Metformin");

		jsonInput = this.convertToJson(medicine);
	}

	@Test
	void testAddUser() throws Exception {
		String URI = "/users/add";

		Mockito.when(medicineService.addMedicine(Mockito.any(MedicinePurchased.class))).thenReturn(medicine);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	void testRemoveUserById() throws Exception{
			String URI = "/users/deletebyid/{userId}";

			Mockito.when(medicineService.addMedicine(Mockito.any(MedicinePurchased.class))).thenReturn(medicine);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
			MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
			
	}
	
	@Test
	void testModifyUser() throws Exception{
		String URI = "/users/modify";

		Mockito.when(medicineService.modifyMedicine(Mockito.any(MedicinePurchased.class))).thenReturn(medicine);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	
	private String convertToJson(MedicinePurchased medicine) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(medicine);
	}
	
	
//	@Test
//	public void getMedicinesTest() throws Exception {
//		MvcResult result  = mockMvc.perform(get("/api/medicine/").content(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isOk()).andReturn();
//		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
//				
//	}
//	
//	
//	@Test 
//	public void getMedicineByIdTest() throws Exception {
//		MvcResult result = mockMvc.perform(get("/api/medicine/medicineById/1").content(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isOk()).andReturn();
//		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
//	}
	
}
