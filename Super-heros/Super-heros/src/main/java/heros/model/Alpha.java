package heros.model;

import java.util.List;

import heros.enumerator.Pouvoirs;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("alpha")
public class Alpha extends Heros{


	public Alpha() {
	}

	public Alpha(String nom, String prenom, String alias, int popularite, int sante, double salaire,
			double coutCreation, int experience, double degats, int motivation, Agence agence, List<Pouvoirs> pouvoirs,
			List<Mission> mission) {
		super(nom, prenom, alias, popularite, sante, salaire, coutCreation, experience, degats, motivation, agence, pouvoirs,
				mission);
	}



	@Override
	protected double payerSalaire() {

		return (this.getExperience() * 3000) + (this.getPopularite() * 1500);
	}

}
