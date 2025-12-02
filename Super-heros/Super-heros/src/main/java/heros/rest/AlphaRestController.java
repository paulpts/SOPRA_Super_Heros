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

import heros.model.Alpha;
import heros.model.Heros;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/alpha")
public class AlphaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<Alpha> allAlpha() {
        return herosService.getAllAlpha();
    }

    @GetMapping("/{id}")
    public Alpha ficheAlpha(@PathVariable Integer id) {  // J'ai du mal à capter le ResponseEntity j'ai repris pour exemple celui de MatiereRestController
    
    	return herosService.getAlphaById(id);
    }
    
    @PostMapping
    public Alpha ajouterAlpha(@RequestBody Heros heros) {
        return (Alpha) herosService.create(heros);
    }

    @PutMapping("/{id}")
    public Alpha modifierAlpha(@PathVariable Integer id, @RequestBody Heros heros) {
        return (Alpha) herosService.update(heros);
    }

    @DeleteMapping("/{id}")
    public void supprimerAlpha(@PathVariable Integer id) {
        herosService.deleteById(id);
    }
    
    @GetMapping("/alias/{alias}") //Permet de recuperer heros par son alias
    public Alpha getHerosByAlias(@PathVariable String alias) {
        return (Alpha) herosService.getByAlias(alias);
    }
    
    @GetMapping("/agence/{agenceId}") // Permet de recuperer les heros par agence selon l'ID
    public List<Alpha> getAlphaByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getAlphaByAgenceId(agenceId);
    }

}
