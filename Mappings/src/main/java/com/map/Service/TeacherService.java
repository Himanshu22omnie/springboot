package com.map.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.Repository.ClasssRepo;
import com.map.Repository.TeacherRepo;
import com.map.enitites.Classs;
import com.map.enitites.Teacher;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	@Autowired
	private ClasssRepo classsRepo;
	
	public List<Teacher> findAllTeacher() {
		return teacherRepo.findAll();
	}
	
	public Teacher savTeacher(Teacher t) {
		return teacherRepo.save(t);
	}

	public TeacherService(TeacherRepo teacherRepo, ClasssRepo classsRepo) {
		super();
		this.teacherRepo = teacherRepo;
		this.classsRepo = classsRepo;
	}

   
	
}
