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

import heros.dto.response.ChefAgenceResponse;
import heros.model.ChefAgence;
import heros.service.CompteService;

@RestController
@RequestMapping("api/chefagence")
public class ChefAgenceRestController {

    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<ChefAgenceResponse> allChefAgence() {
        return compteService.getAllChefAgence().stream().map(ChefAgenceResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public ChefAgenceResponse ficheChefAgence(@PathVariable Integer id) {
        ChefAgence ca = (ChefAgence) compteService.getById(id);
        return ChefAgenceResponse.convert(ca);
    }

    @PostMapping
    public ChefAgence ajouterChefAgence(@RequestBody ChefAgence chefAgence) {
        return (ChefAgence) compteService.create(chefAgence);
    }

    @PutMapping("/{id}")
    public ChefAgence modifierChefAgence(@PathVariable Integer id, @RequestBody ChefAgence chefAgence) {
        chefAgence.setId(id);
        return (ChefAgence) compteService.update(id,chefAgence);
    }

    @DeleteMapping("/{id}")
    public void supprimerChefAgence(@PathVariable Integer id) {
        compteService.deleteById(id);
    }

}
