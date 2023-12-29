package test;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestioneIndirizzi {
	
	static Connection conn;
	
	GestioneIndirizzi(String DB_URL){
		try {
			conn = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(String nome, String tel) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO INDIRIZZI VALUES (" + " \"" + nome + "\", \"" + tel + "\" )";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Utente inserito con successo");
	}

}
