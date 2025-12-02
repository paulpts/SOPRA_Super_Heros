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

import heros.model.Beta;
import heros.model.Heros;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/beta")
public class BetaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<Beta> allBeta() {
        return herosService.getAllBeta();
    }

    @GetMapping("/{id}")
    public Beta ficheBeta(@PathVariable Integer id) {  // J'ai du mal à capter le ResponseEntity j'ai repris pour exemple celui de MatiereRestController
    
    	return herosService.getBetaById(id);
    }
    
    @PostMapping
    public Beta ajouterBeta(@RequestBody Heros heros) {
        return (Beta) herosService.create(heros);
    }

    @PutMapping("/{id}")
    public Beta modifierBeta(@PathVariable Integer id, @RequestBody Heros heros) {
        return (Beta) herosService.update(heros);
    }

    @DeleteMapping("/{id}")
    public void supprimerBeta(@PathVariable Integer id) {
        herosService.deleteById(id);
    }
    
    @GetMapping("/alias/{alias}") //Permet de recuperer heros par son alias
    public Beta getHerosByAlias(@PathVariable String alias) {
        return (Beta) herosService.getByAlias(alias);
    }
    
    @GetMapping("/agence/{agenceId}") // Permet de recuperer les heros par agence selon l'ID
    public List<Beta> getBetaByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getBetaByAgenceId(agenceId);
    }
}
