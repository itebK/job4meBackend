package com.job4me.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.Experience;
import com.job4me.entities.Postuler;


public interface ExperienceRepository extends JpaRepository <Experience,Integer> {
	
	@Query("select e from Experience e where e.cvEnLigne.idDocument like :x ")
	 public List<Experience> getlisteExperienceCandidat(@Param("x")int mc);
	
	

}
