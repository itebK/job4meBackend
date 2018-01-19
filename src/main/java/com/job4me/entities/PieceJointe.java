package com.job4me.entities;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name ="idPieceJointe")
@Table(name = "pieceJointe")
public class PieceJointe extends Document{
	
	//***************************  les attributs **************************
	
				@Column(name = "path")
				private String path;
				
				@Column(name = "type")
				private String type;
				
				@Column(name = "name")
				private String name;

	// ****************************** getters and setters *************************
				
				public String getPath() {
					return path;
				}

				public void setPath(String path) {
					this.path = path;
				}
				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}
				

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				//*************************** constructeur par defaut ********************************
				public PieceJointe() {
					super();
					// TODO Auto-generated constructor stub
				}

				//*************************** constructeur + attributs ********************************
				public PieceJointe(String path, String type) {
					super();
					this.path = path;
					this.type = type;
				}

			
				
				

}
