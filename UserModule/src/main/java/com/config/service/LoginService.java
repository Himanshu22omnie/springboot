package com.config.service;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.config.dao.LoginRepository;
import com.config.entities.User;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public User login(String uName,String password) {
		User userDetails =  loginRepository.findByuserName(uName);

		if(userDetails==null) {
			throw new UsernameNotFoundException("Your UserName/Password is incorrect ");
		}
	
		return encoder.matches(password, userDetails.getPassword())?
		 userDetails: null;  // if [password matches the userDetails.getPAssword()] then return user's Details. Otherwise return null;
}
}