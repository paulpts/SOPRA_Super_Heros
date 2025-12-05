package heros.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import heros.dto.request.CreateUpdateHerosRequest;

import heros.dto.response.HerosResponse;
import heros.model.Heros;
import heros.service.HerosService;

@RestController
@RequestMapping("/api/heros")
@CrossOrigin(origins = "http://localhost:4200")
public class HerosRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<HerosResponse> allHeros() {
        return herosService.getAll().stream().map(HerosResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerosResponse> ficheHeros(@PathVariable Integer id) {
        Heros heros = (Heros) herosService.getById(id);
        if (heros == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(HerosResponse.convert(heros));
    }


   @PutMapping("/{id}")
    public HerosResponse modifierHeros(@PathVariable Integer id, @RequestBody CreateUpdateHerosRequest request) {
        return HerosResponse.convert(herosService.updateHeros(id, request));
    }

  
    @DeleteMapping("/{id}")
    public void supprimerHeros(@PathVariable Integer id) {
        herosService.deleteById(id);
    }

    @GetMapping("/alias/{alias}")
    public HerosResponse getHerosByAlias(@PathVariable String alias) {
        return HerosResponse.convert(herosService.getByAlias(alias));
    }

    @GetMapping("/agence/{agenceId}")
    public List<HerosResponse> getHerosByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getHerosByAgenceId(agenceId).stream().map(HerosResponse::convert).toList();
    }

}
