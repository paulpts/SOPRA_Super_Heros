package heros.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heros.dto.response.OmegaResponse;

@RestController
@RequestMapping("/api/heros")
public class HerosRestController {
    
    @GetMapping
    public List<OmegaResponse> allOmega() {
        return herosService.getAllOmega().stream().map(OmegaResponse::convert).toList();
    }


}
