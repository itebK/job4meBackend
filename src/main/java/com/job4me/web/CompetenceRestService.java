package com.job4me.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job4me.dao.CompetenceRepository;
import com.job4me.entities.Competence;

@RestController
@CrossOrigin("*")
public class CompetenceRestService {
	@Autowired
	private CompetenceRepository competenceRepository;

	@RequestMapping(value = "/competence", method = RequestMethod.GET)
	private List<Competence> getCompetence() {
		return competenceRepository.findAll();
	}

	@RequestMapping(value = "/competence/{id}", method = RequestMethod.GET)
	private Competence getCompetence(@PathVariable int id) {
		return competenceRepository.findOne(id);
	}

	@RequestMapping(value = "/competences", method = RequestMethod.POST)
	private Competence saveCompetence(@RequestBody Competence c) {
		return competenceRepository.save(c);
	}

	@RequestMapping(value = "/competences/{id}", method = RequestMethod.DELETE)
	private Boolean deleteCompetence(@PathVariable int id) {
		competenceRepository.delete(id);
		return true;
	}

	@RequestMapping(value = "/competences/{id}", method = RequestMethod.PUT)
	private Competence updateCompetence(@PathVariable int id, @RequestBody Competence c) {
		c.setIdCompetence(id);
		return competenceRepository.save(c);
	}

}
