package com.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.dao.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
}
