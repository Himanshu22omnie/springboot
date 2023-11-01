package com.config.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public Employee findByEmail(String email);
}