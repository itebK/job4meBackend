package com.job4me.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "poste")
public class Poste {
	
	//*********************** les attributs **********************************
	
				@Column(name = "libelle")
				private String libelle;			
				private int idPoste;

				
	//******************************* getters and setters *********************************
				
				public String getLibelle() {
					return libelle;
				}
				public void setLibelle(String libelle) {
					this.libelle = libelle;
				}
				

				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				public int getIdPoste() {
					return idPoste;
				}
				public void setIdPoste(int idPoste) {
					this.idPoste = idPoste;
				}
				//*************************** constructeur par defaut ********************************
				public Poste() {
					super();
					// TODO Auto-generated constructor stub
				}

				//*************************** constructeur + attributs ********************************
				public Poste(String libelle, Set<Offre> offres) {
					super();
					this.libelle = libelle;
				}
				
}
