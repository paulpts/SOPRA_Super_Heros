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

import heros.model.Agence;
import heros.service.AgenceService;


@RestController
@RequestMapping("/api/agence")
public class AgenceRestController {

    @Autowired
    private AgenceService agenceService;

    @GetMapping
    public List<Agence> allAgences() {
        return agenceService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> ficheAgence(@PathVariable Integer id) {  // J'ai du mal à capter le ResponseEntity j'ai repris pour exemple celui de MatiereRestController
        Agence a = agenceService.getById(id);

        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(a);
    }
    
    @PostMapping
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @PutMapping("/{id}")
    public Agence modifierAgence(@PathVariable Integer id, @RequestBody Agence agence) {
        return agenceService.update(agence);
    }
    

    @DeleteMapping("/{id}")
    public void supprimerAgence(@PathVariable Integer id){
        agenceService.deleteById(id);
    }

    @GetMapping("/chef/{chefId}")
    public Agence getAgenceByChef(@PathVariable Integer chefId) {
        return agenceService.getChefAgenceById(chefId);
    }     
}
