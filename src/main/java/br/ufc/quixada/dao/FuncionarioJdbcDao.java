package br.ufc.quixada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.model.Dependente;
import br.ufc.quixada.model.Funcionario;

public class FuncionarioJdbcDao implements FuncionarioDao {
	private Connection connection;

	public FuncionarioJdbcDao() throws SQLException {
		new ConnectionFactory();
		this.connection = ConnectionFactory.getInstance().getConnection();
		this.connection.setAutoCommit(false);
	}

	public FuncionarioJdbcDao(Connection c) {
		setConnection(c);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionarios " + "(cpf, email, matricula, nome, telefone)"
				+ " values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getCpf());
			stmt.setString(2, funcionario.getEmail());
			stmt.setString(3, funcionario.getMatrícula());
			stmt.setString(4, funcionario.getNome());
			stmt.setString(5, funcionario.getTelefone());

			stmt.executeUpdate();
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Funcionario> getLista() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		Dependente d = null;
		String sql = "select f.*, d.nome as nome_dep, d.id as id_dep, d.cpf as cpf_dep from funcionarios f, dependentes d where f.id = d.func_id";
		try {

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setMatrícula(rs.getString("matricula"));
				
				// adicionando o objeto à lista
				funcionarios.add(funcionario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return funcionarios;
	}

	@Override
	public void altera(Funcionario funcionario) {
		String sql = "update funcionarios set nome=?, email=?, telefone=?, cpf=?, matricula=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getEmail());
			stmt.setString(3, funcionario.getTelefone());
			stmt.setString(4, funcionario.getCpf());
			stmt.setString(5, funcionario.getMatrícula());
			stmt.setInt(6, funcionario.getId());
			stmt.execute();
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remove(Funcionario funcionario) {
		try {
			String sql = "delete from funcionarios where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			stmt.execute();
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void close() {
		try {
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Funcionario> getListaNamed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getListaCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getListaNative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getListaOtimizada() {
		// TODO Auto-generated method stub
		return null;
	}

}
