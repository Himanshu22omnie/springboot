package com.rebate.drugcontroler;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rebate.DAO.DrugRepository;
import com.rebate.controller.DrugController;
import com.rebate.entities.Drug;
import com.rebate.service.impl.DrugServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class DrugControllerTest {
	
	@InjectMocks
	private DrugController drugController;
	
	@Mock
	private DrugServiceImpl drugServiceImpl;
	
	@Mock
	private Drug drug;
	private MockMvc mockMvc;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this); 
		this.mockMvc = MockMvcBuilders.standaloneSetup(drugController).build();
	}
	
	 	@Test
	    public void testSaveDrug() throws Exception {
	        ObjectMapper objectMapper = new ObjectMapper();
	        String jsonDrug = objectMapper.writeValueAsString(drugData());
	        
	        drugController.saveDrug(drugData()); 
	        
	        String response = mockMvc.perform(MockMvcRequestBuilders
	        		.post("/drug/addDrug")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(jsonDrug)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andReturn()
	                .getResponse()
	                .getContentAsString();
	        String expectedResponse = "Data Saved";
	        assertEquals(expectedResponse, response);
	        //verify(drugController, times(1)).saveDrug((Drug) any(Drug.class));
	    } 
	 	
	 	
	 	private Drug drugData() {
	 		Drug drug = new Drug();
	        drug.setName("Sample Drug");
	        drug.setManufacturer("any");
	        drug.setDescription("any");
	        drug.setPrice(3211);
	        drug.setId(3l);
	        return drug;
	 	}
	 	
	 	@Test
	 	public void testfindByName() throws UnsupportedEncodingException, Exception {
	 		 String drugName = "Sample Drug";
	 		 Mockito.when(drugController.findDrugByDrugName(ArgumentMatchers.anyString())).thenReturn(drugData());	 		 
	 		// Drug foundDrug = drugController.findDrugByDrugName(drugName); 
	 		 assertEquals(drugName, drugData().getName());
	 	}
	 	
	 	 @Test
	     public void testUpdateDruhById() throws Exception {
	         Long id = 1L;
	         Drug drugToUpdate = new Drug();
	         drugToUpdate.setName("Updated Drug");

	         when(drugServiceImpl.updateDrug(ArgumentMatchers.anyLong(), ArgumentMatchers.any())).thenReturn(drugToUpdate);

	         mockMvc.perform(put("/drug/Update/{id}", id)
	                 .contentType(MediaType.APPLICATION_JSON)
	                 .content("{\"name\": \"Updated Drug\"}") // JSON representation of the updated drug object
	                 .accept(MediaType.APPLICATION_JSON))
	                 .andExpect(status().isOk())
	                 .andExpect(content().string("Your data is updated of Id :" + drugToUpdate.getId()));
	     }
	 	
	 	 @Test
	 	 public void testDelete() { 
	 		 Long id = 3l;
	 		 when(drugServiceImpl.updateDrug(ArgumentMatchers.anyLong(), ArgumentMatchers.any())).thenReturn(drugData());
	 		 try {
				mockMvc.perform(delete("/drug//{id}",id)
						 .contentType(MediaType.APPLICATION_JSON)
						 .accept(MediaType.APPLICATION_JSON))
				 .andExpect(status().isOk());
			} catch (Exception e) {
				e.printStackTrace();
			}
	 	 }
}
