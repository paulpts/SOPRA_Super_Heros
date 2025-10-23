package projet_super_heros.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("chefAgence")
public class ChefAgence extends Compte{
	
	@Column(length=25)
	String nom; //A demander à la premiere co

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
