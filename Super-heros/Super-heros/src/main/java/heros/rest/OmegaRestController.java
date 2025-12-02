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

import heros.dto.response.OmegaResponse;
import heros.model.Omega;
import heros.service.HerosService;


@RestController
@RequestMapping("/api/omega")
public class OmegaRestController {

    @Autowired
    private HerosService herosService;

    @GetMapping
    public List<OmegaResponse> allOmega() {
        return herosService.getAllOmega().stream().map(OmegaResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public OmegaResponse ficheOmega(@PathVariable Integer id) {
        return OmegaResponse.convert((Omega) herosService.getById(id));
    }

    @PostMapping
    public OmegaResponse ajouterOmega(@RequestBody Omega omega) {
        return OmegaResponse.convert((Omega) herosService.create(omega));
    }

    @PutMapping("/{id}")
    public OmegaResponse modifierOmega(@PathVariable Integer id, @RequestBody Omega omega) {
        omega.setId(id);
        return OmegaResponse.convert((Omega) herosService.update(omega));
    }

    @DeleteMapping("/{id}")
    public void supprimerOmega(@PathVariable Integer id) {
        herosService.deleteById(id);
    }

    @GetMapping("/alias/{alias}")
    public OmegaResponse getHerosByAlias(@PathVariable String alias) {
        return OmegaResponse.convert((Omega) herosService.getByAlias(alias));
    }

    @GetMapping("/agence/{agenceId}")
    public List<OmegaResponse> getOmegaByAgenceId(@PathVariable Integer agenceId) {
        return herosService.getOmegaByAgenceId(agenceId).stream().map(OmegaResponse::convert).toList();
    }
}
