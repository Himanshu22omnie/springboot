package com.emp.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.service.EmpService;

import jakarta.validation.Valid;

@RestController
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@PostMapping("/save")
	public String saveEm(Employee e1) {
		return empService.saveEmp(e1);
	}
	
	@GetMapping("/fetch")
	public Employee saveEmp(Employee e) {
		e.setId(6l);
		e.setName("Praveen");
		e.setAddress("Noida");
		e.setMob("9795296423");

		return e;
	}
	
	@GetMapping("/fetchAll")
	public List<Employee> getAllEmp() {
		return empService.fetchAllData();
	}
	
	@GetMapping("/fetchUsingId/{id}")
	public Employee findById(@PathVariable("id")Long id) {
		return empService.fetchUsingId(id);
	}
	
	@PutMapping("/Update/{id}")
	public Employee updateEmp(@PathVariable Long id,@Valid @RequestBody Employee em) {
		em.setId(id);
		return empService.updateEmployee(em);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBYId(@Valid @PathVariable Long id) {
		empService.deleteData(id);
		System.out.println("Data Deleted");
	}
	
	
}