package GestioneSale.db_sqlite;

import java.io.IOException; 
import java.sql.*;

public class CreateTables {
	
	public static void main(String args[]) throws IOException {

		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = 
					"CREATE TABLE IF NOT EXISTS DIPENDENTE (" + 
					" NOME        				TEXT NOT NULL," + 
					" COGNOME	 				TEXT NOT NULL, " +
					" CODICE			 		TEXT NOT NULL PRIMARY KEY, " +
					" PASSWORD 					TEXT NOT NULL, " +
					" RUOLO						TEXT NOT NULL " +
					"); " +					
						
					"CREATE TABLE IF NOT EXISTS ANAGRAFICHE (" + 
					" NOME        				TEXT NOT NULL," + 
					" COGNOME	 				TEXT NOT NULL, " +
					" CODICE_FISCALE	 		TEXT NOT NULL PRIMARY KEY, " +
					" DATA_NASCITA	 			TEXT NOT NULL, " +
					" LUOGO_NASCITA	 			TEXT NOT NULL, " +
					" CITTA		 				TEXT NOT NULL, " +
					" VIA						TEXT NOT NULL, " +
					" TELEFONO					TEXT NOT NULL, " +
					" EMAIL						TEXT NOT NULL, " +
					" ANAMNESI_PREGRESSA		TEXT NOT NULL " +
					");" +
					
					"CREATE TABLE IF NOT EXISTS INTERVENTI (" + 
					" ID        				TEXT NOT NULL PRIMARY KEY," +
					" PAZIENTE        			TEXT NOT NULL," +
					" DESCRIZIONE	 			TEXT NOT NULL, " +
					" DIAGNOSI			 		TEXT NOT NULL, " +
					" ANAMNESI_PROSSIMA			TEXT NOT NULL, " +
					" TEMPO ATTESA	 			TEXT NOT NULL, " +
					" NOTE		 				TEXT NOT NULL, " +
					" VIA						TEXT, " +
					" FOREIGN KEY (PAZIENTE) REFERENCES ANAGRAFICHE(CODICE_FISCALE) " +
					"); " +
					
					"CREATE TABLE IF NOT EXISTS LISTE_ATTESA (" + 
					" INTERVENTO   				TEXT NOT NULL PRIMARY KEY," +
					" TIPO_INTERVENTO  			TEXT NOT NULL," +
					" TIPO_LISTA	 			TEXT NOT NULL, " +
					" FOREIGN KEY (INTERVENTO) REFERENCES INTERVENTO(ID) " +
					"); " +
					
					"CREATE TABLE IF NOT EXISTS LISTE_OPERATORIE (" + 
					" INTERVENTO   				TEXT NOT NULL PRIMARY KEY," +
					" PRIMO_OPERATORE  			TEXT NOT NULL," +
					" GIORNO	 				TEXT NOT NULL, " +
					" ORARIO		 			TEXT NOT NULL, " +
					" FOREIGN KEY (INTERVENTO) REFERENCES LISTE_ATTESA(INTERVENTO) " +
					"); " +
					
					"INSERT INTO DIPENDENTE " +
					" VALUES " +
					" 	(\"Francesco\", \"Valli\", \"m001a\", \"psw1\", \"Medico\"), " +
					" 	(\"Marta\", \"Gelfi\", \"m001b\", \"psw2\", \"Medico\"), " +
					" 	(\"Anna\", \"Bognolo\", \"i001a\", \"psw3\", \"Infermiere\"), " +
					" 	(\"Sara\", \"Magitteri\", \"i001b\", \"psw4\", \"Infermiere\"), " +
					" 	(\"Yuri\", \"Carminati\", \"c001a\", \"psw5\", \"Cabina di regia\"), " +
					" 	(\"Valerio\", \"Cattaneo\", \"c001b\", \"psw6\", \"Cabina di regia\"); ";
					
					
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Table created successfully");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finito");
		}
	}

}