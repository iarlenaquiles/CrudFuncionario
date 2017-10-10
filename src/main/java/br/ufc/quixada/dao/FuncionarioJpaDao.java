package br.ufc.quixada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.ufc.quixada.model.Funcionario;
import br.ufc.quixada.util.JPAUtil;

public class FuncionarioJpaDao implements FuncionarioDao {
	private EntityManager em;
	private EntityTransaction tx;

	public FuncionarioJpaDao() {
		JPAUtil.inicializar("h2");
		this.em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
	}

	public FuncionarioJpaDao(EntityManager em) {
		setEntityManager(em);
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void adiciona(Funcionario funcionario) {
		try {
			tx.begin();
			em.persist(funcionario);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			JPAUtil.closeEntityManager();
		}
	}

	@Override
	public List<Funcionario> getLista() {
		List<Funcionario> result = em.createQuery("from funcionarios", Funcionario.class).getResultList();
		JPAUtil.closeEntityManager();
		return result;
	}

	@Override
	public void altera(Funcionario funcionario) {
		try {
			tx.begin();
			em.merge(funcionario);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			JPAUtil.closeEntityManager();
		}
	}

	@Override
	public void remove(Funcionario funcionario) {
		try {
			tx.begin();
			Funcionario encontrado = em.find(Funcionario.class, funcionario.getId());
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
	public List<Funcionario> getListaNamed() {
		@SuppressWarnings("unchecked")
		List<Funcionario> resultList = em.createNamedQuery("Funcionario.getInfo").getResultList();
		return resultList;
	}

	@Override
	public List<Funcionario> getListaCriteria() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteria = cb.createQuery(Funcionario.class);
		criteria.from(Funcionario.class);
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<Funcionario> getListaNative() {
		@SuppressWarnings("unchecked")
		List<Funcionario> resultList = em.createNativeQuery("select f.* from funcionarios f", Funcionario.class).getResultList();
		return resultList;
	}

	@Override
	public void close() {
		JPAUtil.closeEntityManager();
	}

}
