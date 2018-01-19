package com.job4me.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository <Entreprise,Integer>{
	
	@Query("from Entreprise ORDER BY RAND()")
	 public List<Entreprise> randomEntreprise();

}



