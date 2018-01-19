package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.EntrepriseRepository;
import com.job4me.dao.PosteRepository;
import com.job4me.entities.Entreprise;
import com.job4me.entities.Poste;

@RestController
@CrossOrigin("*")
public class PosteRestService {
	@Autowired
	private PosteRepository posteRepository;
	
	@RequestMapping(value="/poste" , method=RequestMethod.GET)
	private List<Poste> getPoste(){
		return posteRepository.findAll();
	}
	@RequestMapping(value="/poste/{id}" , method=RequestMethod.GET)
	private Poste getPoste(@PathVariable int id){
		return posteRepository.findOne(id);
	}

	@RequestMapping(value="/poste" , method=RequestMethod.POST)
	private Poste savePoste(@RequestBody Poste p){
		return posteRepository.save(p);
	}
	@RequestMapping(value="/postes/{id}" , method=RequestMethod.DELETE)
	private Boolean deletePoste(@PathVariable int id){
		 posteRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/postes/{id}" , method=RequestMethod.PUT)
	private Poste updatePoste(@PathVariable int id,@RequestBody Poste p){
		p.setIdPoste(id);
		return posteRepository.save(p);
	}
}

