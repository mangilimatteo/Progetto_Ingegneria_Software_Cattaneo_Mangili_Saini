package test;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DB_REL_FILE = "db/indirizzi.db3";
		 String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
		
		try {			
		 Connection conn = DriverManager.getConnection(DB_URL);
		 if (conn != null) {
		   DatabaseMetaData meta = conn.getMetaData();
		   System.out.println("The driver name is " + meta.getDriverName());
		   System.out.println("A new database has been created.");
		   
		   Statement stmt = conn.createStatement();
		   String sql = "CREATE TABLE INDIRIZZI (" + 
					" NOME        TEXT," + 
					" NUMTELEFONO TEXT )";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			System.out.println("Table created successfully");
		 }
		 // controllo che il file esista a questo punto
		 System.out.println("il file esiste? " + new File(DB_REL_FILE).exists());
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		
		GestioneIndirizzi indirizzi = new GestioneIndirizzi(DB_URL);
		indirizzi.add("Nicola", "123");
		
	}

}
