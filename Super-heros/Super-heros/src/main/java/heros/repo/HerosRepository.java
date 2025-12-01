package heros.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import heros.model.Heros;
import java.util.List;


public interface HerosRepository extends JpaRepository<Heros, Integer> {  //Integer car c'est le type de l'ID pour Heros, JPARepo recupere le CRUD AUTOMATIQUE

    List<Heros> findByAgence_Id(Integer agenceId); //Va générer la requête SELECT * FROM heros WHERE agence_id = ?

    Heros findByAlias(String alias); // Va générer la requête SELECT * FROM heros WHERE alias = ?


    
}