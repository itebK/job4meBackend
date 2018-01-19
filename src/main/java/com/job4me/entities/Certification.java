package com.job4me.entities;

import javax.persistence.*;

@Entity
@Table(name = "certification")
public class Certification {

	//********************************** les attributs  ********************************
	
		@Column(name = "certification")
		private String certification;	
		@Column(name = "annee")
		private String annee;	
		private int idCertification;
		private CvEnLigne cvEnLigne;
		
		//***************************** getters and setters *************************
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getIdCertification() {
			return idCertification;
		}
		public void setIdCertification(int idCertification) {
			this.idCertification = idCertification;
		}
		public void setCertification(String certification) {
			this.certification = certification;
		}
		
		public String getCertification() {
			return certification;
		}
		public String getAnnee() {
			return annee;
		}
		public void setAnnee(String annee) {
			this.annee = annee;
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
		public Certification() {
			super();
			// TODO Auto-generated constructor stub
		}

		//*************************** constructeur + attributs ********************************

		public Certification(String certification, String annee, CvEnLigne cvEnLigne) {
			this.certification = certification;
			this.annee = annee;
			this.cvEnLigne = cvEnLigne;
		}
	
		
		
		
		
		
		
		
}
