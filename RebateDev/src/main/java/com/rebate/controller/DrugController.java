package com.rebate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rebate.entities.Drug;
import com.rebate.service.DrugService;
import com.rebate.service.impl.DrugServiceImpl;

@RestController
@RequestMapping("drug")
public class DrugController {
	
	@Autowired
	private DrugServiceImpl drugServiceImpl;
	
	@PostMapping("/addDrug")
	public String saveDrug(@RequestBody Drug drug) {
		Drug addDrug = drugServiceImpl.addDrug(drug);
		return "Data Saved";
//		
	}
	
	@GetMapping("/{name}")
	public Drug findDrugByDrugName(@PathVariable String name) {
		Drug findByName = drugServiceImpl.findByName(name);
		return findByName;
	}
	
	@PutMapping("/Update/{id}")
	public ResponseEntity<?> updateDruhById(@PathVariable("id") Long id,@RequestBody Drug drug){
		Drug updateStu = drugServiceImpl.updateDrug(id, drug);
		return ResponseEntity.ok("Your data is updated of Id :" +updateStu.getId());
	}
	
	@DeleteMapping("/{id}")
	public String deleteDrug(@PathVariable("id") Long id, Drug drug) {
		drugServiceImpl.delete(id, drug);
		return "Data is Successfully Remove at "+drug.getId();
	}

}