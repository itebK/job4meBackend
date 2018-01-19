package com.job4me.entities;
import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name ="idLettreMotivatonEnLigne")
@Table(name = "lettreMotivatonEnLigne")
public class LettreMotivatonEnLigne extends Document{
	
	//******************************* les attributs ***************************
	
			@Column(name = "titre")
			private String titre;

	//***************************** getters and setters ************************
			public String getTitre() {
				return titre;
			}

			public void setTitre(String titre) {
				this.titre = titre;
			}

//*************************** constructeur par defaut ********************************
			public LettreMotivatonEnLigne() {
				super();
				// TODO Auto-generated constructor stub
			}

	//*************************** constructeur + attributs ********************************
			public LettreMotivatonEnLigne(String titre) {
				super();
				this.titre = titre;
			}
		
			
}
