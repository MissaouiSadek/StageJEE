package org.missaoui.test.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.missaoui.test.config.JsonDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "abonne")
public class Abonne {

	@Id
	@Column(name = "idClient")
	@Size(max=8, min=8, message="La taille du idClient doit etre 8")
	@NotEmpty(message="idClient ne doit pas etre vide")
	private String idClient;
	
	@Column(name="codeAbonne")
	@NotEmpty(message="codeAbonne ne doit pas etre vide")
	private String codeAbonne;
	
	@Column(name="passwordAbonne")
	@Pattern(regexp="[0-9]*", message="passwordAbonne ne doit contenir que des chiffres")
	@NotEmpty(message="passwordAbonne ne doit pas etre vide")
	private String passwordAbonne;
	
	@Column(name="dateCreation")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotEmpty(message="dateCreation ne doit pas etre vide")
	private Date dateCreation;
	
	@OneToMany(mappedBy="abonne",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Beneficiaire> beneficiaires;
	
	@OneToMany(mappedBy="abonne",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DemandeVirementBancaire> demandeVirementBancaires;
	
	public Abonne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Abonne(String idClient, String codeAbonne, String passwordAbonne, Date dateCreation) {
		super();
		this.idClient = idClient;
		this.codeAbonne = codeAbonne;
		this.passwordAbonne = passwordAbonne;
		this.dateCreation = dateCreation;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getCodeAbonne() {
		return codeAbonne;
	}

	public void setCodeAbonne(String codeAbonne) {
		this.codeAbonne = codeAbonne;
	}

	public String getPasswordAbonne() {
		return passwordAbonne;
	}

	public void setPasswordAbonne(String passwordAbonne) {
		this.passwordAbonne = passwordAbonne;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Set<Beneficiaire> getBeneficiaires() {
		return beneficiaires;
	}

	public void setBeneficiaires(Set<Beneficiaire> beneficiaires) {
		this.beneficiaires = beneficiaires;
	}

	public Set<DemandeVirementBancaire> getDemandeVirementBancaires() {
		return demandeVirementBancaires;
	}

	public void setDemandeVirementBancaires(Set<DemandeVirementBancaire> demandeVirementBancaires) {
		this.demandeVirementBancaires = demandeVirementBancaires;
	}
	
}
