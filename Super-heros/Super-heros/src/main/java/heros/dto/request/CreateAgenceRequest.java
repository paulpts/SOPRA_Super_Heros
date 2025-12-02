package heros.dto.request;

public class CreateAgenceRequest {

    private String ville;

    private double budget;

    private int popularite;

    private int chefAgenceId;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public int getChefAgenceId() {
        return chefAgenceId;
    }

    public void setChefAgenceId(int chefAgenceId) {
        this.chefAgenceId = chefAgenceId;
    }

}
