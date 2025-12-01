package heros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.model.Alpha;
import heros.model.Beta;
import heros.model.Heros;
import heros.model.Omega;
import heros.repo.HerosRepository;

@Service
public class HerosService {

    @Autowired
    private HerosRepository herosRepository;

    public Heros getById(Integer id) {
        if(id==null) {
            throw new RuntimeException("L'id d'un héros ne peut pas être null");
        }
    return herosRepository.findById(id).orElse(null);
    }

    public List<Heros> getAll() {
        return herosRepository.findAll();    
    }

    public Heros create(Heros heros) {
        return herosRepository.save(heros);
    }

    public Heros update(Heros heros) {
        return herosRepository.save(heros); //Ca permet de renvoyer l'objet qui est mis à jour
    }
    
    public void deleteById(Integer id) { // DELETE FROM heros WHERE id=?
        herosRepository.deleteById(id);
    }

    public void deleteHeros(Heros heros) { //J'ai mis aussi un DELETE pour l'object Heros mais pas sur que ca nous serve vu qu'on a deja DeleteById
        herosRepository.delete(heros);
    }

    public List<Heros> getAllAgenceId(Integer agenceId) {
        return herosRepository.findByAgence_Id(agenceId);
    }

    public Heros getByAlias(String alias) {
        return herosRepository.findByAlias(alias);
    }
    
    public List<Omega> getAllOmega()
	{
		return herosRepository.findAllOmega();
	}
    
    public List<Beta> getAllBeta()
	{
		return herosRepository.findAllBeta();
	}
    
    public List<Alpha> getAllAlpha()
	{
		return herosRepository.findAllAlpha();
	}
    
	public Omega getOmegaById(Integer id)
	{
		Optional<Heros> opt = herosRepository.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return (Omega)opt.get();}
	}
	
	public Beta getBetaById(Integer id)
	{
		Optional<Heros> opt = herosRepository.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return (Beta)opt.get();}
	}
	
	public Alpha getAlphaById(Integer id)
	{
		Optional<Heros> opt = herosRepository.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return (Alpha)opt.get();}
	}


}
