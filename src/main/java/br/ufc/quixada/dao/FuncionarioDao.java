package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Funcionario;

public interface FuncionarioDao {
	public void adiciona(Funcionario funcionario);

	public List<Funcionario> getLista();

	public List<Funcionario> getListaNamed();
	
	public List<Funcionario> getListaCriteria();
	
	public List<Funcionario> getListaNative();
	
	public void altera(Funcionario funcionario);

	public void remove(Funcionario funcionario);

	public void close();
}
