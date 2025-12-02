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

import heros.dto.response.MissionResponse;
import heros.model.Mission;
import heros.service.MissionService;


@RestController
@RequestMapping("/api/mission")
public class MissionRestController {

    @Autowired
    private MissionService missionService;

    @GetMapping
    public List<MissionResponse> allMissions() {
    	return missionService.getAllMission().stream().map(MissionResponse::convert).toList();
    }

    @GetMapping("/{id}")
    public MissionResponse ficheMission(@PathVariable Integer id) {  // J'ai du mal à capter le ResponseEntity j'ai repris pour exemple celui de MatiereRestController
        Mission m = (Mission) missionService.getById(id);
        return MissionResponse.convert(m);
    }

    @PostMapping
    public Mission ajouterMission(@RequestBody Mission mission) {
        return  missionService.create(mission);
    }

    @PutMapping("/{id}")
    public Mission modifierMission(@PathVariable Integer id,@RequestBody Mission mission) {
        return missionService.update(mission);
    }

    @DeleteMapping("/{id}")
    public void supprimerMission(@PathVariable Integer id) {
        missionService.deleteById(id);
    }    
    
}
