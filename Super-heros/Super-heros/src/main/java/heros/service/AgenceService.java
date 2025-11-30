package heros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.Agence;
import heros.repo.AgenceRepository;


//Globalement la même chose que HerosService, plus d'explication en commentaire la bas
@Service
public class AgenceService {
    
    @Autowired
    private AgenceRepository agenceRepository;

    public Agence getById(Integer id) {
        if(id==null) {
            throw new RuntimeException("L'id d'une agence ne peut pas être null");
        }
    return agenceRepository.findById(id).orElse(null);
    }

    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }

    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    public Agence update(Agence agence) {
        return agenceRepository.save(agence);
    } 


    public void deleteById(Integer id) {
        agenceRepository.deleteById(id);
    }

    public void deleteAgence(Agence agence) {
        agenceRepository.delete(agence);
    }

    public Agence getChefAgenceById(Integer chefId) {  // Methode rajouté pour recuperer un chef d'agence grâce à son ID
        return agenceRepository.findByChefAgence_Id(chefId);
    }

}
