package heros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.Mission;
import heros.repo.MissionRepository;

@Service
public class MissionService {
    
    @Autowired
    private MissionRepository missionRepository;

    public Mission getById(Integer id) {
        if(id==null) {
            throw new RuntimeException("L'id de la mission ne peut pas être null");
        }
    return missionRepository.findById(id).orElse(null);
    }


    public List<Mission> getAll() {
        return missionRepository.findAll();
    }


    public Mission create(Mission mission) {
        return missionRepository.save(mission);
    }

    public Mission update(Mission mission) {
        return missionRepository.save(mission);
    }


    public void deleteById(Integer id) {
        missionRepository.deleteById(id);
    }

    public void deleteMission(Mission mission) {
        missionRepository.delete(mission);
    }
}
