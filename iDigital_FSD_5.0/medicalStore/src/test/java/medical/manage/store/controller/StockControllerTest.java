package medical.manage.store.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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

import medical.manage.store.model.Manufacturer;
import medical.manage.store.model.MedicinePurchased;
import medical.manage.store.model.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

//	@Test
//	public void addStockTest() throws Exception {
//		Stock stock = new Stock();
//		stock.setStockId(1);
//		stock.setCostEach(2.5);
//		stock.setInStock(3);
//		stock.setSold(1);
//	
//		List<Manufacturer> manufacturerList=new ArrayList<Manufacturer>();
//		manufacturerList.add(new Manufacturer("Cipla","abcd","Malad west"));
//		stock.setManufacturer(manufacturerList);
//		
//		List<MedicinePurchased> medicineList=new ArrayList<MedicinePurchased>();
//		medicineList.add(new MedicinePurchased("Paracetamol"));
//		stock.setMedicine(medicineList);
//		
//		
//
//		String jsonRequest = om.writeValueAsString(stock);
//
//		MvcResult result = mockMvc.perform(post("/api/v1/medicalstore/stocks/add").content(jsonRequest)
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andReturn();
//		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
//	}
//	
	
	@Test
	public void getStockTest() throws Exception {
		MvcResult result  = mockMvc.perform(get("/api/v1/medicalstore/stocks").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
				
	}
}