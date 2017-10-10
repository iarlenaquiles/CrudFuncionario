package br.ufc.quixada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import br.ufc.quixada.model.Dependente;
import br.ufc.quixada.util.JPAUtil;

public class DependenteJpaDao implements DependenteDao {
	private EntityManager em;
	private EntityTransaction tx;

	public DependenteJpaDao() {
		JPAUtil.inicializar("h2");
		this.em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
	}

	public DependenteJpaDao(EntityManager em) {
		setEntityManager(em);
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void adiciona(Dependente dependente) {
		try {
			tx.begin();
			em.persist(dependente);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			JPAUtil.closeEntityManager();
		}
	}

	@Override
	public List<Dependente> getLista() {
		List<Dependente> result = em.createQuery("from dependentes", Dependente.class).getResultList();
		JPAUtil.closeEntityManager();
		return result;
	}

	@Override
	public void altera(Dependente dependente) {
		try {
			tx.begin();
			em.merge(dependente);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			JPAUtil.closeEntityManager();
		}
	}

	@Override
	public void remove(Dependente dependente) {
		try {
			tx.begin();
			Dependente encontrado = em.find(Dependente.class, dependente.getId());
			em.remove(encontrado);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			JPAUtil.closeEntityManager();
		}
	}

	@Override
	public List<Dependente> findByInicial(String inicial) {
		List<Dependente> dependentes = em.createQuery("FROM dependentes d WHERE d.nome LIKE :nome", Dependente.class)
				.setParameter("nome", inicial + "%").getResultList();
		JPAUtil.closeEntityManager();
		return dependentes;
	}

	@Override
	public List<Dependente> findByInicialCriteria(String inicial) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Dependente> criteria = cb.createQuery(Dependente.class);
		EntityType<Dependente> type = em.getMetamodel().entity(Dependente.class);
		Root<Dependente> dependente = criteria.from(Dependente.class);
		criteria.where(cb.like(dependente.get(type.getDeclaredSingularAttribute("nome", String.class)), inicial + "%"));
		return em.createQuery(criteria).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dependente> findByInicialNamed(String inicial) {
		return em.createNamedQuery("Dependente.findByInicialNamed").setParameter("nome", inicial + "%").getResultList();
	}

	@Override
	public List<Dependente> findByInicialNativa(String inicial) {
		return em.createNativeQuery("select d.* from dependentes d where d.nome like :nome", Dependente.class)
				.setParameter("nome", inicial + "%").getResultList();
	}

	@Override
	public void close() {
		JPAUtil.closeEntityManager();
	}

}
