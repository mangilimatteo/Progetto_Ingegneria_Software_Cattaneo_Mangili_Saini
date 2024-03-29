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
					" MATRICOLA			 		TEXT NOT NULL PRIMARY KEY, " +
					" PASSWORD 					TEXT NOT NULL, " +
					" RUOLO						TEXT NOT NULL " +
					"); " +					
						
					"CREATE TABLE IF NOT EXISTS ANAGRAFICA (" +
					" CODICE       				TEXT NOT NULL PRIMARY KEY," +
					" NOME        				TEXT NOT NULL," + 
					" COGNOME	 				TEXT NOT NULL, " +
					" CODICE_FISCALE	 		TEXT NOT NULL, " +
					" GIORNO_NASCITA	 		TEXT NOT NULL, " +
					" MESE_NASCITA		 		TEXT NOT NULL, " +
					" ANNO_NASCITA		 		TEXT NOT NULL, " +
					" LUOGO_NASCITA	 			TEXT NOT NULL, " +
					" CITTA		 				TEXT NOT NULL, " +
					" INDIRIZZO					TEXT NOT NULL, " +
					" TELEFONO					TEXT NOT NULL, " +
					" EMAIL						TEXT NOT NULL, " +
					" DIAGNOSI			 		TEXT NOT NULL, " +
					" INTERVENTO	 			TEXT NOT NULL, " +
					" ANAMNESI_PREGRESSA		TEXT NOT NULL, " +
					" ANAMNESI_PROSSIMA			TEXT NOT NULL, " +
					" TEMPO_ATTESA	 			TEXT NOT NULL, " +
					" MATR_MEDICO				TEXT NOT NULL, " +
					" NOTE		 				TEXT NOT NULL, " +
					" FOREIGN KEY (MATR_MEDICO) REFERENCES DIPENDENTE(MATRICOLA) " +
					"); " +
					
					"CREATE TABLE IF NOT EXISTS OPERAZIONE (" +
					" CODICE       				TEXT NOT NULL PRIMARY KEY," +
					" BLOCCO       				TEXT NOT NULL," +
					" SALA       				TEXT NOT NULL," +
					" ANESTESIA       			BOOLEAN NOT NULL," +
					" PRIMO_OPERATORE			TEXT NOT NULL," +
					" CODICE_ANAGRAFICA		 	TEXT NOT NULL, " +
					" MEDICO_SCHEDULAZIONE		TEXT NOT NULL, " +
					" FOREIGN KEY (CODICE_ANAGRAFICA) REFERENCES ANAGRAFICA(CODICE), " +
					" FOREIGN KEY (PRIMO_OPERATORE) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (MEDICO_SCHEDULAZIONE) REFERENCES DIPENDENTE(MATRICOLA) " +
					"); " +
					
					"CREATE TABLE IF NOT EXISTS VERBALE (" +
					" CODICE       				TEXT NOT NULL PRIMARY KEY," +
					" INGRESSO_BLOCCO        	TEXT NOT NULL," + 
					" INGRESSO_SALA	 			TEXT NOT NULL, " +
					" POSIZIONAMENTO	 		TEXT NOT NULL, " +
					" INIZIO_ANESTESIA	 		TEXT NOT NULL, " +
					" FINE_ANESTESIA		 	TEXT NOT NULL, " +
					" INIZIO_INTERVENTO		 	TEXT NOT NULL, " +
					" FINE_INTERVENTO	 		TEXT NOT NULL, " +
					" RISVEGLIO		 			TEXT NOT NULL, " +
					" USCITA_SALA				TEXT NOT NULL, " +
					" USCITA_BLOCCO				TEXT NOT NULL, " +
					" TIPO_ANESTESIA			TEXT NOT NULL, " +
					" RISCHIO_ANESTESIA			TEXT NOT NULL, " +
					" PRIMO_OPERATORE	 		TEXT NOT NULL, " +
					" SECONDO_OPERATORE			TEXT NOT NULL, " +
					" TERZO_OPERATORE			TEXT NOT NULL, " +
					" ANESTESISTA	 			TEXT NOT NULL, " +
					" STRUMENTISTA				TEXT NOT NULL, " +
					" INFERMIERE		 		TEXT NOT NULL, " +
					" AIUTO_ANESTESISTA		 	TEXT NOT NULL, " +
					" TECNICO_RADIOLOGIA		TEXT NOT NULL, " +
					" PROCEDURA					TEXT NOT NULL, " +
					" CODICE_OPERAZIONE		 	TEXT NOT NULL, " +
					" DATA_ORA_CREAZIONE	 	TEXT NOT NULL, " +
					" FOREIGN KEY (CODICE_OPERAZIONE) REFERENCES OPERAZIONE(CODICE), " +
					" FOREIGN KEY (PRIMO_OPERATORE) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (SECONDO_OPERATORE) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (TERZO_OPERATORE) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (ANESTESISTA) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (STRUMENTISTA) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (INFERMIERE) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (AIUTO_ANESTESISTA) REFERENCES DIPENDENTE(MATRICOLA), " +
					" FOREIGN KEY (TECNICO_RADIOLOGIA) REFERENCES DIPENDENTE(MATRICOLA) " +
					"); " +
					
					"CREATE TABLE IF NOT EXISTS CODICE (" + 
					" TIPO        				TEXT NOT NULL PRIMARY KEY," + 
					" CONTATORE	 				INTEGER NOT NULL " +
					"); " +	
					
					"INSERT INTO DIPENDENTE " +
					" VALUES " +
					" 	(\"Francesco\", \"Valli\", \"m001a\", \"psw1\", \"Medico\"), " +
					" 	(\"Marta\", \"Gelfi\", \"m001b\", \"psw2\", \"Medico\"), " +
					" 	(\"Anna\", \"Bognolo\", \"i001a\", \"psw3\", \"Infermiere\"), " +
					" 	(\"Sara\", \"Magitteri\", \"i001b\", \"psw4\", \"Infermiere\"), " +
					" 	(\"Yuri\", \"Carminati\", \"c001a\", \"psw5\", \"Cabina di regia\"), " +
					" 	(\"Valerio\", \"Cattaneo\", \"c001b\", \"psw6\", \"Cabina di regia\"); " +
					
					"INSERT INTO CODICE " +
					" VALUES " +
					" 	(\"Anagrafica\", 0), " +
					" 	(\"Verbale\", 0), " +
					" 	(\"Operazione\", 0); " +
				
					"INSERT INTO ANAGRAFICA " +
					" VALUES " +
					" 	(\"0\",\"\",\"\",\"\",\"1\",\"1\",\"1900\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\");" +
	
					"INSERT INTO VERBALE " +
					" VALUES " +
					" 	(\"0\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"01/01/1900 00:00:00\");" +

					"INSERT INTO OPERAZIONE " +
					" VALUES " +
					" 	(\"0\",\"\",\"    \",FALSE,\"\",\"\",\"\");";

				
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