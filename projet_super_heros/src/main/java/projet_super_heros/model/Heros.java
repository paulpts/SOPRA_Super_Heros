package projet_super_heros.model;

public abstract class Heros {
	
	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String alias;
	protected int popularite;
	protected int sante;
	protected double salaire;
	protected double coutCreation;
	protected int experience;
	protected double degats;
	protected int motivation;
	
	public Heros(Integer id, String nom, String prenom, String alias, int popularite, int sante, double salaire,
			double coutCreation, int experience, double degats, int motivation) {
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
