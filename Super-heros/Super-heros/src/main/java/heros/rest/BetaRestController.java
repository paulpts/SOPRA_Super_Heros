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
import heros.model.Beta;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/beta")
public class BetaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<HerosResponse> allBeta() {
        return herosService.getAllBeta().stream().map(HerosResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerosResponse> ficheBeta(@PathVariable Integer id) {
        Beta beta = (Beta) herosService.getById(id);
        if (beta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(HerosResponse.convert(beta));
    }

    @PostMapping
    public HerosResponse ajouterBeta(@RequestBody CreateUpdateHerosRequest request) {
        return HerosResponse.convert((Beta) herosService.createBeta(request));
    }

    @PutMapping("/{id}")
    public HerosResponse modifierBeta(@PathVariable Integer id, @RequestBody CreateUpdateHerosRequest request) {
        return HerosResponse.convert((Beta) herosService.updateHeros(id, request));
    }

    @DeleteMapping("/{id}")
    public void supprimerBeta(@PathVariable Integer id) {
        herosService.deleteById(id);
    }

    @GetMapping("/alias/{alias}")
    public HerosResponse getHerosByAlias(@PathVariable String alias) {
        return HerosResponse.convert((Beta) herosService.getByAlias(alias));
    }

    @GetMapping("/agence/{agenceId}")
    public List<HerosResponse> getBetaByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getBetaByAgenceId(agenceId).stream().map(HerosResponse::convert).toList();
    }
}