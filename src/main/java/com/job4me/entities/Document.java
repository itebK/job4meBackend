package com.job4me.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "document")
public class Document {

	//*************************** les attributs *********************************
	
		@Column(name = "nomDocument")
		private String nomDocument;
		
		private int idDocument;

		//private Set<Postuler> postulers = new HashSet<Postuler>();
		private Candidat candidat;
		
		//**************************** getters and setters *************************
		public String getNomDocument() {
			return nomDocument;
		}

		public void setNomDocument(String nomDocument) {
			this.nomDocument = nomDocument;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getIdDocument() {
			return idDocument;
		}

		public void setIdDocument(int idDocument) {
			this.idDocument = idDocument;
		}

		/*
		@OneToMany(mappedBy = "document")
		public Set<Postuler> getPostulers() {
			return postulers;
		}

		public void setPostulers(Set<Postuler> postulers) {
			this.postulers = postulers;
		}
		*/
		
		@ManyToOne(targetEntity = com.job4me.entities.Candidat.class)
	    @JoinColumn(name="idCandidat", nullable=false)
		public Candidat getCandidat() {
			return candidat;
		}

		public void setCandidat(Candidat candidat) {
			this.candidat = candidat;
		}
	
		//*************************** constructeur par défaut *****************************

		public Document() {
			super();
			// TODO Auto-generated constructor stub
		}

		//*************************** constructeur + attributs ********************************
		public Document(String nomDocument, Set<Postuler> postulers, Candidat candidat) {
			super();
			this.nomDocument = nomDocument;
			//this.postulers = postulers;
			this.candidat = candidat;
		}
		
		
}
