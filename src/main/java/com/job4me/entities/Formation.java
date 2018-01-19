package com.job4me.entities;

import javax.persistence.*;

@Entity
@Table(name = "formation")
public class Formation {

	//***************************** les attributs *****************************
	
		@Column(name = "diplome")
		private String diplome;	
		@Column(name = "etablissement")
		private String etablissement;
		@Column(name = "annee")
		private String annee;
		@Column(name = "specialité")
		private String specialité;
		private int idFormation;
		private CvEnLigne cvEnLigne;
		
		//*************************** getters and setters ***************************
		
		
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getIdFormation() {
			return idFormation;
		}
		public String getDiplome() {
			return diplome;
		}
		public void setDiplome(String diplome) {
			this.diplome = diplome;
		}
		public String getEtablissement() {
			return etablissement;
		}
		public void setEtablissement(String etablissement) {
			this.etablissement = etablissement;
		}
		public String getAnnee() {
			return annee;
		}
		public void setAnnee(String annee) {
			this.annee = annee;
		}
		public String getSpecialité() {
			return specialité;
		}
		public void setSpecialité(String specialité) {
			this.specialité = specialité;
		}
		public void setIdFormation(int idFormation) {
			this.idFormation = idFormation;
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
		public Formation() {
			super();
			// TODO Auto-generated constructor stub
		}

		//*************************** constructeur + attributs ********************************
		

		public Formation(String diplome, String etablissement, String annee, String specialité, CvEnLigne cvEnLigne) {
			this.diplome = diplome;
			this.etablissement = etablissement;
			this.annee = annee;
			this.specialité = specialité;
			this.cvEnLigne = cvEnLigne;
		}
}
