package com.rebate.service;

import java.util.List;

import com.rebate.entities.Drug;

public interface DrugService {
	
	public Drug addDrug(Drug drug);
	public Drug findByName(String name);
	public List<Drug> findAllDrug();
	public Drug updateDrug(Long id, Drug drug);
	public void delete(Long id, Drug drug);
	
}
