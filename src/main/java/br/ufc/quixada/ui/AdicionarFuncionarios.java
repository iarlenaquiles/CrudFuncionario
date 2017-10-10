package br.ufc.quixada.ui;

import br.ufc.quixada.dao.FuncionarioDao;
import br.ufc.quixada.dao.FuncionarioJpaDao;
import br.ufc.quixada.model.Funcionario;

public class AdicionarFuncionarios {

	public static void main(String[] args) {
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Iarlen");
		funcionario1.setEmail("iarlen@ufc.br");
		funcionario1.setCpf("09898776566");
		funcionario1.setMatrícula("7");
		funcionario1.setTelefone("85989898989");

		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Jonas");
		funcionario2.setEmail("jonasmaximo@ufc.br");
		funcionario2.setCpf("22222222222");
		funcionario2.setMatrícula("2");
		funcionario2.setTelefone("85987654327");

		Funcionario funcionario3 = new Funcionario();
		funcionario3.setNome("Anthony");
		funcionario3.setEmail("anthony@ufc.br");
		funcionario3.setCpf("33333333333");
		funcionario3.setMatrícula("3");
		funcionario3.setTelefone("85987656748");

		Funcionario funcionario4 = new Funcionario();
		funcionario4.setNome("Rodrigo");
		funcionario4.setEmail("rodrigo@ufc.br");
		funcionario4.setCpf("44444444444");
		funcionario4.setMatrícula("4");
		funcionario4.setTelefone("85987654367");

		Funcionario funcionario5 = new Funcionario();
		funcionario5.setNome("Jecivando");
		funcionario5.setEmail("jecivando@ufc.br");
		funcionario5.setCpf("55555555555");
		funcionario5.setMatrícula("5");
		funcionario5.setTelefone("85787878787");

		Funcionario funcionario6 = new Funcionario();
		funcionario6.setNome("João");
		funcionario6.setEmail("joao@ufc.br");
		funcionario6.setCpf("66666666666");
		funcionario6.setMatrícula("6");
		funcionario6.setTelefone("85987878478");

		Funcionario funcionario7 = new Funcionario();
		funcionario7.setId(23);
		funcionario7.setNome("Iarlen Aquiles");
		funcionario7.setEmail("iarlenaquiles@ufc.br");
		funcionario7.setCpf("09898776566");
		funcionario7.setMatrícula("7");
		funcionario7.setTelefone("8588888888");
		
		FuncionarioDao dao = new FuncionarioJpaDao();

		dao.remove(funcionario7);
		dao.adiciona(funcionario2);
		dao.adiciona(funcionario3);
		dao.adiciona(funcionario4);
		dao.adiciona(funcionario5);
		dao.adiciona(funcionario6);

		dao.close();

	}

}
