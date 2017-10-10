package br.ufc.quixada.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.quixada.dao.ConnectionFactory;

public class InsereContato {

	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		String sql = "insert into contatos (nome, email, endereco) "
				+ "values (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "Regis Pires");
		ps.setString(2, "regispiresmag@gmail.com");
		ps.setString(3, "Rua X, 12");
		ps.executeUpdate();
		c.close();
	}

}
