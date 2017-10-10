package br.ufc.quixada.ui;

import br.ufc.quixada.dao.DependenteDao;
import br.ufc.quixada.dao.DependenteJpaDao;
import br.ufc.quixada.model.Dependente;
import br.ufc.quixada.model.Funcionario;

public class AdicionaDependentes {
	public static void main(String[] args) {
		Funcionario func1 = new Funcionario();
		func1.setId(17);
		
		Funcionario func2 = new Funcionario();
		func2.setId(19);
		
		Funcionario func3 = new Funcionario();
		func3.setId(20);
		
		Dependente dependente1 = new Dependente();
		dependente1.setCpf("77777777777");
		dependente1.setNome("Maria");
		dependente1.setFuncionario(func1);

		Dependente dependente2 = new Dependente();
		dependente2.setCpf("88888888888");
		dependente2.setNome("Joana");
		dependente2.setFuncionario(func1);

		Dependente dependente3 = new Dependente();
		dependente3.setCpf("9999999999");
		dependente3.setNome("Mayara");
		dependente3.setFuncionario(func2);

		Dependente dependente4 = new Dependente();
		dependente4.setCpf("01234958903");
		dependente4.setNome("Debora");
		dependente4.setFuncionario(func3);

		DependenteDao daoDep = new DependenteJpaDao();

		daoDep.adiciona(dependente1);
		daoDep.adiciona(dependente2);
		daoDep.adiciona(dependente3);
		daoDep.adiciona(dependente4);
	}
}
