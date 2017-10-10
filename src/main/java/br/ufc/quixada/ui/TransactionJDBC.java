package br.ufc.quixada.ui;

import java.sql.SQLException;

import br.ufc.quixada.dao.FuncionarioDao;
import br.ufc.quixada.dao.FuncionarioJdbcDao;
import br.ufc.quixada.model.Funcionario;

public class TransactionJDBC {

	public static void main(String[] args) throws SQLException {
		FuncionarioDao dao = new FuncionarioJdbcDao();

		Funcionario f = new Funcionario();
		f.setCpf("12312312312");
		f.setNome("Maria");
		f.setMatrícula("123123");
		f.setEmail("maria@gmail.com");
		f.setTelefone("85985948394");

		dao.adiciona(f);

		f.setId(23);
		dao.altera(f);
		dao.close();
		dao.remove(f);
	}

}
