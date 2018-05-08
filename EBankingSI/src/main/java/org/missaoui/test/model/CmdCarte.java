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
@Table(name = "cmdCarte")
public class CmdCarte {

	@Id
	@Column(name = "idCmdCarte")
	@NotEmpty(message="idCmdCarte ne doit pas etre vide")
	private int idCmdCarte;
	
	@Column(name="type")
	@NotEmpty(message="type ne doit pas etre vide")
	private String type;
	
	@Column(name="statut")
	@NotEmpty(message="statut ne doit pas etre vide")
	private String statut;
	
    @ManyToOne
    @Size(max=8, min=8, message="La taille du idClient doit etre 8")
	@NotEmpty(message="idClient ne doit pas etre vide")
    @JoinColumn(name="idClient")
    private Client client;
	
    @ManyToOne
	@JoinColumn(name="RIB")
	@NotEmpty(message="RIB ne doit pas etre vide")
	private Compte compte;

	public CmdCarte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CmdCarte(int idCmdCarte, String type, String statut, Client client, Compte compte) {
		super();
		this.idCmdCarte = idCmdCarte;
		this.type = type;
		this.statut = statut;
		this.client = client;
		this.compte = compte;
	}

	public int getIdCmdCarte() {
		return idCmdCarte;
	}

	public void setIdCmdCarte(int idCmdCarte) {
		this.idCmdCarte = idCmdCarte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
