package heros.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agence")
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private double budget;

	@Column(nullable = false)
	private int popularite;

	@Column(nullable = false)
	private String ville;

	@OneToOne
	@JoinColumn(name = "chefAgence_id", nullable = false)
	@JsonIgnore
	private ChefAgence chefAgence;

	@OneToMany(mappedBy = "agence")
	private List<Heros> heros = new ArrayList<>();

	@OneToMany(mappedBy = "agence")
	private List<Mission> missions = new ArrayList<>();

	public Agence() {
	}

	public Agence(double budget, int popularite, String ville, ChefAgence chefAgence)
		 {
		this.budget = budget;
		this.popularite = popularite;
		this.ville = ville;
		this.chefAgence = chefAgence;

	}

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

	public ChefAgence getChefAgence() {
		return chefAgence;
	}

	public void setChefAgence(ChefAgence chefAgence) {
		this.chefAgence = chefAgence;
	}

	public List<Heros> getHeros() {
		return heros;
	}

	public void setHeros(List<Heros> heros) {
		this.heros = heros;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double payerSalaires() {
		double total = 0;
		for (Heros h : heros) {
			total += h.getSalaire();
		}
		return total;
	}

	public void recruterHeros(Heros heros) {
		if (!this.heros.contains(heros)) {
			this.heros.add(heros);
			heros.setAgence(this);
		}
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", budget=" + budget + ", popularite=" + popularite + "]";
	}

}
