package br.ufc.quixada.ui;

import br.ufc.quixada.dao.FuncionarioDao;
import br.ufc.quixada.dao.FuncionarioJpaDao;
import br.ufc.quixada.model.Funcionario;

public class TransactionJPA {

	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioJpaDao();
		
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
