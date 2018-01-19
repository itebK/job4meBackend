package com.job4me.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name ="idCvEnLigne")
@Table(name = "cvEnLigne")
public class CvEnLigne extends Document{


	//******************************** les attributs **************************
	
		@Column(name = "apropos")
		private String apropos;
		private Set<Competence> competences = new HashSet<Competence>();
		//******************************* getters and setters ***************************
		
		
		public String getApropos() {
			return apropos;
		}

		public void setApropos(String apropos) {
			this.apropos = apropos;
		}

		@ManyToMany @JoinTable(joinColumns ={ @JoinColumn(name = "idCandidat") },
				inverseJoinColumns = {@JoinColumn(name = "idCompetence") })
		public Set<Competence> getCompetences() {
			return competences;
		}

		

		public void setCompetences(Set<Competence> competences) {
			this.competences = competences;
		}

		//*************************** constructeur + attributs ********************************
		public CvEnLigne(String apropos, Set<Competence> competences, Set<Experience> experiences,
				Set<Formation> formations) {
			super();
			this.apropos = apropos;
		}


		//*************************** constructeur par defaut ********************************
		public CvEnLigne() {
			super();
			// TODO Auto-generated constructor stub
		}
		

}
