package org.missaoui.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.missaoui.test.config.JsonDateSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "operation")
public class Operation {

	@Id
	@Column(name = "idOperation")
	@Size(max=11, min=11, message="La taille du idOperation doit etre 11")
	@NotEmpty(message="idOperation ne doit pas etre vide")
	private int idOperation;
	
	@Column(name="valeur")
	@NotEmpty(message="typeOperaion ne doit pas etre vide")
	private double valeur;
	
	@Column(name="description")
	@NotEmpty(message="description ne doit pas etre vide")
	private String description;
	
	@Column(name="dateOperation")
	//@NotEmpty(message="dateOperation ne doit pas etre vide")
	private Date dateOperation;
	
	@ManyToOne
	@JoinColumn(name="RIB")
	@NotEmpty(message="RIB ne doit pas etre vide")
	private Compte compte;

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(int idOperation, double valeur, String description, Date dateOperation,
			Compte compte) {
		super();
		this.idOperation = idOperation;
		this.valeur=valeur;
		this.description = description;
		this.dateOperation = dateOperation;
		this.compte = compte;
	}

	public int getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
}
