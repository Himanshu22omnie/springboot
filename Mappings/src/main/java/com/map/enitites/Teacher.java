package com.map.enitites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tid;
	private String name;
	private String mob;
	private String address;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "Teacher_Class_Table", 
	joinColumns = {
			@JoinColumn(name = "teacher_id",referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "class_id", referencedColumnName = "id")
	}
	)
	private Set<Classs> classes = new HashSet<>(); 
}