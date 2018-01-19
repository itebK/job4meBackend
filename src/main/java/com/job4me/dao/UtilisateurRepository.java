package com.job4me.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.job4me.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository <Utilisateur,Integer>{
	
	@Query("select u from Utilisateur u where u.email like :x  and u.password like :y ")
	 public Utilisateur authentification(@Param("x")String email , @Param("y")String password);
	
}
