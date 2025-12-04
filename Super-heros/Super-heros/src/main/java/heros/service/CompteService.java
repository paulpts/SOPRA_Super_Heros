package heros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import heros.dto.request.CreateUpdateChefAgenceRequest;
import heros.model.Admin;
import heros.model.ChefAgence;
import heros.model.Compte;
import heros.repo.AgenceRepository;
import heros.repo.CompteRepository;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private PasswordEncoder encoder;
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



    public Compte createChefAgence(CreateUpdateChefAgenceRequest request) {
        ChefAgence chefAgence = new ChefAgence(
            request.getLogin(),
            encoder.encode(request.getPassword()),
            request.getNom(),
            request.getPrenom()
        );
        return compteRepository.save(chefAgence);
    }

   /* public Compte createAdmin(Admin admin) {
        if (admin.getId() != null) {
            throw new IllegalArgumentException("Le compte ne doit pas avoir d'id !");
        }
        return compteRepository.save(admin);
    }*/



   /* public ChefAgence updateChefAgence(Integer id, CreateUpdateChefAgenceRequest request) {
        ChefAgence updateChefAgence = (ChefAgence) compteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compte inexistant"));
        updateChefAgence.setNom(request.getNom());
        updateChefAgence.setPrenom(request.getPrenom());
        return compteRepository.save(updateChefAgence);
    }

    public void deleteById(Integer id) {
        ChefAgence chefAgence = (ChefAgence) compteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Compte inexistant"));
        Agence agence = agenceRepository.findById(chefAgence.getAgence().getId()).orElse(null);
        agence.setChefAgence(null);
        chefAgence.setAgence(null);
        compteRepository.deleteById(id);
    }

    public void deleteCompte(Compte compte) {
        compteRepository.delete(compte);
    }*/

    public Compte getByLoginAndPassword(String login, String password) {
        return compteRepository.findByLoginAndPassword(login, password);
    }

    public Compte getByLogin(String login) {
        return compteRepository.findByLogin(login).orElseThrow();
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
