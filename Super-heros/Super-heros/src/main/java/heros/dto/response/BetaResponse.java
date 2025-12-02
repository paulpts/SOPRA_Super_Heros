package heros.dto.response;

import heros.model.Beta;

public class BetaResponse {
    private String nom;
    private String prenom;
    private String alias;
    private int popularite;
    private int sante;
    private double salaire;
    private double degats;
    private int experience;
    private int motivation;
    private Integer agenceId;

    public BetaResponse() {
    }

    public BetaResponse(String nom, String prenom, String alias, int popularite, int sante, double salaire,
                         double degats, int experience, int motivation, Integer agenceId) {
        this.nom = nom;
        this.prenom = prenom;
        this.alias = alias;
        this.popularite = popularite;
        this.sante = sante;
        this.salaire = salaire;
        this.degats = degats;
        this.experience = experience;
        this.motivation = motivation;
        this.agenceId = agenceId;
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

    public double getDegats() {
         return degats; 
    }

    public void setDegats(double degats) {
         this.degats = degats; 
    }

    public int getExperience() {
         return experience; 
    }

    public void setExperience(int experience) {
         this.experience = experience; 
    }

    public int getMotivation() {
         return motivation; 
    }

    public void setMotivation(int motivation) {
         this.motivation = motivation; 
    }

    public Integer getAgenceId() {
         return agenceId; 
    }

    public void setAgenceId(Integer agenceId) {
         this.agenceId = agenceId; 
    }

    public static BetaResponse convert(Beta beta) {
        BetaResponse response = new BetaResponse();

        response.setNom(beta.getNom());
        response.setPrenom(beta.getPrenom());
        response.setAlias(beta.getAlias());
        response.setPopularite(beta.getPopularite());
        response.setSante(beta.getSante());
        response.setSalaire(beta.getSalaire());
        response.setDegats(beta.getDegats());
        response.setExperience(beta.getExperience());
        response.setMotivation(beta.getMotivation());
        if (beta.getAgence() != null) {
        response.setAgenceId(beta.getAgence().getId());
        } else {
        response.setAgenceId(null);
        }

    
        return response;

    }

    

}