package br.ufc.quixada.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf;

	private static ThreadLocal<EntityManager> ems;

	public JPAUtil() {

	}

	public static void inicializar(String unit) {
		emf = Persistence.createEntityManagerFactory(unit);
		ems = new ThreadLocal<EntityManager>();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = ems.get();
		if (em == null) {
			em = emf.createEntityManager();
			ems.set(em);
		}
		return em;
	}

	public static void closeEntityManager() {
		EntityManager em = ems.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) {
				tx.commit();
			}
			em.close();
			ems.set(null);
			emf.close();
		}
	}

	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public static void commit() {
		EntityTransaction tx = getEntityManager().getTransaction();
		if (tx.isActive()) {
			tx.commit();
		}
	}

	public static void rollback() {
		EntityTransaction tx = getEntityManager().getTransaction();
		if (tx.isActive()) {
			tx.rollback();
		}
	}
}
