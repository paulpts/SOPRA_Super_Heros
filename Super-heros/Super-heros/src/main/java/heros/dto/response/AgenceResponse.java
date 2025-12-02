package heros.dto.response;

import heros.model.Agence;

public class AgenceResponse {

    private Integer id;
    private double budget;
    private int popularite;
    private String ville;
    private int chefAgenceId;


    public Integer getId() {
		return id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getPopularite() {
		return popularite;
	}

	public void setPopularite(int popularite) {
		this.popularite = popularite;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getChefAgenceId() {
		return chefAgenceId;
	}

	public void setChefAgenceId(int chefAgenceId) {
		this.chefAgenceId = chefAgenceId;
	}

	public static AgenceResponse convert(Agence agence) {
        AgenceResponse response = new AgenceResponse();

        response.setId(agence.getId());
        response.setBudget(agence.getBudget());
        response.setPopularite(agence.getPopularite());
        response.setVille(agence.getVille());

        if (agence.getChefAgence() != null) {
            response.setChefAgenceId(agence.getChefAgence().getId());
        }

        return response;
    }

}
