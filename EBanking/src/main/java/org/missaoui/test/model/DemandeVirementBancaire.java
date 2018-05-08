package org.missaoui.test.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.missaoui.test.config.JsonDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "demandeVirementBancaire")
public class DemandeVirementBancaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDemandeVirementBancaire")
	@Size(max=8, min=8, message="La taille du idDemandeVirementBancaire doit etre 8")
	@NotEmpty(message="idDemandeVirementBancaire ne doit pas etre vide")
	private int idDemandeVirementBancaire;
	
	@Column(name="RIBexpediteur")
	@NotEmpty(message="RIBexpediteur ne doit pas etre vide")
	private String RIBexpediteur;
	
	@Column(name="RIBdestinataire")
	@NotEmpty(message="RIBdestinataire ne doit pas etre vide")
	private String RIBdestinataire;
	
	@Column(name="nomDestinataire")
	private String nomDestinataire;
	
	@Column(name="prenomDestinataire")
	private String prenomDestinataire;
	
	@Column(name="montant")
	@NotEmpty(message="montant ne doit pas etre vide")
	private double montant;
	
	@Column(name="motif")
	@NotEmpty(message="motif ne doit pas etre vide")
	private String motif;
	
	@Column(name="typeVirement")
	//@NotEmpty(message="typeVirement ne doit pas etre vide")
	private String typeVirement;
	
	@Column(name="statut")
	@NotEmpty(message="statut ne doit pas etre vide")
	private String statut;
	
	@Column(name="dateVirement")
	//@NotEmpty(message="dateVirement ne doit pas etre vide")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateVirement;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	@Size(max=8, min=8, message="La taille du idClient doit etre 8")
	//@NotEmpty(message="idClient ne doit pas etre vide")
	private Abonne abonne;
	
	@ManyToOne
	@JoinColumn(name="idBeneficiaire")
	@Size(max=8, min=8, message="La taille du idBeneficiaire doit etre 8")
	@NotEmpty(message="idBeneficiaire ne doit pas etre vide")
	private Beneficiaire beneficiaire;

	public DemandeVirementBancaire() {
		super();
	}

	public DemandeVirementBancaire(int idDemandeVirementBancaire, String rIBexpediteur, String rIBdestinataire,
			String nomDestinataire, String prenomDestinataire, double montant, String motif, String typeVirement, String statut,
			Date dateVirement, Abonne abonne, Beneficiaire beneficiaire) {
		super();
		this.idDemandeVirementBancaire = idDemandeVirementBancaire;
		RIBexpediteur = rIBexpediteur;
		RIBdestinataire = rIBdestinataire;
		this.nomDestinataire = nomDestinataire;
		this.prenomDestinataire = prenomDestinataire;
		this.montant = montant;
		this.motif = motif;
		this.typeVirement = typeVirement;
		this.statut = statut;
		this.dateVirement = dateVirement;
		this.abonne = abonne;
		this.beneficiaire = beneficiaire;
	}

	public int getIdDemandeVirementBancaire() {
		return idDemandeVirementBancaire;
	}

	public void setIdDemandeVirementBancaire(int idDemandeVirementBancaire) {
		this.idDemandeVirementBancaire = idDemandeVirementBancaire;
	}

	public String getRIBexpediteur() {
		return RIBexpediteur;
	}

	public void setRIBexpediteur(String rIBexpediteur) {
		RIBexpediteur = rIBexpediteur;
	}

	public String getRIBdestinataire() {
		return RIBdestinataire;
	}

	public void setRIBdestinataire(String rIBdestinataire) {
		RIBdestinataire = rIBdestinataire;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public String getNomDestinataire() {
		return nomDestinataire;
	}

	public void setNomDestinataire(String nomDestinataire) {
		this.nomDestinataire = nomDestinataire;
	}

	public String getTypeVirement() {
		return typeVirement;
	}

	public void setTypeVirement(String typeVirement) {
		this.typeVirement = typeVirement;
	}

	public String getPrenomDestinataire() {
		return prenomDestinataire;
	}

	public void setPrenomDestinataire(String prenomDestinataire) {
		this.prenomDestinataire = prenomDestinataire;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
}
