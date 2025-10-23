package projet_super_heros.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


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
	    @OneToOne
	    private ChefAgence chefAgence;
	    
	    @Column(nullable = false)
	    @OneToMany(mappedBy="agence")
	    private List<Heros> heros = new ArrayList();
	    
	    
	    @OneToMany(mappedBy="agence")
	    private List<Mission> missions = new ArrayList();

	   
	    public Agence() {}

	    public Agence(double budget, int popularite) {
	        this.budget = budget;
	        this.popularite = popularite;
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

		@Override
		public String toString() {
			return "Agence [id=" + id + ", budget=" + budget + ", popularite=" + popularite + "]";
		}

	
	}

	
	
	
	
	
	
	

