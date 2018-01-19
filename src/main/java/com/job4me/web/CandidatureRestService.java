package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.CandidatureRepository;
import com.job4me.entities.Candidature;
import com.job4me.entities.Postuler;

@RestController
@CrossOrigin("*")
public class CandidatureRestService {

	@Autowired
	private CandidatureRepository candidatureRepository;
	
	@RequestMapping(value="/candidature" , method=RequestMethod.GET)
	private List<Candidature> getCandidature(){
		return candidatureRepository.findAll();
	}
	@RequestMapping(value="/candidature/{id}" , method=RequestMethod.GET)
	private Candidature getCandidature(@PathVariable int id){
		return candidatureRepository.findOne(id);
	}
	@RequestMapping(value="/candidatureEntreprise/{id}" , method=RequestMethod.GET)
	private List<Postuler> getCandidatureByEntreprise(@PathVariable int id){
		return candidatureRepository.getCandidatureByEntreprise(id);
	}
	
	@RequestMapping(value="/candidatureArchiverEntreprise/{id}" , method=RequestMethod.GET)
	private List<Postuler> getcandidatureArchiverEntreprise(@PathVariable int id){
		return candidatureRepository.getcandidatureArchiverEntreprise(id);
	}
	
	@RequestMapping(value="/candidatures" , method=RequestMethod.POST)
	private Candidature saveCandidature(@RequestBody Candidature c){
		return candidatureRepository.save(c);
	}
	@RequestMapping(value="/candidatures/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteCandidature(@PathVariable int id){
		 candidatureRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/candidatures/{id}" , method=RequestMethod.PUT)
	private Candidature updateCandidature(@PathVariable int id,@RequestBody Candidature c){
		c.setIdCandidature(id);
		return candidatureRepository.save(c);
	}


}
