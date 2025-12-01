package heros.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heros.model.Heros;
import heros.model.Omega;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/omega")
public class OmegaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<Omega> allOmega() {
        return herosService.getAllOmega();
    }

    @GetMapping("/{id}")
    public Omega ficheOmega(@PathVariable Integer id) {  // J'ai du mal à capter le ResponseEntity j'ai repris pour exemple celui de MatiereRestController
    
    	return herosService.getOmegaById(id);
    }
    
    @PostMapping
    public Omega ajouterOmega(@RequestBody Heros heros) {
        return (Omega) herosService.create(heros);
    }

    @PutMapping("/{id}")
    public Omega modifierOmega(@PathVariable Integer id, @RequestBody Heros heros) {
        return (Omega) herosService.update(heros);
    }

    @DeleteMapping("/{id}")
    public void supprimerOmega(@PathVariable Integer id) {
        herosService.deleteById(id);
    }
    
}
