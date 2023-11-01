package com.config.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.config.dao.EmployeeRepo;
import com.config.entities.Employee;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	//loadUserByUsername ke use se Ham check krenge ki wo user database m available hai ya nahi
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Employee employee = employeeRepo.findByEmail(email);
		if (employee==null) {
			throw new UsernameNotFoundException("user name not found");
		}
		else {
			return new CustomUser(employee); //If Id exist then return the CustomUser object with employee details.
		}
		
	}

}