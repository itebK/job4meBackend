package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.CvEnLigneRepository;
import com.job4me.entities.CvEnLigne;

@RestController
@CrossOrigin("*")
public class CvEnLigneRestService {
	@Autowired
	private CvEnLigneRepository cvenligneRepository;
	
	@RequestMapping(value="/cvenligne" , method=RequestMethod.GET)
	private List<CvEnLigne> getCvEnLigne(){
		return cvenligneRepository.findAll();
	}
	@RequestMapping(value="/cvenligne/{id}" , method=RequestMethod.GET)
	private CvEnLigne getCvEnLigne(@PathVariable int id){
		return cvenligneRepository.findOne(id);
	}
	@RequestMapping(value="/cvenlignes" , method=RequestMethod.POST)
	private CvEnLigne saveCvEnLigne(@RequestBody CvEnLigne c){
		return cvenligneRepository.save(c);
	}
	@RequestMapping(value="/cvenlignes/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteCvEnLigne(@PathVariable int id){
		 cvenligneRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/cvenlignes/{id}" , method=RequestMethod.PUT)
	private CvEnLigne updateCvEnLigne(@PathVariable int id,@RequestBody CvEnLigne c){
		c.setIdDocument(id);
		return cvenligneRepository.save(c);
	}
	 /*---------Get CvEnLigne by Id Candidat------------------*/
	@RequestMapping(value="/cvenligne_candidat/{id}" , method=RequestMethod.GET)
	private CvEnLigne CvEnLigneCandidat(@PathVariable int id){
		return cvenligneRepository.getCvEnLigneCandidat(id);
	}


}
