package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.UtilisateurRepository;
import com.job4me.entities.Utilisateur;

@RestController
@CrossOrigin("*")
public class UtilisateurRestService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@RequestMapping(value="/utilisateur" , method=RequestMethod.GET)
	private List<Utilisateur> getUtilisateur(){
		return utilisateurRepository.findAll();
	}
	
	@RequestMapping(value="/authentification/{email}/{password}" , method=RequestMethod.GET)
	private Utilisateur authentification(@PathVariable String email , @PathVariable String password){
		return utilisateurRepository.authentification(email , password);
	}
	
	
	@RequestMapping(value="/utilisateur/{id}" , method=RequestMethod.GET)
	private Utilisateur getUtilisateur(@PathVariable int id){
		return utilisateurRepository.findOne(id);
	}
	@RequestMapping(value="/utilisateurs" , method=RequestMethod.POST)
	private Utilisateur saveUtilisateur(@RequestBody Utilisateur c){
		return utilisateurRepository.save(c);
	}
	@RequestMapping(value="/utilisateurs/{id}" , method=RequestMethod.DELETE)
	private Boolean deleteUtilisateur(@PathVariable int id){
		 utilisateurRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/utilisateurs/{id}" , method=RequestMethod.PUT)
	private Utilisateur updateUtilisateur(@PathVariable int id,@RequestBody Utilisateur c){
		c.setIdUtilisateur(id);
		return utilisateurRepository.save(c);
	}

}
