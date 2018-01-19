package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.PostulerRepository;
import com.job4me.entities.Candidat;
import com.job4me.entities.Candidature;
import com.job4me.entities.Postuler;
import com.job4me.entities.Postuler.Id;

@RestController
@CrossOrigin("*")
public class PostulerRestService {

	@Autowired
	private PostulerRepository postulerRepository;
	
	@RequestMapping(value="/postuler" , method=RequestMethod.GET)
	private List<Postuler> getPostuler(){
		return postulerRepository.findAll();
	}
	@RequestMapping(value="/postuler/{id}" , method=RequestMethod.GET)
	private Postuler getPostuler(@PathVariable Id id){
		return postulerRepository.findOne(id);
	}

	@RequestMapping(value="/postuler" , method=RequestMethod.POST)
	private Postuler savePostuler(@RequestBody Postuler o){
		Id id = new Id (o.getCandidature().getIdCandidature(),o.getDocument().getIdDocument());
		o.setId(id);
		return postulerRepository.save(o);
	}
	@RequestMapping(value="/postulers/{idcandidature}/{iddocument}" , method=RequestMethod.DELETE)
	private Boolean deletePostuler(@PathVariable int idcandidature , @PathVariable int iddocument ){
		Id id = new Id (idcandidature , iddocument) ;
		postulerRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/postulers/{idcandidature}/{iddocument}" , method=RequestMethod.PUT)
	private Postuler updatePostuler(@PathVariable int idcandidature,@PathVariable int iddocument,@RequestBody Postuler o){
		Id id = new Id (idcandidature , iddocument) ;
		o.setId(id);
		return postulerRepository.save(o);
	}
	@RequestMapping(value="/Candidatures_Vue/{id}" , method=RequestMethod.GET)
	private List<Postuler> getCandidaturesVue(@PathVariable int id ){
		return postulerRepository.getCandidaturesVue(id);
	}
	
	@RequestMapping(value="/Candidatures_Non_Vue/{id}" , method=RequestMethod.GET)
	private List<Postuler> getCandidaturesNonVue(@PathVariable int id ){
		return postulerRepository.getCandidaturesNonVue(id);
	}
	
	@RequestMapping(value="/CandidaturesCandidat/{id}" , method=RequestMethod.GET)
	private  List<Postuler> getCandidaturesCandidat(@PathVariable int id ){
		return postulerRepository.getCandidaturesCandidat (id);
	}
	
	@RequestMapping(value="/VerifCandidatOffre/{idCandidat}/{idOffre}" , method=RequestMethod.GET)
	private  Candidat VerifCandidatOffre(@PathVariable int idCandidat ,@PathVariable int idOffre ){
		return postulerRepository.VerifCandidatOffre (idCandidat ,idOffre);
	}



}
