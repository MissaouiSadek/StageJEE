package org.missaoui.test.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "beneficiaire")
public class Beneficiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBeneficiaire")
	@NotEmpty(message="idBeneficiaire ne doit pas etre vide")
	private int idBeneficiaire;
	
	@Column(name="RIB")
	@NotEmpty(message="RIB ne doit pas etre vide")
	private String RIB;
	
	@Column(name="nom")
	@NotEmpty(message="nom ne doit pas etre vide")
	private String nom;
	
	@Column(name="prenom")
	@NotEmpty(message="prenom ne doit pas etre vide")
	private String prenom;
	
	@Column(name="statut")
	@NotEmpty(message="statut ne doit pas etre vide")
	private String statut;	

	@Column(name="codeValidation")
	@NotEmpty(message="codeValidation ne doit pas etre vide")
	private String codeValidation;
	
    @ManyToOne
    @Size(max=8, min=8, message="La taille du idClient doit etre 8")
	@NotEmpty(message="idClient ne doit pas etre vide")
    @JoinColumn(name="idClient")
    private Abonne abonne;
    
	@OneToMany(mappedBy="beneficiaire",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DemandeVirementBancaire> demandeVirementBancaires;

	public Beneficiaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beneficiaire(int idBeneficiaire, String RIB, String nom, String prenom, String statut, String codeValidation,
			Abonne abonne) {
		super();
		this.idBeneficiaire = idBeneficiaire;
		this.RIB = RIB;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.codeValidation = codeValidation;
		this.abonne = abonne;
	}

	public int getIdBeneficiaire() {
		return idBeneficiaire;
	}

	public void setIdBeneficiaire(int idBeneficiaire) {
		this.idBeneficiaire = idBeneficiaire;
	}
	
	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getCodeValidation() {
		return codeValidation;
	}

	public void setCodeValidation(String codeValidation) {
		this.codeValidation = codeValidation;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	public Set<DemandeVirementBancaire> getDemandeVirementBancaires() {
		return demandeVirementBancaires;
	}

	public void setDemandeVirementBancaires(Set<DemandeVirementBancaire> demandeVirementBancaires) {
		this.demandeVirementBancaires = demandeVirementBancaires;
	}

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

}
