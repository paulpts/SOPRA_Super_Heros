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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heros.model.Admin;
import heros.service.CompteService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<Admin> allChefAgence() {
        return compteService.getAllAdmin();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> ficheChefAgence(@PathVariable Integer id) {
        Admin a = (Admin) compteService.getById(id);

        if(a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(a);
    }

    @PostMapping
    public Admin ajouterAdmin(@RequestBody Admin admin) {
        return (Admin)compteService.create(admin);
    }

    @PutMapping("/{id}")
    public Admin modifierAdmin(@PathVariable Integer id,@RequestBody Admin admin) {
        admin.setId(id);
        return (Admin) compteService.update(admin);
    }

    @DeleteMapping("/{id}")
    public void supprimerAdmin(@PathVariable Integer id) {
    	compteService.deleteById(id);
    }   
}
    

