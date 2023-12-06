package com.rebate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebate.entities.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long>{
		
	public Drug findByName(String name);
}
