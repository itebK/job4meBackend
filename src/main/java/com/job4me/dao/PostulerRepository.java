package com.job4me.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.Candidat;
import com.job4me.entities.Postuler;
import com.job4me.entities.Postuler.Id;

public interface PostulerRepository extends JpaRepository <Postuler,Id> {
	
	@Query("select c from Postuler c where c.document.candidat.idUtilisateur like :x and c.vue = 1 ")
	 public List<Postuler> getCandidaturesVue(@Param("x")int mc);
	
	@Query("select c from Postuler c where c.document.candidat.idUtilisateur like :x and c.vue = 0 ")
	 public List<Postuler> getCandidaturesNonVue(@Param("x")int mc);
	
	@Query("select c from Postuler c where c.document.candidat.idUtilisateur like :x ")
	 public List<Postuler> getCandidaturesCandidat(@Param("x")int mc);
	
	@Query("select p.document.candidat from Postuler p where p.document.candidat.idUtilisateur like :x and p.candidature.offre.idOffre like :y")
	 public Candidat VerifCandidatOffre(@Param("x")int x , @Param("y")int y);

}
