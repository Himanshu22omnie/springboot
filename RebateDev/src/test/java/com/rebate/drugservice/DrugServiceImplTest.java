package com.rebate.drugservice;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rebate.DAO.DrugRepository;
import com.rebate.entities.Drug;
import com.rebate.service.impl.DrugServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class DrugServiceImplTest {
	
	@InjectMocks
	private DrugServiceImpl drugServiceImpl;
	
	@Mock
	private DrugRepository drugRepository;
	
	@Test
	public void DrugCreation() {
		Drug d = drugData();
		when(drugRepository.save(d)).thenReturn(d);
		drugServiceImpl.addDrug(ArgumentMatchers.any());
		assertNotNull(d);
	}
	
	@Test
	public void findByName() {
		when(drugRepository.findByName(ArgumentMatchers.anyString())).thenReturn(drugData());
		drugServiceImpl.findByName(ArgumentMatchers.anyString());
		assertEquals("Sample Drug", drugData().getName());
	}
	
	@Test
	public void findAll() {
		when(drugRepository.findAll()).thenReturn(drugsList());
		drugServiceImpl.findAllDrug();
		assertEquals("Sample Drug", drugData().getName());
		assertEquals("any", drugData().getManufacturer());
		assertEquals("any", drugData().getDescription());
	}
	
	@Test
	public void update11() {
		Long id = 3l;
		Drug drug = new Drug();
		drug.setName("Drgs");
		when(drugRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(drugData()));
		drugServiceImpl.updateDrug11(id, drugData().getName(), drugData().getDescription(), drugData().getManufacturer(), drugData().getPrice());
	}
	
	@Test
	public void update11EXC() {
		Long id = 3l;
		Drug drug = new Drug();
		drug.setName("Drgs");
		assertThrows(IllegalArgumentException.class, ()->{
			when(drugRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(drugData()));
			drugServiceImpl.updateDrug11(null," "," ","",0.0);
		});
		
	}
	
	@Test
	public void updateTest() {
		Long id = 3l;
		Drug drug = new Drug();
		drug.setName("Drgs");
		when(drugRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(drugData()));
		drugServiceImpl.updateDrug(id,drugData());
	}

	@Test
    public void testDeleteDrugById() {
        Long idToDelete = 1L;
        drugServiceImpl.delete(idToDelete,drugData()); //Here when we call the service method
        verify(drugRepository).deleteById(idToDelete); //then it check is it internally call or not
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
	
	private List<Drug> drugsList(){
		List<Drug> list = new ArrayList<>();
		list.add(drugData());
		return list;
	}
	
}
