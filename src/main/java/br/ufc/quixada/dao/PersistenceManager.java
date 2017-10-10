package br.ufc.quixada.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;

	private PersistenceManager() {
	}

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("h2");
		}
		return emf.createEntityManager();
	}

	public static void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
			emf = null;
		}
	}

}
