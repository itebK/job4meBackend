package com.job4me.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.Candidature;
import com.job4me.entities.Postuler;


public interface CandidatureRepository extends JpaRepository <Candidature,Integer> {
	
	@Query("select p from Postuler p where p.candidature.offre.entreprise.idUtilisateur like :x and p.candidature.archive = '0'  ")
	 public List<Postuler> getCandidatureByEntreprise(@Param("x")int mc );
	
	
	
	@Query("select p from Postuler p  where p.candidature.offre.entreprise.idUtilisateur like :x and p.candidature.archive = '1' ")
	 public List<Postuler> getcandidatureArchiverEntreprise(@Param("x")int mc );

}
