package com.springbootpractice.dao;

import org.springframework.data.repository.CrudRepository;

import com.springbootpractice.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>  {
	
}
