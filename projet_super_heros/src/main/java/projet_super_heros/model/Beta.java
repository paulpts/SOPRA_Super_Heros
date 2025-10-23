package projet_super_heros.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("beta")
public class Beta extends Heros{

	
	public Beta() {
	}

	public Beta(Integer id, String nom, String prenom, String alias, int popularite, int sante, double salaire,
			double coutCreation, int experience, double degats, int motivation, Agence agence) {
		super(nom, prenom, alias, popularite, sante, salaire, coutCreation, experience, degats, motivation, agence);
		// TODO Auto-generated constructor stub
	}


}
