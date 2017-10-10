package br.ufc.quixada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.model.Dependente;
import br.ufc.quixada.model.Funcionario;

public class DependenteJdbcDao implements DependenteDao {
	private Connection connection;

	public DependenteJdbcDao() throws SQLException {
		new ConnectionFactory();
		this.connection = ConnectionFactory.getInstance().getConnection();
		this.connection.setAutoCommit(false);
	}

	public DependenteJdbcDao(Connection c) {
		setConnection(c);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void adiciona(Dependente dependente) {
		String sql = "insert into dependentes " + "(cpf, nome, func_id)" + " values (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, dependente.getCpf());
			stmt.setString(2, dependente.getNome());
			stmt.setInt(3, dependente.getFuncionario().getId());

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
	public List<Dependente> getLista() {
		String sql = "select d.*,f.nome as nome_func from dependentes d, funcionarios f where d.func_id = f.id";
		List<Dependente> dependentes = new ArrayList<Dependente>();
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Dependente dependente = new Dependente();
				dependente.setId(rs.getInt("id"));
				dependente.setNome(rs.getString("nome"));
				dependente.setCpf(rs.getString("cpf"));
				dependente.setFuncionario(new Funcionario(rs.getInt("func_id"), rs.getString("nome_func")));

				// adicionando o objeto à lista
				dependentes.add(dependente);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dependentes;
	}

	@Override
	public void altera(Dependente dependente) {
		String sql = "update dependentes set nome=?, cpf=?, func_id=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, dependente.getNome());
			stmt.setString(2, dependente.getCpf());
			stmt.setInt(3, dependente.getFuncionario().getId());
			stmt.setInt(4, dependente.getId());
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
	public void remove(Dependente dependente) {
		try {
			String sql = "delete from dependentes where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, dependente.getId());
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
	public List<Dependente> findByInicial(String inicial) {
		return null;
	}

	@Override
	public List<Dependente> findByInicialCriteria(String inicial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dependente> findByInicialNamed(String inicial) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Dependente> findByInicialNativa(String inicial) {
		// TODO Auto-generated method stub
		return null;
	}

}
