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
import com.job4me.entities.Entreprise;

@RestController
@CrossOrigin("*")
public class EntrepriseRestService {

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@RequestMapping(value="/entreprise" , method=RequestMethod.GET)
	private List<Entreprise> getEntreprise(){
		return entrepriseRepository.findAll();
	}
	@RequestMapping(value="/entreprise/{id}" , method=RequestMethod.GET)
	private Entreprise getEntreprise(@PathVariable int id){
		return entrepriseRepository.findOne(id);
	}

	@RequestMapping(value="/entreprise" , method=RequestMethod.POST)
	private Entreprise saveEntreprise(@RequestBody Entreprise e){
		return entrepriseRepository.save(e);
	}
	@RequestMapping(value="/entreprises/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteEntreprise(@PathVariable int id){
		 entrepriseRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/entreprises/{id}" , method=RequestMethod.PUT)
	private Entreprise updateEntreprise(@PathVariable int id,@RequestBody Entreprise e){
		e.setIdUtilisateur(id);
		return entrepriseRepository.save(e);
	}
	
	@RequestMapping(value="/randomEntreprise" , method=RequestMethod.GET)
	private List<Entreprise> randomEntreprise(){
		return entrepriseRepository.randomEntreprise().subList(0, 3);
	}
}
