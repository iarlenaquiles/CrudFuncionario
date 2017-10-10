package br.ufc.quixada.ui;

import java.util.List;

import br.ufc.quixada.dao.FuncionarioDao;
import br.ufc.quixada.dao.FuncionarioJpaDao;
import br.ufc.quixada.dao.PersistenceManager;
import br.ufc.quixada.model.Funcionario;

public class DaoExemploLista {

	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioJpaDao();
		List<Funcionario> contatos = dao.getLista();

		for (Funcionario contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
		}
		PersistenceManager.close();
	}

}
