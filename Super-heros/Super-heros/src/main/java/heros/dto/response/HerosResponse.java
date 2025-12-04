package heros.dto.response;

import java.util.List;

import heros.enumerator.Pouvoirs;
import heros.model.Alpha;
import heros.model.Beta;
import heros.model.Heros;
import heros.model.Omega;

public class HerosResponse {
    private int id;
     private String nom;
     private String prenom;
     private String alias;
     private int popularite;
     private int sante;
     private double salaire;
     private double coutCreation;
     private double degats;
     private int experience;
     private int motivation;
     private Integer agenceId;
     private List<Pouvoirs> pouvoirs;

     public int getId() {
          return id;
     }

     public void setId(int id) {
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

     public List<Pouvoirs> getPouvoirs() {
          return pouvoirs;
     }

     public void setPouvoirs(List<Pouvoirs> pouvoirs) {
          this.pouvoirs = pouvoirs;
     }

     public static HerosResponse convert(Heros h) {

        if (h instanceof Alpha alpha){
          HerosResponse response = new HerosResponse();
          response.setId(alpha.getId());
          response.setNom(alpha.getNom());
          response.setPrenom(alpha.getPrenom());
          response.setAlias(alpha.getAlias());
          response.setPopularite(alpha.getPopularite());
          response.setSante(alpha.getSante());
          response.setSalaire(alpha.getSalaire());
          response.setCoutCreation(1_500_000);
          response.setDegats(alpha.getDegats());
          response.setExperience(alpha.getExperience());
          response.setMotivation(alpha.getMotivation());
          if (alpha.getAgence() != null) {
               response.setAgenceId(alpha.getAgence().getId());
          } else {
               response.setAgenceId(null);
          }
          response.setPouvoirs(alpha.getPouvoirs());
          return response;
        } 

        if (h instanceof Beta beta){
          HerosResponse response = new HerosResponse();
          response.setId(beta.getId());
          response.setNom(beta.getNom());
          response.setPrenom(beta.getPrenom());
          response.setAlias(beta.getAlias());
          response.setPopularite(beta.getPopularite());
          response.setSante(beta.getSante());
          response.setSalaire(beta.getSalaire());
          response.setCoutCreation(500_000);
          response.setDegats(beta.getDegats());
          response.setExperience(beta.getExperience());
          response.setMotivation(beta.getMotivation());
          if (beta.getAgence() != null) {
               response.setAgenceId(beta.getAgence().getId());
          } else {
               response.setAgenceId(null);
          }
          response.setPouvoirs(beta.getPouvoirs());
          return response;
        } 

        if (h instanceof Omega omega) {
          HerosResponse response = new HerosResponse();
          response.setId(omega.getId());
          response.setNom(omega.getNom());
          response.setPrenom(omega.getPrenom());
          response.setAlias(omega.getAlias());
          response.setPopularite(omega.getPopularite());
          response.setSante(omega.getSante());
          response.setSalaire(omega.getSalaire());
          response.setCoutCreation(3_000_000);
          response.setDegats(omega.getDegats());
          response.setExperience(omega.getExperience());
          response.setMotivation(omega.getMotivation());
          if (omega.getAgence() != null) {
               response.setAgenceId(omega.getAgence().getId());
          } else {
               response.setAgenceId(null);
          }
          response.setPouvoirs(omega.getPouvoirs());
          return response;
        }

        throw new IllegalArgumentException("Type de héros inconnu : " + h.getClass());
    }

}
