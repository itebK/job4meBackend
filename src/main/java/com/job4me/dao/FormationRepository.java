package com.job4me.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.Experience;
import com.job4me.entities.Formation;

public interface FormationRepository extends JpaRepository <Formation,Integer> {
	@Query("select f from Formation f where f.cvEnLigne.idDocument like :x ")
	 public List<Formation> getlisteFormationCandidat(@Param("x")int mc);

}
