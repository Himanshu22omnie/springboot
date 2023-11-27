package com.springbootpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springbootpractice.dao.UserRepository;
import com.springbootpractice.entities.User;

@SpringBootApplication
public class SpringbootpracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootpracticeApplication.class, args);
		
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("First");
		user.setCity("Delhi");
		user.setStatus("java programmmer");
		
		User user1 = userRepository.save(user);
		
		System.out.println(user1);
		
		
	}

}
