package com.job4me.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.Competence;
import com.job4me.entities.Offre;
import com.job4me.entities.Postuler;

public interface OffreRepository extends JpaRepository <Offre,Integer>{
	
	@Query("select o from Offre o where o.titre like :x ")
	 public List<Offre> chercherOffre (@Param("x")String mc);
	
	@Query("select o from Offre o where o.entreprise.idUtilisateur like :id ")
	 public List<Offre> getOffreEntreprise (@Param("id")int id);
	
	@Query("select distinct o.titre from Offre o ")
	 public List<String> getTitresoffres ();
	
	@Query("select distinct o from Offre o where o.salaire < :y and o.typeContrat.libelle in (:x) ")
	 public List<Offre> filtresoffres (@Param("y")int salaire , @Param("x")List<String> mc );
	
	@Query("select distinct o from Offre o where o.salaire < :y ")
	 public List<Offre> filtreSalaire (@Param("y")int salaire );
	
	
	
}
