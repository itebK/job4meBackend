package com.job4me.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4me.entities.Certification;

public interface CertificationRepository extends JpaRepository <Certification,Integer> {
	
	@Query("select c from Certification c where c.cvEnLigne.idDocument like :x ")
	 public List<Certification> getlisteCertificationCandidat(@Param("x")int mc);

}
