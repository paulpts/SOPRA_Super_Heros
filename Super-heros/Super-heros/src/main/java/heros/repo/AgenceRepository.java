package heros.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import heros.model.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Integer> {

    Agence findByChefAgence_Id(Integer chefId);
    
}
