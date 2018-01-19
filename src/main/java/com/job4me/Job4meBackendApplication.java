package com.job4me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.job4me.dao.CandidatRepository;
import com.job4me.dao.EntrepriseRepository;
import com.job4me.dao.FavorisCandidatOffreRepository;
import com.job4me.dao.OffreRepository;
import com.job4me.dao.PosteRepository;
import com.job4me.dao.PostulerRepository;
import com.job4me.dao.TypeContratRepository;

@SpringBootApplication
public class Job4meBackendApplication implements CommandLineRunner {
	@Autowired
	private CandidatRepository candidatRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TypeContratRepository typeContratRepository;
	@Autowired
	private PosteRepository posteRepository;
	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	private FavorisCandidatOffreRepository favoriscandidatoffre;
	@Autowired
	private PostulerRepository postuler;

	public static void main(String[] args) {
		SpringApplication.run(Job4meBackendApplication.class, args);
	}

	// public List<String> mc ;
	@Override
	public void run(String... arg0) throws Exception {

	}

}
