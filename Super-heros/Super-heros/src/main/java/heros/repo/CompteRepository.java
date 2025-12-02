package heros.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import heros.model.Admin;
import heros.model.ChefAgence;
import heros.model.Compte;

public interface CompteRepository extends JpaRepository<Compte,Integer> {
 
	@Query("from Admin")
	public List<Admin> findAllAdmin(); //génère seulement la liste des admins
	
	@Query("from ChefAgence")
	public List<ChefAgence> findAllChefAgence(); //génère seulement la liste des chefs d'agence
}
