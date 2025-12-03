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

import heros.dto.request.CreateMissionRequest;
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
    public MissionResponse ajouterMission(@RequestBody CreateMissionRequest request) {
    	return MissionResponse.convert(missionService.create(new Mission(), request));
    }

    @PutMapping("/{id}")
    public MissionResponse modifierMission(@PathVariable Integer id,@RequestBody CreateMissionRequest request) {
    	System.out.println(">>> MISSION CONTROLLER TRIGGERED");
        return MissionResponse.convert(missionService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public void supprimerMission(@PathVariable Integer id) {
        missionService.deleteById(id);
    }    
    
}
