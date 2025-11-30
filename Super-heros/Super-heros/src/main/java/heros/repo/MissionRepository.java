package heros.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import heros.model.Mission;

public interface MissionRepository extends JpaRepository<Mission,Integer> {
    
}
