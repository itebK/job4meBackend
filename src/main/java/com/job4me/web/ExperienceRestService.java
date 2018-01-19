package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.ExperienceRepository;
import com.job4me.entities.Experience;

@RestController
@CrossOrigin("*")
public class ExperienceRestService {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	@RequestMapping(value="/experience" , method=RequestMethod.GET)
	private List<Experience> getExperience(){
		return experienceRepository.findAll();
	}
	@RequestMapping(value="/experience/{id}" , method=RequestMethod.GET)
	private Experience getExperience(@PathVariable int id){
		return experienceRepository.findOne(id);
	}

	@RequestMapping(value="/experience" , method=RequestMethod.POST)
	private Experience saveExperience(@RequestBody Experience o){
		return experienceRepository.save(o);
	}
	@RequestMapping(value="/experiences/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteExperience(@PathVariable int id){
		 experienceRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/experiences/{id}" , method=RequestMethod.PUT)
	private Experience updateExperience(@PathVariable int id,@RequestBody Experience o){
		o.setIdExperience(id);
		return experienceRepository.save(o);
	}
	
	@RequestMapping(value="/listeexperiences/{id}" , method=RequestMethod.GET)
	private List<Experience> listeExperienceCandidat(@PathVariable int id){
		return experienceRepository.getlisteExperienceCandidat(id);
	}


}
