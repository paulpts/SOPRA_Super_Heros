package heros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heros.dto.request.CreateUpdateHerosRequest;
import heros.model.Alpha;
import heros.model.Beta;
import heros.model.Heros;
import heros.model.Omega;
import heros.repo.AgenceRepository;
import heros.repo.HerosRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class HerosService {

	private final AgenceRepository agenceRepository;

	@Autowired
	private HerosRepository herosRepository;

	HerosService(AgenceRepository agenceRepository) {
		this.agenceRepository = agenceRepository;
	}

	public Heros getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("L'id d'un héros ne peut pas être null");
		}
		return herosRepository.findById(id).orElse(null);
	}

	public List<Heros> getAll() {
		return herosRepository.findAll();
	}

	public Heros createOmega(CreateUpdateHerosRequest request) {
		Omega omega = new Omega(
				request.getNom(),
				request.getPrenom(),
				request.getAlias(),
				request.getPopularite(),
				request.getSante(),
				request.getSalaire(),
				request.getExperience(),
				request.getDegats(),
				request.getMotivation(),
				request.getPouvoirs());
		return herosRepository.save(omega);
	}

	public Heros createAlpha(CreateUpdateHerosRequest request) {
		Alpha alpha = new Alpha(
				request.getNom(),
				request.getPrenom(),
				request.getAlias(),
				request.getPopularite(),
				request.getSante(),
				request.getSalaire(),
				request.getExperience(),
				request.getDegats(),
				request.getMotivation(),
				request.getPouvoirs());
		return herosRepository.save(alpha);
	}

	public Heros createBeta(CreateUpdateHerosRequest request) {
		Beta beta = new Beta(
				request.getNom(),
				request.getPrenom(),
				request.getAlias(),
				request.getPopularite(),
				request.getSante(),
				request.getSalaire(),
				request.getExperience(),
				request.getDegats(),
				request.getMotivation(),
				request.getPouvoirs());
		return herosRepository.save(beta);
	}

	public Heros updateHeros(Integer id, CreateUpdateHerosRequest request) {
		Heros heros = herosRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Héros inexistant"));
		if (heros instanceof Omega) {
			return updateOmega(id, request);
		}
		if (heros instanceof Alpha) {
			return updateAlpha(id, request);
		}
		if (heros instanceof Beta) {
			return updateBeta(id, request);
		}
		return null;
	}

	public Heros updateOmega(Integer id, CreateUpdateHerosRequest request) {
		Heros omega = herosRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Héros inexistant"));
		omega.setNom(request.getNom());
		omega.setPrenom(request.getPrenom());
		omega.setAlias(request.getAlias());
		omega.setPopularite(request.getPopularite());
		omega.setSante(request.getSante());
		omega.setSalaire(request.getSalaire());
		omega.setExperience(request.getExperience());
		omega.setDegats(request.getDegats());
		omega.setMotivation(request.getMotivation());
		omega.setPouvoirs(request.getPouvoirs());
		omega.setAgence(agenceRepository.findById(request.getAgenceId()).orElse(null));
		return herosRepository.save(omega); // Ca permet de renvoyer l'objet qui est mis à jour
	}

	public Heros updateAlpha(Integer id, CreateUpdateHerosRequest request) {
		Heros alpha = herosRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Héros inexistant"));
		alpha.setNom(request.getNom());
		alpha.setPrenom(request.getPrenom());
		alpha.setAlias(request.getAlias());
		alpha.setPopularite(request.getPopularite());
		alpha.setSante(request.getSante());
		alpha.setSalaire(request.getSalaire());
		alpha.setExperience(request.getExperience());
		alpha.setDegats(request.getDegats());
		alpha.setMotivation(request.getMotivation());
		alpha.setPouvoirs(request.getPouvoirs());
		alpha.setAgence(agenceRepository.findById(request.getAgenceId()).orElse(null));
		return herosRepository.save(alpha); // Ca permet de renvoyer l'objet qui est mis à jour
	}

	public Heros updateBeta(Integer id, CreateUpdateHerosRequest request) {
		Heros beta = herosRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Héros inexistant"));
		beta.setNom(request.getNom());
		beta.setPrenom(request.getPrenom());
		beta.setAlias(request.getAlias());
		beta.setPopularite(request.getPopularite());
		beta.setSante(request.getSante());
		beta.setSalaire(request.getSalaire());
		beta.setExperience(request.getExperience());
		beta.setDegats(request.getDegats());
		beta.setMotivation(request.getMotivation());
		beta.setPouvoirs(request.getPouvoirs());
		beta.setAgence(agenceRepository.findById(request.getAgenceId()).orElse(null));
		return herosRepository.save(beta); // Ca permet de renvoyer l'objet qui est mis à jour
	}

	public void deleteById(Integer id) { // DELETE FROM heros WHERE id=?
		herosRepository.deleteById(id);
	}

	public void deleteHeros(Heros heros) { // J'ai mis aussi un DELETE pour l'object Heros mais pas sur que ca nous
											// serve vu qu'on a deja DeleteById
		herosRepository.delete(heros);
	}

	/*
	 * public List<Heros> getAllHerosByAgenceId(Integer agenceId) {
	 * return herosRepository.findByAgence_Id(agenceId);
	 * }
	 */

	public Heros getByAlias(String alias) {
		return herosRepository.findByAlias(alias);
	}

	public List<Omega> getAllOmega() {
		return herosRepository.findAllOmega();
	}

	public List<Beta> getAllBeta() {
		return herosRepository.findAllBeta();
	}

	public List<Alpha> getAllAlpha() {
		return herosRepository.findAllAlpha();
	}

	public Omega getOmegaById(Integer id) {
		Heros heros = herosRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Héros introuvable"));
		if (!(heros instanceof Omega)) {
			return null;
		}
		return (Omega) heros;
	}

	public Beta getBetaById(Integer id) {
		Heros heros = herosRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Héros introuvable"));
		if (!(heros instanceof Beta)) {
			return null;
		}
		return (Beta) heros;
	}

	public Alpha getAlphaById(Integer id) {
		Heros heros = herosRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Héros introuvable"));
		if (!(heros instanceof Alpha)) {
			return null;
		}
		return (Alpha) heros;
	}

	public List<Alpha> getAlphaByAgenceId(Integer agenceId) {
		return herosRepository.findAlphaByAgence_Id(agenceId);
	}

	public List<Beta> getBetaByAgenceId(Integer agenceId) {
		return herosRepository.findBetaByAgence_Id(agenceId);
	}

	public List<Omega> getOmegaByAgenceId(Integer agenceId) {
		return herosRepository.findOmegaByAgence_Id(agenceId);
	}
}
