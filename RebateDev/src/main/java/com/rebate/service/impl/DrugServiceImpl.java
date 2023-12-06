package com.rebate.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebate.DAO.DrugRepository;
import com.rebate.entities.Drug;
import com.rebate.service.DrugService;

@Service
public class DrugServiceImpl implements DrugService{
	
	@Autowired
	private DrugRepository drugRepository;

	@Override
	public Drug addDrug(Drug drug) {
		Drug saveDrug = drugRepository.save(drug);  
		return saveDrug;
	}
	@Override
	public Drug findByName(String name) {
		Drug findByDrugName = drugRepository.findByName(name);
		return findByDrugName;
	}
	@Override
	public List<Drug> findAllDrug(){
		List<Drug> findAllDrug = drugRepository.findAll();
		return findAllDrug;
	}

	//This is unncessary method 
	public Drug updateDrug11(Long id, String name, String description, String manufacturer, double price) {
		Optional<Drug> optionalDrug = drugRepository.findById(id);
		if (optionalDrug.isPresent()) {
			Drug existingDrug = optionalDrug.get();
			
			if (name!=null) {
				existingDrug.setName(name);
			}
			if (description != null) {
				existingDrug.setDescription(description);
			}
			if (manufacturer != null) {
				existingDrug.setManufacturer(manufacturer);
			}
			if (price != 0.0) {
				existingDrug.setPrice(price);
			}
			
			return drugRepository.save(existingDrug);
		}
		else {
			throw new IllegalArgumentException("Drug with ID "+id+ "not found");
		}
	}
	
	@Override
	public Drug updateDrug(Long id, Drug sc) {
		 Optional<Drug> findIdOptional = drugRepository.findById(id);
		 sc.setId(id);
		 Drug student = null;
		 if (findIdOptional != null) {
			 student = drugRepository.save(sc);
		}
		 return student;
	 }
	
	@Override
	public void delete(Long id, Drug drug) {
		drugRepository.deleteById(id);
	}
}
