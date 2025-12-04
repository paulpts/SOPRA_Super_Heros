package heros.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heros.dto.request.CreateAgenceRequest;
import heros.dto.response.AgenceResponse;
import heros.model.Agence;
import heros.service.AgenceService;

@RestController
@RequestMapping("/api/agence")
public class AgenceRestController {

    @Autowired
    private AgenceService agenceService;

    @GetMapping
    public List<AgenceResponse> allAgences() {
        return agenceService.getAllAgence().stream().map(AgenceResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public AgenceResponse ficheAgence(@PathVariable Integer id) { 
        Agence a = (Agence) agenceService.getById(id);
        return AgenceResponse.convert(a);
    }

    @PostMapping
    public AgenceResponse ajouterAgence(@RequestBody CreateAgenceRequest request) {
        return AgenceResponse.convert(agenceService.create(new Agence(), request));
    }

    @PutMapping("/{id}")
    public AgenceResponse modifierAgence(@PathVariable Integer id, @RequestBody CreateAgenceRequest request) {
    	return AgenceResponse.convert(agenceService.update(id, request));
    }

    /* Utilité de pouvoir supprimer une agence ? 
    @DeleteMapping("/{id}")
    public void supprimerAgence(@PathVariable Integer id) {
        agenceService.deleteById(id);
    }*/

    @GetMapping("/chef/{chefId}")
    public Agence getAgenceByChef(@PathVariable Integer chefId) {
        return agenceService.getChefAgenceById(chefId);
    }
}
