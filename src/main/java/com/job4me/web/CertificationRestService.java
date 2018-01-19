package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.CertificationRepository;
import com.job4me.entities.Certification;


@RestController
@CrossOrigin("*")
public class CertificationRestService {
	@Autowired
	private CertificationRepository certificationRepository;
	
	@RequestMapping(value="/certification" , method=RequestMethod.GET)
	private List<Certification> getCertification(){
		return certificationRepository.findAll();
	}
	@RequestMapping(value="/certification/{id}" , method=RequestMethod.GET)
	private Certification getCertification(@PathVariable int id){
		return certificationRepository.findOne(id);
	}

	@RequestMapping(value="/certification" , method=RequestMethod.POST)
	private Certification saveCertification(@RequestBody Certification o){
		return certificationRepository.save(o);
	}
	@RequestMapping(value="/certifications/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteCertification(@PathVariable int id){
		 certificationRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/certifications/{id}" , method=RequestMethod.PUT)
	private Certification updateCertification(@PathVariable int id,@RequestBody Certification o){
		o.setIdCertification(id);
		return certificationRepository.save(o);
	}
	
	@RequestMapping(value="/listecertifications/{id}" , method=RequestMethod.GET)
	private List<Certification> listeExperienceCandidat(@PathVariable int id){
		return certificationRepository.getlisteCertificationCandidat(id);
	}
}
