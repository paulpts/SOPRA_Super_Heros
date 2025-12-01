package heros.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import heros.model.Compte;

public interface CompteRepository extends JpaRepository<Compte,Integer> {
    
}
