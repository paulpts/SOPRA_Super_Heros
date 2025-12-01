package heros.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import heros.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    
}
