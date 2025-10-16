package projet_super_heros.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "sequence_heros",sequenceName = "heros_id_bdd")
public abstract class Heros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_heros")
	@Column(name="identifiant")
	protected Integer id;
	@Column (length=25, nullable=false)
	protected String nom;
	@Column (length=25, nullable=false)
	protected String prenom;
	@Column (length=30, nullable=false, unique=true)
	protected String alias;
	protected int popularite;
	protected int sante;
	@Column(nullable=false)
	protected double salaire;
	@Column(nullable=false)
	protected double coutCreation;
	protected int experience;
	protected double degats;
	protected int motivation;
	@ManyToOne
	@JoinColumn(nullable=false)
	protected Agence agence;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,columnDefinition = "enum('', '', '')")
	protected List <Genre> pouvoirs= new ArrayList();
	
	
	public Heros() {
	}

	public Heros(Integer id, String nom, String prenom, String alias, int popularite, int sante, double salaire,
			double coutCreation, int experience, double degats, int motivation, Agence agence) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.alias = alias;
		this.popularite = popularite;
		this.sante = sante;
		this.salaire = salaire;
		this.coutCreation = coutCreation;
		this.experience = experience;
		this.degats = degats;
		this.motivation = motivation;
		this.agence=agence;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getPopularite() {
		return popularite;
	}

	public void setPopularite(int popularite) {
		this.popularite = popularite;
	}

	public int getSante() {
		return sante;
	}

	public void setSante(int sante) {
		this.sante = sante;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public double getCoutCreation() {
		return coutCreation;
	}

	public void setCoutCreation(double coutCreation) {
		this.coutCreation = coutCreation;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public double getDegats() {
		return degats;
	}

	public void setDegats(double degats) {
		this.degats = degats;
	}

	public int getMotivation() {
		return motivation;
	}

	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}

	protected void affecterHeros()
	{
		
	}
	
	protected void payerSalaier()
	{
		
	}
	
	public String toString() {
		return "Heros [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", alias=" + alias + ", popularite="
				+ popularite + ", sante=" + sante + ", salaire=" + salaire + ", coutCreation=" + coutCreation
				+ ", experience=" + experience + ", degats=" + degats + ", motivation=" + motivation + "]";
	}
	
	
	
	

}
