package heros.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("chefAgence")
@Table(name="chef_agence")
public class ChefAgence extends Compte{
	
	@Column(length=25)
	String nom; //A demander � la premiere co

	public ChefAgence(String login, String password, String nom) {
		super(login,password);
		this.nom = nom;
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
