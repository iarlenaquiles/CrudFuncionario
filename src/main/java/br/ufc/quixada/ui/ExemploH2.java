package br.ufc.quixada.ui;

import java.sql.Connection;
import java.sql.DriverManager;

public class ExemploH2 {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			Connection c = DriverManager.getConnection("jdbc:h2:mem:lista6");
			System.out.println("Conectado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
