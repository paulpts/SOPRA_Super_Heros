package heros.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import heros.model.Alpha;
import heros.model.Beta;
import heros.model.Heros;
import heros.model.Omega;


public interface HerosRepository extends JpaRepository<Heros, Integer> {  //Integer car c'est le type de l'ID pour Heros, JPARepo recupere le CRUD AUTOMATIQUE

    List<Heros> findByAgence_Id(Integer agenceId); //Va générer la requête SELECT * FROM heros WHERE agence_id = ?

    Heros findByAlias(String alias); // Va générer la requête SELECT * FROM heros WHERE alias = ?
    

	@Query("from Omega")
	public List<Omega> findAllOmega(); //génère seulement la liste des Omégas
	
	
	@Query("from Beta")
	public List<Beta> findAllBeta(); //génère seulement la liste des Betas
	
	@Query("from Alpha")
	public List<Alpha> findAllAlpha(); //génère seulement la liste des Alpha

	
    
}