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

import heros.model.Compte;
import heros.service.CompteService;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {

    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<Compte> allComptes() {
        return compteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> ficheCompte(@PathVariable Integer id) {
        Compte c  = compteService.getById(id);

        if(c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public Compte ajouterCompte(@RequestBody Compte compte) {
        return compteService.create(compte);
    }

    @PutMapping("/{id}")
    public Compte modifierCompte(@PathVariable Integer id,@RequestBody Compte compte) {
        compte.setId(id); //pour pas modifier n'importe quel compte
        return compteService.update(compte);
    }

    @DeleteMapping("/{id}")
    public void supprimerCompte(@PathVariable Integer id) {
        compteService.deleteById(id);
    }
}
