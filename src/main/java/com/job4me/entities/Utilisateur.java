package com.job4me.entities;
import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "utilisateur")
public class Utilisateur {

	//***************************** les attributs *****************************
	
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom; 
	@Column(name = "email")
	private String email; 
	@Column(name = "password")
	private String password; 
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "role")
	private String role;
	@Column(name = "photo")
	private String photo;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	private int idUtilisateur;

	
	//**************************** getters and setters *********************************
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	//*************************** constructeur par defaut ********************************
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	//*************************** constructeur + attributs ********************************
	public Utilisateur(String nom, String prenom, String email, String password, String adresse, String telephone,
			String photo, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.telephone = telephone;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
	}
	//*************************** toString() ********************************
	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
				+ ", adresse=" + adresse + ", telephone=" + telephone + ", photo=" + photo + ", dateNaissance="
				+ dateNaissance + ", idUtilisateur=" + idUtilisateur + "]";
	}

	

	
}
