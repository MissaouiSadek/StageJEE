package org.missaoui.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cmdChequier")
public class CmdChequier {

	@Id
	@Column(name = "idCmdChequier")
	@NotEmpty(message="idCmdChequier ne doit pas etre vide")
	private int idCmdChequier;
	
	@Column(name="statut")
	@NotEmpty(message="statut ne doit pas etre vide")
	private String statut;
	
	@Column(name="nombre")
	@NotEmpty(message="nombre ne doit pas etre vide")
	private String nombre;
	
    @ManyToOne
    @Size(max=8, min=8, message="La taille du idClient doit etre 8")
	@NotEmpty(message="idClient ne doit pas etre vide")
    @JoinColumn(name="idClient")
    private Client client;
	
    @ManyToOne
	@JoinColumn(name="RIB")
	@NotEmpty(message="RIB ne doit pas etre vide")
	private Compte compte;

	public CmdChequier() {
		super();
	}
	
	public CmdChequier(int idCmdChequier, String statut, String nombre, Client client, Compte compte) {
		super();
		this.idCmdChequier = idCmdChequier;
		this.statut = statut;
		this.nombre = nombre;
		this.client = client;
		this.compte = compte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getIdCmdChequier() {
		return idCmdChequier;
	}

	public void setIdCmdChequier(int idCmdChequier) {
		this.idCmdChequier = idCmdChequier;
	}
	
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
