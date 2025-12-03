package heros.repo;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Compte> findByLogin(String login);
	
	public Compte findByLoginAndPassword(String login, String password);
}
