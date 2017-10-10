package br.ufc.quixada.ui;

import java.sql.SQLException;
import java.util.List;

import br.ufc.quixada.dao.FuncionarioDao;
import br.ufc.quixada.dao.FuncionarioJdbcDao;
import br.ufc.quixada.model.Funcionario;

public class Funcionarios {
	public static void main(String[] args) throws SQLException {
		FuncionarioDao dao = new FuncionarioJdbcDao();
		List<Funcionario> funcionarios = dao.getLista();

		for (Funcionario f : funcionarios) {
			System.out.println("ID: " + f.getId());
			System.out.println("CPF: " + f.getCpf());
			System.out.println("Nome: " + f.getNome());
			System.out.println("E-mail: " + f.getEmail());
			System.out.println("E-mail: " + f.getTelefone());
			System.out.println("Matrícula: " + f.getMatrícula());
			System.out.println("Dependentes: " + f.getDependentes());
			System.out.println();
		}
		
		dao.close();

	}
}
