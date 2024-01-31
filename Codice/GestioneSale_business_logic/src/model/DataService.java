package model;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jetbrains.annotations.Nullable;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import model.generated.tables.*;
import model.generated.tables.records.AnagraficheRecord;
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
		AnagraficheRecord AnagraficaCorretta = create.selectFrom(Anagrafiche.ANAGRAFICHE).
				where(Anagrafiche.ANAGRAFICHE.CODICE.eq(id)).fetchOne();
		if(AnagraficaCorretta == null) return false;
		else if(AnagraficaCorretta.)
		
	}


}
