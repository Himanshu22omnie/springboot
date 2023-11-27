package com.map.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.map.Service.TeacherService;
import com.map.enitites.Teacher;

@RestController
public class TeacherControllers {
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Teacher>> getAll(){
		List<Teacher> teachers = teacherService.findAllTeacher();
		return ResponseEntity.ok(teachers);
	}
	
	@PostMapping("/save")
	public String saveTeacher(@RequestBody Teacher t1) {
		teacherService.savTeacher(t1);
		return "Teacher saved";
	}
	
//	@PutMapping("/{teacherid}/class/{id}")
//	public Teacher findRel(@PathVariable Long teacherid, @PathVariable Long id) {
//		return teacherService.assignCLaaToTeacher(teacherid,id);
//	}
	
}
