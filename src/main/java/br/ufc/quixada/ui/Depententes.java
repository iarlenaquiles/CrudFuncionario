package br.ufc.quixada.ui;

import java.sql.SQLException;
import java.util.List;

import br.ufc.quixada.dao.DependenteDao;
import br.ufc.quixada.dao.DependenteJdbcDao;
import br.ufc.quixada.model.Dependente;

public class Depententes {

	public static void main(String[] args) {
		DependenteDao dao;
		try {
			dao = new DependenteJdbcDao();
//			Dependente d = new Dependente();
//			d.setId(6);
//			d.setCpf("54545454545");
//			d.setNome("Ronaldo Silva");
//			d.setFuncionario(new Funcionario(21));
//			dao.remove(d);
			List<Dependente> dependentes = dao.getLista();
			System.out.println(dependentes);
			for (Dependente d : dependentes) {
				System.out.println("CPF: " + d.getCpf());
				System.out.println("Nome: " + d.getNome());
				System.out.println("Funcionario: " + d.getFuncionario().getNome());
				System.out.println();
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//List<Dependente> dependentes = dao.findByInicialNativa("M");

//		for (Dependente d : dependentes) {
//			System.out.println("CPF: " + d.getCpf());
//			System.out.println("Nome: " + d.getNome());
//			System.out.println("Funcionario: " + d.getFuncionario().getNome());
//			System.out.println();
//		}
		
		/*Dependente d = new Dependente();
		d.setId(2);
		d.setCpf("88888888888");
		d.setNome("Joana Silva");
		d.setFuncionario(new Funcionario(17));
		dao.altera(d);*/
		
	}

}
