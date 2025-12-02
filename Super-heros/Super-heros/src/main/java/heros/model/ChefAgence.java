package heros.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("chefAgence")
// @Table(name="chef_agence") On doit pas mettre de Table pour une classe enfant
public class ChefAgence extends Compte{

	@OneToOne(mappedBy= "chefAgence")
	private Agence agence;
	
	@Column(length=25)
	private String nom;
	
	@Column(length=25)
	private String prenom;//A demander � la premiere co

	public ChefAgence(String login, String password, Agence agence, String nom, String prenom) {
		super(login, password);
		this.nom=nom;
		this.prenom=prenom;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
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
