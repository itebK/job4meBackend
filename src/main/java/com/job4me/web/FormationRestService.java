package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.FormationRepository;
import com.job4me.entities.Experience;
import com.job4me.entities.Formation;

@RestController
@CrossOrigin("*")
public class FormationRestService {

	@Autowired
	private FormationRepository formationRepository;
	
	@RequestMapping(value="/formation" , method=RequestMethod.GET)
	private List<Formation> getFormation(){
		return formationRepository.findAll();
	}
	@RequestMapping(value="/formation/{id}" , method=RequestMethod.GET)
	private Formation getFormation(@PathVariable int id){
		return formationRepository.findOne(id);
	}

	@RequestMapping(value="/formation" , method=RequestMethod.POST)
	private Formation saveFormation(@RequestBody Formation o){
		return formationRepository.save(o);
	}
	@RequestMapping(value="/formations/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteFormation(@PathVariable int id){
		 formationRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/formations/{id}" , method=RequestMethod.PUT)
	private Formation updateFormation(@PathVariable int id,@RequestBody Formation f){
		f.setIdFormation(id);
		return formationRepository.save(f);
	}
	
	@RequestMapping(value="/listeformations/{id}" , method=RequestMethod.GET)
	private List<Formation> listeExperienceCandidat(@PathVariable int id){
		return formationRepository.getlisteFormationCandidat(id);
	}


}
