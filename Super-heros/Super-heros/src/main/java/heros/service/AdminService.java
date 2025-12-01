package heros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.Admin;
import heros.repo.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public List<Admin> getAll() {
        return adminRepository.findAll();    
    }

    public Admin getById(Integer id) {
        if(id==null) {
            throw new RuntimeException("L'id de l'admin ne peut pas être null");
        }
    return adminRepository.findById(id).orElse(null);
    }

    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin update(Admin admin) {
        return adminRepository.save(admin); 
    }
    
    public void deleteById(Integer id) { 
        adminRepository.deleteById(id);
    }

    public void deleteAdmin(Admin admin) { 
        adminRepository.delete(admin);
    }
    
}
