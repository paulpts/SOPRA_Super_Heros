package heros.model;

import java.util.ArrayList;
import java.util.List;

import heros.enumerator.Pouvoirs;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_heros",columnDefinition = "ENUM('alpha','beta','omega')")
@Table(name="heros")
public abstract class Heros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(nullable=false, columnDefinition = "DECIMAL(7,2)")
	protected double salaire;
	@Column(nullable=false, columnDefinition = "DECIMAL(8,2)")
	protected double coutCreation;
	protected int experience;
	@Column(columnDefinition = "DECIMAL(7,2)")
	protected double degats;
	protected int motivation;
	@ManyToOne
	@JoinColumn(nullable=false)
	protected Agence agence;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,columnDefinition = "enum('', '', '')")
	protected List<Pouvoirs> pouvoirs= new ArrayList();
	
	
	public Heros() {
	}

	public Heros(String nom, String prenom, String alias, int popularite, int sante, double salaire,
			double coutCreation, int experience, double degats, int motivation, Agence agence) {
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

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Pouvoirs> getPouvoirs() {
		return pouvoirs;
	}

	public void setPouvoirs(List<Pouvoirs> pouvoirs) {
		this.pouvoirs = pouvoirs;
	}

	
	protected void affecterHeros()
	{
		
	}
	
	protected void payerSalaier()
	{
		
	}

	@Override
	public String toString() {
		return "Heros [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", alias=" + alias + ", popularite="
				+ popularite + ", sante=" + sante + ", salaire=" + salaire + ", coutCreation=" + coutCreation
				+ ", experience=" + experience + ", degats=" + degats + ", motivation=" + motivation + ", agence="
				+ agence + "]";
	}
	
	
	
	
	
	

}
