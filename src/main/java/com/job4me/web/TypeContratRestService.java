package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.job4me.dao.TypeContratRepository;
import com.job4me.entities.TypeContrat;

@RestController
@CrossOrigin("*")
public class TypeContratRestService {

	@Autowired
	private TypeContratRepository typeContratRepository;
	
	@RequestMapping(value="/typeContrat" , method=RequestMethod.GET)
	private List<TypeContrat> getTypeContrat(){
		return typeContratRepository.findAll();
	}
	@RequestMapping(value="/typeContrat/{id}" , method=RequestMethod.GET)
	private TypeContrat getTypeContrat(@PathVariable int id){
		return typeContratRepository.findOne(id);
	}

	@RequestMapping(value="/typeContrat" , method=RequestMethod.POST)
	private TypeContrat saveTypeContrat(@RequestBody TypeContrat tc){
		return typeContratRepository.save(tc);
	}
	@RequestMapping(value="/typeContrats/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteTypeContrat(@PathVariable int id){
		 typeContratRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/typeContrats/{id}" , method=RequestMethod.PUT)
	private TypeContrat updateTypeContrat(@PathVariable int id,@RequestBody TypeContrat tc){
		tc.setIdTypeContrat(id);
		return typeContratRepository.save(tc);
	}
}
