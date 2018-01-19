package com.job4me.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.job4me.entities.Candidat;


public interface CandidatRepository extends JpaRepository <Candidat,Integer>{
	
}
