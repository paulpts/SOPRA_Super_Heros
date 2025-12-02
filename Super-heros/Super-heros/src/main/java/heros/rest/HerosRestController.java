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
import heros.model.Heros;
import heros.service.AgenceService;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/heros")
public class HerosRestController {

    @Autowired
    private HerosService herosService;
    @Autowired
    private AgenceService agenceService;

    @GetMapping
    public List<Heros> allHeros() {
        return herosService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Heros> ficheHeros(@PathVariable Integer id) {  // J'ai du mal à capter le ResponseEntity j'ai repris pour exemple celui de MatiereRestController
        Heros h = herosService.getById(id);

        if (h == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(h);
    }
    
   @PostMapping
public Heros ajouterHeros(@RequestBody Heros heros) {
    // Récupérer l'agence complète depuis la base
    Agence agence = agenceService.getById(heros.getAgence().getId());
    heros.setAgence(agence); // Remplacer l'objet partiel par l'objet complet

    return herosService.create(heros);
}


    @PutMapping("/{id}")
    public Heros modifierHeros(@PathVariable Integer id, @RequestBody Heros heros) {
        return herosService.update(heros);
    }

    @DeleteMapping("/{id}")
    public void supprimerHeros(@PathVariable Integer id) {
        herosService.deleteById(id);
    }

    @GetMapping("/agence/{agenceId}") // Permet de recuperer les heros par agence selon l'ID
    public List<Heros> getHerosByAgence(@PathVariable Integer agenceId) {
        return herosService.getAllAgenceId(agenceId);
    }

    @GetMapping("/alias/{alias}") //Permet de recuperer heros par son alias
    public Heros getHerosByAlias(@PathVariable String alias) {
        return herosService.getByAlias(alias);
    }


    
}
