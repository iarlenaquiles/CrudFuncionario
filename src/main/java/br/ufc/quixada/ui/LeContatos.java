package br.ufc.quixada.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufc.quixada.dao.ConnectionFactory;

public class LeContatos {

	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		String sql = "select * from contatos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String nome = rs.getString("nome");
			System.out.println(nome);
		}
		c.close();
	}

}
