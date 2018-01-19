package com.job4me.entities;

import javax.persistence.*;

@Entity
@Table(name = "experience")
public class Experience {

	//********************************** les attributs  ********************************
	
		@Column(name = "description")
		private String description;	
		@Column(name = "poste_occupe")
		private String poste_occupe;	
		@Column(name = "duree")
		private String duree;	
		private int idExperience;
		private CvEnLigne cvEnLigne;
		
		//***************************** getters and setters *************************
		public String getdescription() {
			return description;
		}
		public void setdescription(String description) {
			this.description = description;
		}
		public String getposte_occupe() {
			return poste_occupe;
		}
		public void setposte_occupe(String poste_occupe) {
			this.poste_occupe = poste_occupe;
		}
		public String getDuree() {
			return duree;
		}
		public void setDuree(String duree) {
			this.duree = duree;
		}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getIdExperience() {
			return idExperience;
		}
		public void setIdExperience(int idExperience) {
			this.idExperience = idExperience;
		}
		@ManyToOne(targetEntity = com.job4me.entities.CvEnLigne.class)
	    @JoinColumn(name="idCvEnLigne", nullable=false)
		public CvEnLigne getCvEnLigne() {
			return cvEnLigne;
		}
		public void setCvEnLigne(CvEnLigne cvEnLigne) {
			this.cvEnLigne = cvEnLigne;
		}

		//*************************** constructeur par defaut ********************************
		public Experience() {
			super();
			// TODO Auto-generated constructor stub
		}

		//*************************** constructeur + attributs ********************************
		public Experience(String description, String poste_occupe, String duree, CvEnLigne cvEnLigne) {
			super();
			this.description = description;
			this.poste_occupe = poste_occupe;
			this.duree = duree;
			this.cvEnLigne = cvEnLigne;
		}
	
}
