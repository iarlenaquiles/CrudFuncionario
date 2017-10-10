package br.ufc.quixada.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExemplo {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/dsp",
				"postgres", "super123");
		System.out.println("Conectado!");
		conexao.close();
	}

}
