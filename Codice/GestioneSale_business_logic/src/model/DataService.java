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
	
	private DSLContext create;
	
	
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
	
	boolean credenzialiCorrette(String id, String psw) {
		DipendenteRecord DipendenteCorretto = create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.CODICE.eq(id)).fetchOne();
		if(DipendenteCorretto == null) return false;
		else if(psw == DipendenteCorretto.component4()) return true;
		else return false;
		
	}


}
