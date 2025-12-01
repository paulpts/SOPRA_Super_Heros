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



	@Override
	protected double payerSalaire() {

		return (this.getExperience() * 2000) + (this.getPopularite() * 1000);
	}


}
