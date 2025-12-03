package heros.model;

import java.util.List;

import heros.enumerator.Pouvoirs;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("beta")
public class Beta extends Heros{

	
	public Beta() {
	}


	public Beta(String nom, String prenom, String alias, int popularite, int sante, double salaire, double coutCreation,
			int experience, double degats, int motivation, Agence agence, List<Pouvoirs> pouvoirs,
			List<Mission> mission) {
		super(nom, prenom, alias, popularite, sante, salaire, coutCreation, experience, degats, motivation, agence, pouvoirs,
				mission);
		// TODO Auto-generated constructor stub
	}

		public Beta(String nom, String prenom, String alias, int popularite, int sante, double salaire, int experience,
			double degats, int motivation, List<Pouvoirs> pouvoirs) {
		this.nom = nom;
		this.prenom = prenom;
		this.alias = alias;
		this.popularite = popularite;
		this.sante = sante;
		this.salaire = salaire;
		this.experience = experience;
		this.degats = degats;
		this.motivation = motivation;
		this.pouvoirs = pouvoirs;
	}



	@Override
	protected double payerSalaire() {

		return (this.getExperience() * 2000) + (this.getPopularite() * 1000);
	}


}
