package com.job4me.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "candidature")
public class Candidature {

	// ***************************** les attributs ****************************

	@Column(name = "message")
	private String message;
	@Temporal(TemporalType.DATE)
	private Date dateDepot;

	@Column(name = "archive", columnDefinition = "boolean default false")
	private Boolean archive = false;

	private Offre offre;
	private int idCandidature;
	// ********************************* les getters and setters
	// *******************************

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCandidature() {
		return idCandidature;
	}

	public void setIdCandidature(int idCandidature) {
		this.idCandidature = idCandidature;
	}

	@ManyToOne(targetEntity = com.job4me.entities.Offre.class)
	@JoinColumn(name = "idOffre", nullable = false)
	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	// ******************************** constructeur par defaut
	// ********************************
	public Candidature() {
		super();
		// TODO Auto-generated constructor stub
	}

	// ***************************** constructeur + attributs
	// *****************************
	public Candidature(String message, Date dateDepot, Offre offre, Set<Postuler> postulers) {
		super();
		this.message = message;
		this.dateDepot = dateDepot;
		this.offre = offre;
	}

}
