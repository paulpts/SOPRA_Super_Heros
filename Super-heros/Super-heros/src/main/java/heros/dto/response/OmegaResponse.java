package heros.dto.response;

import java.util.List;

import heros.enumerator.Pouvoirs;
import heros.model.Omega;

public class OmegaResponse {
     private int id;
     private String nom;
     private String prenom;
     private String alias;
     private int popularite;
     private int sante;
     private double salaire;
     private double coutCreation = 3_000_000;
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

     public static OmegaResponse convert(Omega omega) {
          OmegaResponse response = new OmegaResponse();
          response.setId(omega.getId());
          response.setNom(omega.getNom());
          response.setPrenom(omega.getPrenom());
          response.setAlias(omega.getAlias());
          response.setPopularite(omega.getPopularite());
          response.setSante(omega.getSante());
          response.setSalaire(omega.getSalaire());
          response.setCoutCreation(omega.getCoutCreation());
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

}
