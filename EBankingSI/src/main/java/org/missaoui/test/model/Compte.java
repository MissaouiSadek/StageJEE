package org.missaoui.test.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.missaoui.test.config.JsonDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "compte")
public class Compte {
	
	@Id
	@Column(name="RIB")
	@NotEmpty(message="RIB ne doit pas etre vide")
	private String RIB;
	
	@Column(name="type")
	@NotEmpty(message="type ne doit pas etre vide")
	private String type;
	
	@Column(name="solde")
	@NotEmpty(message="solde ne doit pas etre vide")
	private double solde;
	
	@Column(name="dateCreation")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotEmpty(message="dateCreation ne doit pas etre vide")
	private Date dateCreation;

	@ManyToOne
    @Size(max=8, min=8, message="La taille du idClient doit etre 8")
	@NotEmpty(message="idClient ne doit pas etre vide")
    @JoinColumn(name="idClient")
    private Client client;
	
	@OneToMany(mappedBy="compte",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Operation> operations;
	
	@OneToMany(mappedBy="compte",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CmdChequier> cmdsChequier;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte(String rIB, String type, double solde, Date dateCreation, Client client) {
		super();
		RIB = rIB;
		this.type = type;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.client = client;
	}

	public String getNumeroCompte() {
		return RIB;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.RIB = numeroCompte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<CmdChequier> getCmdsChequier() {
		return cmdsChequier;
	}

	public void setCmdsChequier(Set<CmdChequier> cmdsChequier) {
		this.cmdsChequier = cmdsChequier;
	}
	
}
