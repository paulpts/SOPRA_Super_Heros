package heros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.dto.request.CreateMissionRequest;

import heros.model.Mission;
import heros.repo.MissionRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MissionService {
    
    @Autowired
    private MissionRepository missionRepository;
    
    @Autowired
    AgenceService agenceSrv;
  
    @Autowired
    HerosService herosSrv;

    public Mission getById(Integer id) {
        if(id==null) {
            throw new RuntimeException("L'id de la mission ne peut pas être null");
        }
    return missionRepository.findById(id).orElse(null);
    }


    public List<Mission> getAllMission() {
        return missionRepository.findAll();
    }


    public Mission create(Mission mission, CreateMissionRequest missionRequest) {
    	       
    	    mission.setDescription(missionRequest.getDescription());
    	    mission.setCreditMission(missionRequest.getCreditMission());
    	    mission.setDifficulte(missionRequest.getDifficulte());
    	    mission.setNiveauDanger(missionRequest.getNiveauDanger());
    	    mission.setStatut(missionRequest.getStatut());
    	    mission.setVille(missionRequest.getVille());

            return missionRepository.save(mission);
    
    }

    public Mission update(Integer id, CreateMissionRequest request) {
        Mission updateMission = missionRepository.findById(id)
        		  .orElseThrow(() -> new EntityNotFoundException("Mission inexistante"));
        updateMission.setDescription(request.getDescription());
        updateMission.setCreditMission(request.getCreditMission());
        updateMission.setDifficulte(request.getDifficulte());
        updateMission.setNiveauDanger(request.getNiveauDanger());
        updateMission.setStatut(request.getStatut());
        updateMission.setVille(request.getVille());
        return missionRepository.save(updateMission);
        
    }


    public void deleteById(Integer id) {
        missionRepository.deleteById(id);
    }

    public void deleteMission(Mission mission) {
        missionRepository.delete(mission);
    }
}
