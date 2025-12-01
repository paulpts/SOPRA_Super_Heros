package heros.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("chefAgence")
// @Table(name="chef_agence") On doit pas mettre de Table pour une classe enfant
public class ChefAgence extends Compte{
	
	@Column(length=25)
	String nom;
	
	String prenom;//A demander � la premiere co

	public ChefAgence(String login, String password, String nom, String prenom) {
		super(login,password);
		this.nom = nom;
		this.prenom = prenom;
	}

	public ChefAgence() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	

}
