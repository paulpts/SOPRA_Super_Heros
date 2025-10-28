package projet_super_heros.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import projet_super_heros.dao.IDAOHeros;
import projet_super_heros.dao.DAOHeros;


public class Singleton {

	private static Singleton instance=null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	
	private IDAOHeros daoHeros = new DAOHeros();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance==null) {instance = new Singleton();}
		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public IDAOHeros getDaoHeros() {
		return daoHeros;
	}
	
}
