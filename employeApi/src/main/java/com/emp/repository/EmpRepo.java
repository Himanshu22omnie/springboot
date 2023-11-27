package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Employee;
import java.util.List;


public interface EmpRepo extends JpaRepository<Employee,Long> {
	
	Employee findById(long id);
}