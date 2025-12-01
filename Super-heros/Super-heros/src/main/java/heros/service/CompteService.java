package heros.service;

import java.util.List;
import heros.repo.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.Compte;

@Service
public class CompteService {


    @Autowired
    private CompteRepository compteRepository;

    public Compte getById(Integer id) {
        if(id==null) {
            throw new RuntimeException("L'id du compte ne peut pas être null");
        }
    return compteRepository.findById(id).orElse(null);
    }



    public List<Compte> getAll() {
        return compteRepository.findAll();    
    }

    public Compte create(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte update(Compte compte) {
        return compteRepository.save(compte); //Ca permet de renvoyer l'objet qui est mis à jour
    }
    
    public void deleteById(Integer id) { // DELETE FROM heros WHERE id=?
        compteRepository.deleteById(id);
    }

    public void deleteHeros(Compte compte) { //J'ai mis aussi un DELETE pour l'object Heros mais pas sur que ca nous serve vu qu'on a deja DeleteById
        compteRepository.delete(compte);
    }
    
}
