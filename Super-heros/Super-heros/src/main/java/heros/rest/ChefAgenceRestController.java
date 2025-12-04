package heros.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heros.dto.request.CreateUpdateChefAgenceRequest;
import heros.dto.response.ChefAgenceResponse;
import heros.model.ChefAgence;
import heros.service.CompteService;

@RestController
@RequestMapping("api/chefagence")
public class ChefAgenceRestController {

    @Autowired
    private CompteService compteService;

    // ok postman as admin
    // Par contre renvoie le mot de passe en hashé est-ce que c'est ok ?
    @GetMapping
    public List<ChefAgenceResponse> allChefAgence() {
        return compteService.getAllChefAgence().stream().map(ChefAgenceResponse::convert).toList();
    }

    // ok postman as admin
    @GetMapping("/{id}")
    public ChefAgenceResponse ficheChefAgence(@PathVariable Integer id) {
        ChefAgence ca = (ChefAgence) compteService.getById(id);
        return ChefAgenceResponse.convert(ca);
    }

    // ok postman as admin avec mot de passe hashé
    @PostMapping
    public ChefAgenceResponse ajouterChefAgence(@RequestBody CreateUpdateChefAgenceRequest request) {
        return ChefAgenceResponse.convert((ChefAgence) compteService.createChefAgence(request));
    }

    // ok postman as admin qui ne modifie pas le login ni le password (qui est hashé
    // en bdd)
  /*  @PutMapping("/{id}")
    public ChefAgenceResponse modifierChefAgence(@PathVariable Integer id,
            @RequestBody CreateUpdateChefAgenceRequest request) {
        return ChefAgenceResponse.convert(compteService.updateChefAgence(id, request));
    }

    // On ne peut pas supprimer de chef d'agence pour l'instant parce que ça
    // signifie que l'agence n'a plus de chef, ce qui n'est pas possible dans nos
    // choix et notre mapping
    // Je pense qu'il faudrait que côté utilisateur, dès qu'on souhaite supprimer un
    // chef d'agence, il faut proposer de le remplacer immédiatement par un autre
    // chef d'agence déjà existant
    // ça veut dire qu'en paramère de cette méthode il faudrait récupérer un autre
    // id pour gérer la modif en bdd côté back
    @DeleteMapping("/{id}")
    public void supprimerChefAgence(@PathVariable Integer id) {
        compteService.deleteById(id);
    }*/

}
