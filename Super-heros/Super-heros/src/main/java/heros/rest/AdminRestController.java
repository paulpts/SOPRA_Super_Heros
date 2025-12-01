package heros.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import heros.model.Admin;
import heros.service.AdminService;

public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> allChefAgence() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> ficheChefAgence(@PathVariable Integer id) {
        Admin a = adminService.getById(id);

        if(a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(a);
    }

    @PostMapping
    public Admin ajouterAdmin(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @PutMapping("/{id}")
    public Admin modifierAdmin(@PathVariable Integer id,@RequestBody Admin admin) {
        admin.setId(id);
        return adminService.update(admin);
    }

    @DeleteMapping("/{id}")
    public void supprimerAdmin(@PathVariable Integer id) {
        adminService.deleteById(id);
    } 
    
}
    

