package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Dependente;

public interface DependenteDao {
	public void adiciona(Dependente dependente);

	public List<Dependente> getLista();

	public void altera(Dependente dependente);

	public void remove(Dependente dependente);

	public List<Dependente> findByInicial(String inicial);

	public List<Dependente> findByInicialCriteria(String inicial);
	
	public List<Dependente> findByInicialNamed(String inicial);
	
	public List<Dependente> findByInicialNativa(String inicial);
	
	public void close();
}
