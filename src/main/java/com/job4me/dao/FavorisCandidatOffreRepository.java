package com.job4me.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.FavorisCandidatOffre;
import com.job4me.entities.FavorisCandidatOffre.Id;

public interface FavorisCandidatOffreRepository extends JpaRepository <FavorisCandidatOffre,Id> {
	
	@Query("select f from FavorisCandidatOffre f where f.id.idCandidat like :x")
	 public List<FavorisCandidatOffre> favorisCandidat(@Param("x")int mc);
	
	

}
