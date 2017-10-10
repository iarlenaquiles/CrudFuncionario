package br.ufc.quixada.ui;

import java.sql.Connection;
import java.sql.SQLException;

import br.ufc.quixada.dao.ConnectionFactory;

public class JDBCExemplo2 {

	public static void main(String[] args) throws SQLException {
		new ConnectionFactory();
		Connection conexao = ConnectionFactory.getInstance().getConnection();
		System.out.println("Conectado!");
		conexao.close();
	}

}
