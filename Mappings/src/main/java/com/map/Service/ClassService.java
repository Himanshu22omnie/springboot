package com.map.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.Repository.ClasssRepo;
import com.map.Repository.TeacherRepo;
import com.map.enitites.Classs;
import com.map.enitites.Teacher;


@Service
public class ClassService {

	@Autowired
	private ClasssRepo classsRepo;
	
	public List<Classs> findAllClassses() {
		return classsRepo.findAll();
	}
	
	public Classs saveClasss(Classs t) {
		return classsRepo.save(t);
	}
	
}
