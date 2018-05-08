package org.missaoui.test.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "administrateur")
public class Administrateur {

	@Id
	@Column(name = "idAdministrateur")
	@Size(max = 8, min = 8, message = "La taille du idAdministrateur doit etre 8")
	@NotEmpty(message = "idAdministrateur ne doit pas etre vide")
	private String idAdministrateur;

	@Column(name = "username")
	@NotEmpty(message = "username ne doit pas etre vide")
	private String username;

	@Column(name = "password")
	@NotEmpty(message = "password ne doit pas etre vide")
	private String password;
	
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String idAdministrateur, String username, String password) {
		super();
		this.idAdministrateur = idAdministrateur;
		this.username = username;
		this.password = password;
	}

	public String getIdAdministrateur() {
		return idAdministrateur;
	}

	public void setIdAdministrateur(String idAdministrateur) {
		this.idAdministrateur = idAdministrateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
