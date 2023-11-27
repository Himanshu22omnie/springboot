package com.map.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.map.Service.ClassService;
import com.map.Service.TeacherService;
import com.map.enitites.Classs;


@RestController
public class ClassContrtoller {
	@Autowired
	private ClassService classService;
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/findAllClass")
	public ResponseEntity<List<Classs>> getAll(){
		List<Classs> classses = classService.findAllClassses();
		return ResponseEntity.ok(classses);
	}
	
	@PostMapping("/saveClass")
	public String saveClass(@RequestBody Classs t1) {
		classService.saveClasss(t1);
		return "Class Saved";
	}
	
	
	
}