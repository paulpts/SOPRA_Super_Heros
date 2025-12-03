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
import heros.dto.response.BetaResponse;
import heros.model.Beta;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/beta")
public class BetaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<BetaResponse> allBeta() {
        return herosService.getAllBeta().stream().map(BetaResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BetaResponse> ficheBeta(@PathVariable Integer id) {
        Beta beta = (Beta) herosService.getById(id);
        if (beta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(BetaResponse.convert(beta));
    }

    @PostMapping
    public BetaResponse ajouterBeta(@RequestBody CreateUpdateHerosRequest request) {
        return BetaResponse.convert((Beta) herosService.createBeta(request));
    }

    @PutMapping("/{id}")
    public BetaResponse modifierBeta(@PathVariable Integer id, @RequestBody CreateUpdateHerosRequest request) {
        return BetaResponse.convert((Beta) herosService.updateBeta(id, request));
    }

    @DeleteMapping("/{id}")
    public void supprimerBeta(@PathVariable Integer id) {
        herosService.deleteById(id);
    }

    @GetMapping("/alias/{alias}")
    public BetaResponse getHerosByAlias(@PathVariable String alias) {
        return BetaResponse.convert((Beta) herosService.getByAlias(alias));
    }

    @GetMapping("/agence/{agenceId}")
    public List<BetaResponse> getBetaByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getBetaByAgenceId(agenceId).stream().map(BetaResponse::convert).toList();
    }
}