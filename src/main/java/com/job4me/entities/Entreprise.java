package com.job4me.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@PrimaryKeyJoinColumn(name ="idEntreprise")
@Table(name = "entreprise")
public class Entreprise  extends Utilisateur{
		
		//**************************** attributs *********************************
		@Column(name = "secteurActivité")
		private String secteurActivité;

		@Column(name = "siteWeb")
		private String siteWeb;
		
		@Column(name = "effectif")
		private int effectif;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "ville")
		private Ville ville;


		
		//***************************** getters and setters *****************************
		
		
		public String getSecteurActivité() {
			return secteurActivité;
		}


		public void setSecteurActivité(String secteurActivité) {
			this.secteurActivité = secteurActivité;
		}

		public String getSiteWeb() {
			return siteWeb;
		}

		public void setSiteWeb(String siteWeb) {
			this.siteWeb = siteWeb;
		}

		public int getEffectif() {
			return effectif;
		}

		public void setEffectif(int effectif) {
			this.effectif = effectif;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	

		

		@Enumerated(EnumType.STRING)
		public Ville getVille() {
			return ville;
		}

		
		public void setVille(Ville ville) {
			this.ville = ville;
		}

		//*************************** constructeur par defaut ********************************
		public Entreprise() {
			super();
			// TODO Auto-generated constructor stub
		}


		//*************************** constructeur + attributs ********************************
		public Entreprise(String secteurActivité, String siteWeb, int effectif, String description, Ville ville) {
			super();
			this.secteurActivité = secteurActivité;
			this.siteWeb = siteWeb;
			this.effectif = effectif;
			this.description = description;
			this.ville = ville;
		}


}
