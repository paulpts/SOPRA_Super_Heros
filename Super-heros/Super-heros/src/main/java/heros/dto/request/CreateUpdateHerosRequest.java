package heros.dto.request;

import java.util.List;

import heros.enumerator.Pouvoirs;

public class CreateUpdateHerosRequest {
    
    private String nom;
    private String prenom;
    private String alias;
    private int popularite;
    private int sante;
    private double salaire;
    private int experience;
    private double degats;
    private int motivation;
    private List<Pouvoirs> pouvoirs;
    
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
    public List<Pouvoirs> getPouvoirs() {
        return pouvoirs;
    }
    public void setPouvoirs(List<Pouvoirs> pouvoirs) {
        this.pouvoirs = pouvoirs;
    }


    


}
