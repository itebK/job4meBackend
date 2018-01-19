package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.LettreMotivatonEnLigneRepository;
import com.job4me.entities.LettreMotivatonEnLigne;

@RestController
@CrossOrigin("*")
public class LettreMotivatonEnLigneRestService {

	@Autowired
	private LettreMotivatonEnLigneRepository lettremotivatonenligneRepository;
	
	@RequestMapping(value="/lettremotivatonenligne" , method=RequestMethod.GET)
	private List<LettreMotivatonEnLigne> getLettreMotivatonEnLigne(){
		return lettremotivatonenligneRepository.findAll();
	}
	@RequestMapping(value="/lettremotivatonenligne/{id}" , method=RequestMethod.GET)
	private LettreMotivatonEnLigne getLettreMotivatonEnLigne(@PathVariable int id){
		return lettremotivatonenligneRepository.findOne(id);
	}

	@RequestMapping(value="/lettremotivatonenligne" , method=RequestMethod.POST)
	private LettreMotivatonEnLigne saveLettreMotivatonEnLigne(@RequestBody LettreMotivatonEnLigne o){
		return lettremotivatonenligneRepository.save(o);
	}
	@RequestMapping(value="/lettremotivatonenlignes/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteLettreMotivatonEnLigne(@PathVariable int id){
		 lettremotivatonenligneRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/lettremotivatonenlignes/{id}" , method=RequestMethod.PUT)
	private LettreMotivatonEnLigne updateLettreMotivatonEnLigne(@PathVariable int id,@RequestBody LettreMotivatonEnLigne o){
		o.setIdDocument(id);
		return lettremotivatonenligneRepository.save(o);
	}


}
