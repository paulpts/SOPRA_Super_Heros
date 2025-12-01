package heros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.ChefAgence;
import heros.repo.ChefAgenceRepository;

@Service
public class ChefAgenceService {

        @Autowired
    private ChefAgenceRepository chefagenceRepository;


    public List<ChefAgence> getAll() {
        return chefagenceRepository.findAll();    
    }

    public ChefAgence getById(Integer id) {
        if(id==null) {
            throw new RuntimeException("L'id du chef de l'agence ne peut pas être null");
        }
    return chefagenceRepository.findById(id).orElse(null);
    }

    public ChefAgence create(ChefAgence chefAgence) {
        return chefagenceRepository.save(chefAgence);
    }

    public ChefAgence update(ChefAgence ChefAgence) {
        return chefagenceRepository.save(ChefAgence); 
    }
    
    public void deleteById(Integer id) { 
        chefagenceRepository.deleteById(id);
    }

    public void deleteAgence(ChefAgence chefAgence) { 
        chefagenceRepository.delete(chefAgence);
    }
    
}
