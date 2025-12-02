package heros.dto.response;

import heros.model.Mission;

public class MissionResponse {
	private int id;
	private int difficulte;
	private String description;
    private int niveauDanger; 
    private String ville;
    private String statut;
    private double creditMission;
    private int agenceId;
    private int herosId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getNiveauDanger() {
		return niveauDanger;
	}

	public void setNiveauDanger(int niveauDanger) {
		this.niveauDanger = niveauDanger;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public double getCreditMission() {
		return creditMission;
	}

	public void setCreditMission(double creditMission) {
		this.creditMission = creditMission;
	}

	
	public int getAgenceId() {
		return agenceId;
	}

	public void setAgenceId(int agenceId) {
		this.agenceId = agenceId;
	}

	public int getHerosId() {
		return herosId;
	}

	public void setHerosId(int herosId) {
		this.herosId = herosId;
	}

	public static MissionResponse convert(Mission mission) {
		MissionResponse response = new MissionResponse();

		response.setId(mission.getId());
		response.setDifficulte(mission.getDifficulte());
		response.setDescription(mission.getDescription());
		response.setNiveauDanger(mission.getNiveauDanger());
		response.setVille(mission.getVille());
		response.setStatut(mission.getStatut());
		response.setCreditMission(mission.getCreditMission());
        
        if (mission.getAgence() != null) {
            response.setAgenceId(mission.getAgence().getId());
        }
        
        else if (mission.getHero() != null) {
            response.setHerosId(mission.getHero().getId());
        }

        return response;
    }
}
