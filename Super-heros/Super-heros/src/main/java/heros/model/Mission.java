package heros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mission")
public class Mission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;		
	
	@Column(nullable = false)									// id en integer car ne peut pas être null
	private int difficulte;	
	@Column(nullable = false, length = 100)										// Représente le niveau de difficulté d'une mission (entre 1 et 4 par exemple)
	private String description;			// Description de ce que veut dire la mission
	@Column(nullable = false)	
	private int niveauDanger;			// Marche un peu comme la difficulté mais permet d'assimiler les héros plus ou moins puissants aux niveaux des missions
	@Column(nullable = false, length = 30)	
	private String ville;				// Peut etre un enum à faire ?
	@Column(nullable = false, length = 30)	
	private String statut;				// Statut : en cours, terminé, pas encore commencé 
	@Column(nullable = false)	
	private double creditMission;
	@ManyToOne
	@JoinColumn(name = "agence_id", nullable = false)
	private Agence agence;				// Correspond à combien la mission rapporte suivant son niveau de difficulté
	
	
	public Mission(int difficulte, String description, int niveauDanger, String ville, String statut,             // Pas d'ID car il sera généré en autoincrément
			double creditMission, Agence agence) {
		super();
		this.difficulte = difficulte;
		this.description = description;
		this.niveauDanger = niveauDanger;
		this.ville = ville;
		this.statut = statut;
		this.creditMission = creditMission;
		this.agence = agence;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	
	
	
	
	// Pour chaque fonction je me demande s'il faut mettre static, à voir après avec l'utilisation
	
	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	public boolean validerMission() { // je vois pas encore l'intérêt de son utilisation		
		
		return true;
		
	}
	
/*	public double coutDegat() {		// En fonction de l'attribut degat de la classe héros ? 
		 
	}
	
	public double popAgence() {		// Diminue si une mission échoue et augmente si une mission est un succès
		
	}
	
	public double popHeros() {		// Diminue si une mission échoue et augmente si une mission est un succès + rapport avec les médias
		
	} */
	
	@Override
	public String toString() {
		return "Mission [id=" + id + ", difficulte=" + difficulte + ", description=" + description + ", niveauDanger="
				+ niveauDanger + ", ville=" + ville + ", statut=" + statut + ", creditMission=" + creditMission + "]";
	}
	
	

}
