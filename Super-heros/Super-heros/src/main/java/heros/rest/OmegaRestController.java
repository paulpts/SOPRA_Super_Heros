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

import heros.dto.request.CreateUpdateHerosRequest;
import heros.dto.response.HerosResponse;
import heros.dto.response.OmegaResponse;
import heros.model.Omega;
import heros.service.HerosService;

@RestController
@RequestMapping("/api/omega")
public class OmegaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<HerosResponse> allOmega() {
        return herosService.getAllOmega().stream().map(HerosResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerosResponse> ficheOmega(@PathVariable Integer id) {
        Omega omega = (Omega) herosService.getOmegaById(id);
        if (omega == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(HerosResponse.convert(omega));
    }

    @PostMapping
    public HerosResponse ajouterOmega(@RequestBody CreateUpdateHerosRequest request) {
        return HerosResponse.convert((Omega) herosService.createOmega(request));
    }

    @PutMapping("/{id}")
    public HerosResponse modifierOmega(@PathVariable Integer id, @RequestBody CreateUpdateHerosRequest request) {
        return HerosResponse.convert((Omega) herosService.updateHeros(id, request));
    }

    @DeleteMapping("/{id}")
    public void supprimerOmega(@PathVariable Integer id) {
        herosService.deleteById(id);
    }

    @GetMapping("/alias/{alias}")
    public HerosResponse getHerosByAlias(@PathVariable String alias) {
        return HerosResponse.convert((Omega) herosService.getByAlias(alias));
    }

    @GetMapping("/agence/{agenceId}")
    public List<OmegaResponse> getOmegaByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getOmegaByAgenceId(agenceId).stream().map(OmegaResponse::convert).toList();
    }
}
