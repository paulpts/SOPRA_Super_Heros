package heros.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateOrUpdateMissionRequest {
	
	@NotNull
	private int difficulte;
	
	@NotBlank
	private String description;
	
	@NotNull
	private int niveauDanger;

	@NotBlank
	private String ville;

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

}
