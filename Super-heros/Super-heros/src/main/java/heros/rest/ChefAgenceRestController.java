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

import heros.model.ChefAgence;
import heros.service.ChefAgenceService;

@RestController
@RequestMapping("api/chefagence")
public class ChefAgenceRestController {

    @Autowired
    private ChefAgenceService chefagenceService;

    @GetMapping
    public List<ChefAgence> allChefAgence() {
        return chefagenceService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChefAgence> ficheChefAgence(@PathVariable Integer id) {
        ChefAgence ca = chefagenceService.getById(id);

        if(ca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ca);
    }

    @PostMapping
    public ChefAgence ajouterChefAgence(@RequestBody ChefAgence chefAgence) {
        return chefagenceService.create(chefAgence);
    }

    @PutMapping("/{id}")
    public ChefAgence modifierChefAgence(@PathVariable Integer id,@RequestBody ChefAgence chefAgence) {
        chefAgence.setId(id);
        return chefagenceService.update(chefAgence);
    }

    @DeleteMapping("/{id}")
    public void supprimerChefAgence(@PathVariable Integer id) {
        chefagenceService.deleteById(id);
    } 
    
}
