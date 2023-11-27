package com.map.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.map.enitites.Classs;

public interface ClasssRepo extends JpaRepository<Classs, Long>{
	List<Classs> findAll();
}
