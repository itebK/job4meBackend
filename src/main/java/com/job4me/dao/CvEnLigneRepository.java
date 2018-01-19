package com.job4me.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.CvEnLigne;

public interface CvEnLigneRepository extends JpaRepository <CvEnLigne,Integer> {
	
	@Query("select cvl from CvEnLigne cvl where cvl.candidat.idUtilisateur like :x ")
	 public CvEnLigne getCvEnLigneCandidat(@Param("x")int mc);

}
