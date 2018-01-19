package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.FavorisCandidatOffreRepository;
import com.job4me.entities.FavorisCandidatOffre;
import com.job4me.entities.FavorisCandidatOffre.Id;

@RestController
@CrossOrigin("*")
public class FavorisCandidatOffreRestService {

	@Autowired
	private FavorisCandidatOffreRepository favoriscandidatoffreRepository;
	
	@RequestMapping(value="/favoriscandidatoffre" , method=RequestMethod.GET)
	private List<FavorisCandidatOffre> getFavorisCandidatOffre(){
		return favoriscandidatoffreRepository.findAll();
	}
	@RequestMapping(value="/favoriscandidatoffre/{idCandidat}/{idOffre}" , method=RequestMethod.GET)
	private FavorisCandidatOffre getFavoris(@PathVariable int idCandidat , @PathVariable int idOffre){
		Id id = new Id(idCandidat, idOffre) ;
		return favoriscandidatoffreRepository.findOne(id);
	}

	@RequestMapping(value="/favoriscandidatoffre" , method=RequestMethod.POST)
	private FavorisCandidatOffre saveFavorisCandidatOffre(@RequestBody FavorisCandidatOffre o){
		o.setId(new Id(o.getCandidat().getIdUtilisateur(), o.getOffre().getIdOffre()));
		return favoriscandidatoffreRepository.save(o);
	}
	
	@RequestMapping(value="/favoriscandidatoffre/{idcandidat}/{idoffre}" , method=RequestMethod.DELETE)
	private Boolean deleteFavorisCandidatOffre(@PathVariable int idcandidat , @PathVariable int idoffre ){
		Id id = new Id (idcandidat , idoffre)  ;
		 favoriscandidatoffreRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/favoriscandidatoffres/{id}" , method=RequestMethod.PUT)
	private FavorisCandidatOffre updateFavorisCandidatOffre(@PathVariable Id id,@RequestBody FavorisCandidatOffre o){
		o.setId(id);
		return favoriscandidatoffreRepository.save(o);
	}
	
	@RequestMapping(value="/favorisCandidat/{id}" , method=RequestMethod.GET)
	private List<FavorisCandidatOffre> favorisCandidat(@PathVariable int id){
		return favoriscandidatoffreRepository.favorisCandidat(id);
	}


}
