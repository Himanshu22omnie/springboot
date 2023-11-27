package com.map.enitites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String className;


	@ManyToMany(mappedBy = "classes",fetch = FetchType.LAZY)
	private Set<Teacher> teachers = new HashSet<>();
	
} 