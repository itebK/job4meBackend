package com.job4me.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.PieceJointe;


public interface PieceJointeRepository extends JpaRepository <PieceJointe,Integer> {
	@Query("select p from PieceJointe p  where p.candidat.idUtilisateur like :x and p.type='CV'")
	 public List<PieceJointe> getListeCvCandidat(@Param("x")int mc);
	
	@Query("select p from PieceJointe p  where p.candidat.idUtilisateur like :x and p.type='LettreMotivation'")
	 public List<PieceJointe> getListeLettreMotivation(@Param("x")int mc);


}
