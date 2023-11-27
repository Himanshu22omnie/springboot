package com.map.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.map.enitites.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long>{
	
	List<Teacher> findAll();

}
