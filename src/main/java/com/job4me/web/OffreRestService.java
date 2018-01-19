package com.job4me.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.job4me.dao.CompetenceRepository;
import com.job4me.dao.OffreRepository;
import com.job4me.entities.Competence;
import com.job4me.entities.Offre;


@RestController
@CrossOrigin("*")
public class OffreRestService {

	@Autowired
	private OffreRepository offreRepository;
	private CompetenceRepository competenceRepository ;
	
	@RequestMapping(value="/offre" , method=RequestMethod.GET)
	private List<Offre> getOffre(){
		return offreRepository.findAll();
	}
	@RequestMapping(value="/offre/{id}" , method=RequestMethod.GET)
	private Offre getOffre(@PathVariable int id){
		return offreRepository.findOne(id);
	}
	
	@RequestMapping(value="/offreEntreprise/{id}" , method=RequestMethod.GET)
	private List<Offre> getOffreEntreprise(@PathVariable int id){
		return offreRepository.getOffreEntreprise(id) ;
	}
	
	@RequestMapping(value="/titresoffres" , method=RequestMethod.GET)
	private List<String> getTitreOffre(){
		return offreRepository.getTitresoffres();
	}

	@RequestMapping(value="/offre" , method=RequestMethod.POST)
	private Offre saveOffre(@RequestBody Offre o){
		return offreRepository.save(o);
	}
	
	@RequestMapping(value="/filtreoffre/{salaire}/{mc}" , method=RequestMethod.GET)
	private List<Offre> filtreOffre(@PathVariable int salaire , @PathVariable List<String> mc){
		return offreRepository.filtresoffres(salaire , mc );
	}
	
	@RequestMapping(value="/filtreoffre/{salaire}" , method=RequestMethod.GET)
	private List<Offre> filtreSalaire(@PathVariable int salaire ){
		return offreRepository.filtreSalaire(salaire );
	}
	
	@RequestMapping(value="/offres/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteOffre(@PathVariable int id){
		 offreRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/offres/{id}" , method=RequestMethod.PUT)
	private Offre updateOffre(@PathVariable int id,@RequestBody Offre o){
		o.setIdOffre(id);
		return offreRepository.save(o);
	}
	
	
	@RequestMapping(value="/chercherOffres" , method=RequestMethod.GET)
	private List<Offre> chercherOffre(@RequestParam(name="mc", defaultValue =("")) String mc ) {
		return offreRepository.chercherOffre("%"+mc+"%");
	}
}
