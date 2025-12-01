package heros.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import heros.model.ChefAgence;

public interface ChefAgenceRepository extends JpaRepository<ChefAgence,Integer> {
  
} 
