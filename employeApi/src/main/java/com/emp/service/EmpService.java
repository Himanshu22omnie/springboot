package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	EmpRepo empRepo;
	
	public String saveEmp(Employee e) {
		e.setName("Ritik");
		e.setAddress("Bomby");
		empRepo.save(e);
		return "Data Saved Successfully";
	}
	
	
	public List<Employee> fetchAllData() {
		return empRepo.findAll();
	}
	
	
	
	public Employee fetchUsingId(long id) {
		return empRepo.findById(id);
	}
	
	
//	public Optional<Employee> getEmpById(Long id) {
//		return empRepo.findById(id);
//	}
}
 