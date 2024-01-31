package model;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import model.generated.tables.*;
import model.generated.tables.records.AnagraficheRecord;
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
	
	public boolean credenzialiCorrette(String matricola, String psw) {
		DipendenteRecord DipendenteCorretto = create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.CODICE.eq(matricola)).fetchSingle();
		if(DipendenteCorretto.equals(null)) return false;
		else if(psw.equals(DipendenteCorretto.component4().toString())) return true;
		else return false;
		
	}

	public String ruoloDipendente(String matricola) {
		
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.CODICE.eq(matricola)).fetchOne().component5();
	}


}
