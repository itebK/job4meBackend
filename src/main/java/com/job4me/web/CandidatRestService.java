package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.CandidatRepository;
import com.job4me.entities.Candidat;

@RestController
@CrossOrigin("*")
public class CandidatRestService {
	@Autowired
	private CandidatRepository candidatRepository;
	
	@RequestMapping(value="/candidat" , method=RequestMethod.GET)
	private List<Candidat> getCandidat(){
		return candidatRepository.findAll();
	}
	@RequestMapping(value="/candidat/{id}" , method=RequestMethod.GET)
	private Candidat getCandidat(@PathVariable int id){
		return candidatRepository.findOne(id);
	}
	/*@RequestMapping(value="/chercherCandidat" , method=RequestMethod.GET)
	private Page<Candidat> chercherCandidat(
			@RequestParam(name="mc", defaultValue =("")) String mc , 
			@RequestParam(name="page", defaultValue=("0"))int page,
			@RequestParam(name="size", defaultValue=("5"))int size){
		return candidatRepository.chercherCandidat("%"+mc+"%", new PageRequest(page, size));
	}*/
	@RequestMapping(value="/candidats" , method=RequestMethod.POST)
	private Candidat saveCandidat(@RequestBody Candidat c){
		return candidatRepository.save(c);
	}
	@RequestMapping(value="/candidats/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteCandidat(@PathVariable int id){
		 candidatRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/candidats/{id}" , method=RequestMethod.PUT)
	private Candidat updateCandidat(@PathVariable int id,@RequestBody Candidat c){
		c.setIdUtilisateur(id);
		return candidatRepository.save(c);
	}
}
