package com.job4me.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class FavorisCandidatOffre {

	//**************************** les attributs ***********************
	@Embeddable
	public static class Id implements Serializable {
		@Column(name = "idCandidat")
		private Integer idCandidat;
		@Column(name = "idOffre")
		private Integer idOffre;
		public Id() {
		}
		public Id(Integer idCandidat, Integer idOffre) {
			super();
			this.idCandidat = idCandidat;
			this.idOffre = idOffre;
			}
	}
	@EmbeddedId
	private Id id = new Id();
	

	@ManyToOne
	@JoinColumn(name = "idCandidat", insertable = false, updatable = false)
	private Candidat candidat;
	@ManyToOne
	@JoinColumn(name = "idOffre", insertable = false, updatable = false)
	private Offre offre;
	

	//*************************** constructeur par defaut ********************************
	public FavorisCandidatOffre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Id getId() {
		return id;
	}


	public void setId(Id id) {
		this.id = id;
	}


	public Candidat getCandidat() {
		return candidat;
	}


	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}


	public Offre getOffre() {
		return offre;
	}


	public void setOffre(Offre offre) {
		this.offre = offre;
	}


	public FavorisCandidatOffre(Candidat candidat, Offre offre) {
		this.candidat = candidat;
		this.offre = offre;
	}
	
	
	
}
