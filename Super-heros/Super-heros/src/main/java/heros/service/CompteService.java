package heros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.Admin;
import heros.model.Agence;
import heros.model.ChefAgence;
import heros.model.Compte;
import heros.repo.AgenceRepository;
import heros.repo.CompteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private AgenceRepository agenceRepository;

    public Compte getById(Integer id) {
        if (id == null) {
            throw new RuntimeException("L'id du compte ne peut pas être null");
        }
        return compteRepository.findById(id).orElse(null);
    }

    public List<Compte> getAll() {
        return compteRepository.findAll();
    }

    // public Compte create(Compte compte) {
    // return compteRepository.save(compte);
    // }

    public Compte create(ChefAgence chefAgence) {
        if (chefAgence.getId() != null) {
            throw new IllegalArgumentException("Le compte ne doit pas avoir d'id !");
        }
        return compteRepository.save(chefAgence);
    }

    // public Compte update(Compte compte) {
    // return compteRepository.save(compte); //Ca permet de renvoyer l'objet qui est
    // mis à jour
    // }

    public Compte update(Integer id, Compte compte) {
        Compte updateCompte = compteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compte inexistant"));
        updateCompte.setLogin(compte.getLogin());
        updateCompte.setPassword(compte.getPassword());
        return compteRepository.save(updateCompte); // Ca permet de renvoyer l'objet qui est mis à jour
    }

    public void deleteById(Integer id) { // DELETE FROM heros WHERE id=?
        compteRepository.deleteById(id);
    }

    public void deleteCompte(Compte compte) {
        compteRepository.delete(compte);
    }

    public List<Admin> getAllAdmin() {
        return compteRepository.findAllAdmin();
    }

    public List<ChefAgence> getAllChefAgence() {
        return compteRepository.findAllChefAgence();
    }

    public Admin getAdminById(Integer id) {
        Optional<Compte> opt = compteRepository.findById(id);
        if (opt.isEmpty()) {
            return null;
        } else {
            return (Admin) opt.get();
        }
    }

    public ChefAgence getChefAgenceById(Integer id) {
        Optional<Compte> opt = compteRepository.findById(id);
        if (opt.isEmpty()) {
            return null;
        } else {
            return (ChefAgence) opt.get();
        }
    }
}
