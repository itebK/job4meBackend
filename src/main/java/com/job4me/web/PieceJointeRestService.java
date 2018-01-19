package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.PieceJointeRepository;
import com.job4me.entities.PieceJointe;

@RestController
@CrossOrigin("*")
public class PieceJointeRestService {

	@Autowired
	private PieceJointeRepository piecejointeRepository;
	
	@RequestMapping(value="/piecejointe" , method=RequestMethod.GET)
	private List<PieceJointe> getPieceJointe(){
		return piecejointeRepository.findAll();
	}
	@RequestMapping(value="/piecejointe/{id}" , method=RequestMethod.GET)
	private PieceJointe getPieceJointe(@PathVariable int id){
		return piecejointeRepository.findOne(id);
	}
	@RequestMapping(value="/piecejointeLettreMotivation" , method=RequestMethod.POST)
	private PieceJointe saveLettreMotivation(@RequestBody PieceJointe o){
		return piecejointeRepository.save(o);
	}
	
	

	@RequestMapping(value="/piecejointeCV" , method=RequestMethod.POST)
	private PieceJointe saveCv(@RequestBody PieceJointe o){
		return piecejointeRepository.save(o);
	}
	@RequestMapping(value="/piecejointes/{id}" , method=RequestMethod.DELETE)
	private Boolean deletePieceJointe(@PathVariable int id){
		 piecejointeRepository.delete(id);
		 return true;
	}
	@RequestMapping(value="/piecejointes/{id}" , method=RequestMethod.PUT)
	private PieceJointe updatePieceJointe(@PathVariable int id,@RequestBody PieceJointe o){
		o.setIdDocument(id);
		return piecejointeRepository.save(o);
	}
	
	/*---------Get Liste Cv du Candidat ------------------*/
	@RequestMapping(value="/piecejointeCV/{id}" , method=RequestMethod.GET)
	private List<PieceJointe> getListeCvCandidat(@PathVariable int id){
		return piecejointeRepository.getListeCvCandidat(id);
	}
	
	/*---------Get Liste Lettre Motivation du Candidat ------------------*/
	@RequestMapping(value="/piecejointeLettreMotivation/{id}" , method=RequestMethod.GET)
	private List<PieceJointe> getListeLettreMotivation(@PathVariable int id){
		return piecejointeRepository.getListeLettreMotivation(id);
	}
	

}
