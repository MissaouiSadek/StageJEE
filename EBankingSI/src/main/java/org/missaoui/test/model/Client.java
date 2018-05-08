package org.missaoui.test.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.missaoui.test.config.JsonDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "idClient")
	@Size(max=8, min=8, message="La taille du idClient doit etre 8")
	@NotEmpty(message="idClient ne doit pas etre vide")
	private String idClient;
	
	@Column(name="nom")
	@NotEmpty(message="nom ne doit pas etre vide")
	private String nom;
	
	@Column(name="prenom")
	@NotEmpty(message="prenom ne doit pas etre vide")
	private String prenom;
	
	@Column(name="sexe")
	@NotEmpty(message="sexe ne doit pas etre vide")
	private String sexe;
	
	@Column(name="email")
	@Email(message="Email doit etre valide")
	@NotEmpty(message="email ne doit pas etre vide")
	private String email;
	
	@Column(name="telephone")
	@NotEmpty(message="telephone ne doit pas etre vide")
	private String telephone;
	
	@Past(message="Date de naissance doit etre dans le passe")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "dateDeNaissance")
	private Date dateDeNaissance;
	
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Compte> comptes;
	
	@OneToMany(mappedBy="client",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CmdChequier> cmdsChequier;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String idClient, String nom, String prenom, String sexe, String email, String telephone,
			Date dateDeNaissance) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.email = email;
		this.telephone = telephone;
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Set<CmdChequier> getCmdsChequier() {
		return cmdsChequier;
	}

	public void setCmdsChequier(Set<CmdChequier> cmdsChequier) {
		this.cmdsChequier = cmdsChequier;
	}
	
}