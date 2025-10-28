package projet_super_heros.dao;

import java.util.List;

import javax.persistence.EntityManager;

import projet_super_heros.model.Heros;
import projet_super_heros.context.Singleton;

public class DAOHeros implements IDAOHeros {

	@Override
	public List<Heros> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Heros> heros  = em.createQuery("from Heros").getResultList();
		em.close();
		return heros;
	}

	@Override
	public Heros findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Heros heros  = em.find(Heros.class, id);
		em.close();
		return heros;
	}

	@Override
	public Heros save(Heros heros) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		heros=  em.merge(heros);
		em.getTransaction().commit();
		em.close();
		return heros;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Heros heros = em.find(Heros.class, id);
		em.remove(heros);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Heros heros) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		heros = em.merge(heros);
		em.remove(heros);
		em.getTransaction().commit();
		em.close();
	}
	
}
