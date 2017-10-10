package br.ufc.quixada.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	// public Connection getConnection() {
	// try {
	// Class.forName("org.postgresql.Driver");
	//
	// return DriverManager.getConnection(
	// "jdbc:postgresql://localhost/dsp",
	// "postgres", "super123");
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }
	private ComboPooledDataSource cpds;
	private static ConnectionFactory dataSource;

	public ConnectionFactory() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("org.h2.Driver");
			cpds.setJdbcUrl("jdbc:h2:tcp://localhost/~/lista6");
			cpds.setUser("sa");
			cpds.setPassword("");
			cpds.setMinPoolSize(3);
			cpds.setMaxPoolSize(10);
			cpds.setCheckoutTimeout(300);
		} catch (PropertyVetoException ex1) {
			ex1.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		if (dataSource == null)
			dataSource = new ConnectionFactory();
		return dataSource;
	}
	
	 public Connection getConnection() {
	      Connection con = null;
	      try {
	         con = cpds.getConnection();
		} catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return con;
	   }
}
