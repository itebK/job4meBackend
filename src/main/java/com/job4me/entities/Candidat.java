package com.job4me.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idCandidat")
@Table(name = "candidat")
public class Candidat extends Utilisateur {

	// ************************** les attributs *********************************
	@Column(name = "civilité")
	private String civilité;

	// getters and setters
	public String getCivilité() {
		return civilité;
	}

	public void setCivilité(String civilité) {
		this.civilité = civilité;
	}

	// **************************** constructeur par defaut
	// *************************

	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	// ***************************** constructeur + attributs
	// *****************************
	public Candidat(String civilité, Set<FavorisCandidatOffre> favoris, Set<Document> documents) {
		super();
		this.civilité = civilité;
	}

}
