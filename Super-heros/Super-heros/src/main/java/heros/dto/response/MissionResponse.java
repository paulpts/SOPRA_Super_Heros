package heros.dto.response;

import heros.model.Mission;

public class MissionResponse {
	private int id;
	private int difficulte;
	private String description;
    private int niveauDanger;
    private String ville;



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



	public static MissionResponse convert(Mission mission) {
		MissionResponse resp = new MissionResponse();

        resp.setId(mission.getId());
        resp.setDifficulte(mission.getDifficulte());
        resp.setDescription(mission.getDescription());
        resp.setNiveauDanger(mission.getNiveauDanger());
        resp.setVille(mission.getVille());

        return resp;
    }
}
