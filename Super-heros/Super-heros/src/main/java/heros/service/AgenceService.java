package heros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.Agence;
import heros.model.ChefAgence;
import heros.repo.AgenceRepository;
import heros.repo.CompteRepository;
import jakarta.persistence.EntityNotFoundException;

//Globalement la même chose que HerosService, plus d'explication en commentaire la bas
@Service
public class AgenceService { // test

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private CompteRepository compteRepository;

    public Agence getById(Integer id) {
        if (id == null) {
            throw new RuntimeException("L'id d'une agence ne peut pas être null");
        }
        return agenceRepository.findById(id).orElse(null);
    }

    public List<Agence> getAllAgence() {
        return agenceRepository.findAll();
    }

    public Agence create(Agence agence) {
        if (agence.getId() != null) {
            throw new IllegalArgumentException("L'agence ne doit pas avoir d'id !");
        }
        ChefAgence chefAgence = agence.getChefAgence();
        chefAgence.setAgence(agence);
        compteRepository.save(chefAgence);

        return agenceRepository.save(agence);
    }

    // public Compte update(Compte compte) {
    // return compteRepository.save(compte); //Ca permet de renvoyer l'objet qui est
    // mis à jour
    // }

    public Agence update(Integer id, Agence agence) {
        Agence updateAgence = agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence inexistante"));
        updateAgence.setBudget(agence.getBudget());
        updateAgence.setPopularite(agence.getPopularite());
        updateAgence.setVille(agence.getVille());
        return agenceRepository.save(updateAgence); // Ca permet de renvoyer l'objet qui est mis à jour
    }

    public void deleteById(Integer id) {
        agenceRepository.deleteById(id);
    }

    public void deleteAgence(Agence agence) {
        agenceRepository.delete(agence);
    }

    public Agence getChefAgenceById(Integer chefId) { // Methode rajouté pour recuperer un chef d'agence grâce à son ID
        return agenceRepository.findByChefAgence_Id(chefId);
    }

}
