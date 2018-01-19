package com.job4me.entities;

import java.io.Serializable;

import javax.persistence.*;



@Entity
public class Postuler {

	//****************************** les attributs ******************************
		@Embeddable
		public static class Id implements Serializable {
			@Column(name = "idCandidature")
			private Integer idCandidature;
			@Column(name = "idDocument")
			private Integer idDocument;
			public Id() {
			}
			public Id(Integer idCandidature, Integer idDocument) {
				super();
				this.idCandidature = idCandidature;
				this.idDocument = idDocument;
				}
			
			
		}
		@EmbeddedId
		private Id id = new Id();
		

		@Column(name = "vue" , columnDefinition="boolean default false")
		private Boolean vue = false;
		

		@ManyToOne
		@JoinColumn(name = "idCandidature", insertable = false, updatable = false)
		private Candidature candidature;
		@ManyToOne
		@JoinColumn(name = "idDocument", insertable = false, updatable = false)
		private Document document;
		

		//*************************** constructeur par defaut ********************************
		public Postuler() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Id getId() {
			return id;
		}


		public void setId(Id id) {
			this.id = id;
		}


		public Boolean getVue() {
			return vue;
		}


		public void setVue(Boolean vue) {
			this.vue = vue;
		}


		public Candidature getCandidature() {
			return candidature;
		}


		public void setCandidature(Candidature candidature) {
			this.candidature = candidature;
		}


		public Document getDocument() {
			return document;
		}


		public void setDocument(Document document) {
			this.document = document;
		}
		
		
}
