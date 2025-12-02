package heros.dto.response;

import heros.model.Alpha;

public class AlphaResponse {
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

    public AlphaResponse() {
    }

    public AlphaResponse(String nom, String prenom, String alias, int popularite, int sante, double salaire,
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

    public static AlphaResponse convert(Alpha alpha) {
        AlphaResponse response = new AlphaResponse();

        response.setNom(alpha.getNom());
        response.setPrenom(alpha.getPrenom());
        response.setAlias(alpha.getAlias());
        response.setPopularite(alpha.getPopularite());
        response.setSante(alpha.getSante());
        response.setSalaire(alpha.getSalaire());
        response.setDegats(alpha.getDegats());
        response.setExperience(alpha.getExperience());
        response.setMotivation(alpha.getMotivation());
        if (alpha.getAgence() != null) {
        response.setAgenceId(alpha.getAgence().getId());
        } else {
        response.setAgenceId(null);
        }

    
        return response;

    }

    

}
