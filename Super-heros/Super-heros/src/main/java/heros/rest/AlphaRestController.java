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
import heros.dto.response.AlphaResponse;
import heros.dto.response.OmegaResponse;
import heros.model.Alpha;
import heros.model.Omega;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/alpha")
public class AlphaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<AlphaResponse> allAlpha() {
        return herosService.getAllAlpha().stream().map(AlphaResponse::convert).toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<AlphaResponse> ficheAlpha(@PathVariable Integer id) {
        Alpha alpha = (Alpha) herosService.getAlphaById(id);
        if (alpha == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AlphaResponse.convert(alpha));
    }

    @PostMapping
    public AlphaResponse ajouterAlpha(@RequestBody CreateUpdateHerosRequest request) {
        return AlphaResponse.convert((Alpha) herosService.createAlpha(request));
    }

    @PutMapping("/{id}")
    public AlphaResponse modifierAlpha(@PathVariable Integer id, @RequestBody CreateUpdateHerosRequest request) {
        return AlphaResponse.convert((Alpha) herosService.updateAlpha(id, request));
    }

    @DeleteMapping("/{id}")
    public void supprimerAlpha(@PathVariable Integer id) {
        herosService.deleteById(id);
    }

    @GetMapping("/alias/{alias}")
    public AlphaResponse getHerosByAlias(@PathVariable String alias) {
        return AlphaResponse.convert((Alpha) herosService.getByAlias(alias));
    }

    @GetMapping("/agence/{agenceId}")
    public List<AlphaResponse> getAlphaByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getAlphaByAgenceId(agenceId).stream().map(AlphaResponse::convert).toList();
    }
}
