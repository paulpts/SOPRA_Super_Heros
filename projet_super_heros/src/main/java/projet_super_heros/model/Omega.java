package projet_super_heros.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("omega")
public class Omega extends Heros{

	public Omega() {
	}

	public Omega(String nom, String prenom, String alias, int popularite, int sante, double salaire,
			double coutCreation, int experience, double degats, int motivation, Agence agence) {
		super(nom, prenom, alias, popularite, sante, salaire, coutCreation, experience, degats, motivation, agence);
	}

	
}
