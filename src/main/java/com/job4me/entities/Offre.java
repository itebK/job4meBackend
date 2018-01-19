package com.job4me.entities;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "offre")
public class Offre {

	//****************************** les attributs *********************************
	
		@Column(name = "titre")
		private String titre;
		@Column(name = "description")
		private String description; 
		@Column(name = "salaire")
		private int salaire; 
		@Temporal(TemporalType.DATE)
		private Date dateCreation;
		@Temporal(TemporalType.DATE)
		private Date dateExpiration;
		@Column(name = "ville")
		private Ville ville;
		
		private Entreprise entreprise;
		private TypeContrat typeContrat;
		private String poste;
		private Set<Competence> competences = new HashSet<Competence>();

		private int idOffre;
		
		//*********************** getters and setters ******************************
		
		@ManyToOne(targetEntity = com.job4me.entities.TypeContrat.class)
	    @JoinColumn(name="idTypeContrat", nullable=false)
		public TypeContrat getTypeContrat() {
			return typeContrat;
		}

		public void setTypeContrat(TypeContrat typeContrat) {
			this.typeContrat = typeContrat;
		}

		@ManyToOne(targetEntity = com.job4me.entities.Entreprise.class)
	    @JoinColumn(name="idEntreprise", nullable=false)
		public Entreprise getEntreprise() {
			return entreprise;
		}

		public void setEntreprise(Entreprise entreprise) {
			this.entreprise = entreprise;
		}
		
		
		public String getPoste() {
			return poste;
		}
		
		
		@ManyToMany @JoinTable( joinColumns ={ @JoinColumn(name = "idOffre") },
		inverseJoinColumns = {@JoinColumn( name = "idCompetence") })
		public Set<Competence> getCompetences() {
			return competences;
		}

		public void setCompetences(Set<Competence> competences) {
			this.competences = competences;
		}

		public void setPoste(String poste) {
			this.poste = poste;
		}
		
	
		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getSalaire() {
			return salaire;
		}

		public void setSalaire(int salaire) {
			this.salaire = salaire;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public Date getDateExpiration() {
			return dateExpiration;
		}

		public void setDateExpiration(Date dateExpiration) {
			this.dateExpiration = dateExpiration;
		}


		@Enumerated(EnumType.STRING)
		public Ville getVille() {
			return ville;
		}

		public void setVille(Ville ville) {
			this.ville = ville;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getIdOffre() {
			return idOffre;
		}

		public void setIdOffre(int idOffre) {
			this.idOffre = idOffre;
		}
		//*************************** constructeur par defaut ********************************
		public Offre() {
			super();
			// TODO Auto-generated constructor stub
		}


		//*************************** constructeur par + attributs ********************************
		public Offre(String titre, String description, int salaire, Date dateCreation, Date dateExpiration,
				Ville ville, Entreprise entreprise, TypeContrat typeContrat, String poste) {
			super();
			this.titre = titre;
			this.description = description;
			this.salaire = salaire;
			this.dateCreation = dateCreation;
			this.dateExpiration = dateExpiration;
			this.ville = ville;
			this.entreprise = entreprise;
			this.typeContrat = typeContrat;
			this.poste = poste;
		}

		
		
}
