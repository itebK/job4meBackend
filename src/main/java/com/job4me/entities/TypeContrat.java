package com.job4me.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "typeContrat")
public class TypeContrat {

	//***************************** les attributs ************************************
	
			@Column(name = "libelle")
			private String libelle;			
			private int idTypeContrat;
			
	//**************************** getters and setters ********************************
			public String getLibelle() {
				return libelle;
			}
			public void setLibelle(String libelle) {
				this.libelle = libelle;
			}
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			public int getIdTypeContrat() {
				return idTypeContrat;
			}
			public void setIdTypeContrat(int idTypeContrat) {
				this.idTypeContrat = idTypeContrat;
			}
			
			
			
			//*************************** constructeur par defaut *****************************************
			public TypeContrat() {
				super();
				// TODO Auto-generated constructor stub
			}
			

			//*************************** constructeur +attributs ********************************
			public TypeContrat(String libelle, Set<Offre> offres) {
				super();
				this.libelle = libelle;
			}
			
			

			
			
			
			
}
