package com.job4me.entities;
import javax.persistence.*;

@Entity
@Table(name = "competence")
public class Competence {

	//**************************** les attributs  ************************************
	
	@Column(name = "libelle")
	private Competences libelle;
	private int idCompetence;
	
	//*********************** getters and setters ************************************
	@Enumerated(EnumType.STRING)
	public Competences getLibelle() {
		return libelle;
	}
	public void setLibelle(Competences libelle) {
		this.libelle = libelle;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}
	
	public Competence(Competences libelle, CvEnLigne cvEnLigne) {
		super();
		this.libelle = libelle;
	}
	
	//************************* constructeur + attributs ******************************
	
	
	
	//*************************** constructeur par defaut ********************************
	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	

}
