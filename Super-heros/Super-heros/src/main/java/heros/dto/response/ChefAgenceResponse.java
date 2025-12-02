package heros.dto.response;

import heros.model.ChefAgence;

public class ChefAgenceResponse {

    private Integer id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private int agenceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(int agenceId) {
        this.agenceId = agenceId;
    }

    public static ChefAgenceResponse convert(ChefAgence chefAgence) {
        ChefAgenceResponse response = new ChefAgenceResponse();

        response.setId(chefAgence.getId());
        response.setLogin(chefAgence.getLogin());
        response.setPassword(chefAgence.getPassword());
        response.setNom(chefAgence.getNom());
        response.setPrenom(chefAgence.getPrenom());

        if (chefAgence.getAgence() != null) {
            response.setAgenceId(chefAgence.getAgence().getId());
        }

        return response;
    }

}
