package model;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import model.generated.tables.*;
import model.generated.tables.records.AnagraficaRecord;
import model.generated.tables.records.DipendenteRecord;
import GestioneSale.db_sqlite.CreateDB;



public class DataService {
	
	private Connection conn;
	
	private static DSLContext create;
	
	
	public DataService() {
		try {
			conn = DriverManager.getConnection(CreateDB.DB_URL);
			create = DSL.using(conn, SQLDialect.SQLITE);
		}
		catch (SQLException e) {
		   System.out.println("ERROR: failed to connect!");
		   System.out.println("ERROR: " + e.getErrorCode());
		   e.printStackTrace();
		}
	}
	
	public boolean credenzialiCorrette(String matricola, char[] psw) {
	    DipendenteRecord DipendenteCorretto =  //cerco il dipendente con la matricola inserita
	    		create.selectFrom(Dipendente.DIPENDENTE)
	            .where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola))
	            .fetchOptional()
	            .orElse(null);

	    if (DipendenteCorretto == null) {
	        return false;
	    } else {
	        String passwordCorretta = DipendenteCorretto.component4().toString();
	        return Arrays.equals(psw, passwordCorretta.toCharArray()); //controllo che la psw sia corretta
	    }
	}


	public String ruoloDipendente(String matricola) {
		
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle().component5();
	}


	/*public int salvaAnagrafica(String nome, String cognome, 
			String cf, String luogoNascita, String residenza, 
			String tel, String email, String nomeMedico, 
			String cognomeMedico, String matricolaMedico, 
			String attesa, String anamnesiProssima, 
			String anamnesiPregressa, ) {
		// TODO Auto-generated method stub
		return 0;
	}*/



	public String getNomeDipendente(String matricola) { 
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle().component1(); 
	}
	
	public String getCognomeDipendente(String matricola) { 
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle().component2(); 
	}
}
