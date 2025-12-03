package heros.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMissionRequest {
	
	@NotNull
	private int difficulte;
	
	@NotBlank
	private String description;
	
	@NotNull
	private int niveauDanger;
	
	@NotNull
	private double creditMission;
	
	@NotBlank
	private String statut;

	@NotBlank
	private String ville;
	
	private int agenceId;


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

	public double getCreditMission() {
		return creditMission;
	}

	public void setCreditMission(double creditMission) {
		this.creditMission = creditMission;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getAgenceId() {
		return agenceId;
	}

	public void setAgenceId(int agenceId) {
		this.agenceId = agenceId;
	}


}
