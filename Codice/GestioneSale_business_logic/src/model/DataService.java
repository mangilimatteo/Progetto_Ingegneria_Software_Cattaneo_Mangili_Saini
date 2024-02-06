package model;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.*;

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
	
	
	//controlla che le credenziali inserite al login siano corrette
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


	public String getRuoloDipendente(String matricola) {
		
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle().component5();
	}
	

	public String getNomeDipendente(String matricola) { 
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle().component1(); 
	}
	
	public String getCognomeDipendente(String matricola) { 
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle().component2(); 
	}
	
	//questa funzione prende il contatore dei codici nel database e da quello ne genera uno nuovo
	//in modo incrementale e aggiorna il contatore
	public String generaNuovoCodice(String tipo) {
		int nuovoCodice = 1 + create
	        .selectFrom(Codice.CODICE)
	        .where(Codice.CODICE.TIPO.eq(tipo))
	        .fetchOne()
	        .getValue(Codice.CODICE.CONTATORE);
		
		create.update(Codice.CODICE)
        .set(Codice.CODICE.CONTATORE, nuovoCodice)
        .where(Codice.CODICE.TIPO.eq(tipo))
        .execute();
		
		return String.valueOf(nuovoCodice);	
	}
	
	
	//se la matricola ha un valore nullo significa che si sta creando una nuova anagrafica,
	// quindi serve generare una nuova matricola. Dopodiché si crea una nuova anagrafica che, per il momento,
	//conterrà valori standard (si riempie con i valori affettivi al salvataggio)
	public String getCodiceAnagrafica(String codiceAnagrafica) {
		if(codiceAnagrafica.equals("")){
			String nuovoCodice = generaNuovoCodice("Anagrafica");
			creaNuovaAnagrafica(nuovoCodice);			
			return nuovoCodice;
		}
		else 	
			return codiceAnagrafica;
	}
	
	
	//crea una nuova anagrafica con tutti i campi standard
	private void creaNuovaAnagrafica(String nuovoCodice) {
		AnagraficaRecord nuovaAnagrafica = new AnagraficaRecord(
				nuovoCodice,"","","","1","1","1800","","","", "", "", "", "", "", "", "", "", "");
		int result = create.insertInto(Anagrafica.ANAGRAFICA).set(nuovaAnagrafica).execute();
		System.out.println(result); // stampa 1 se tutto andato bene
	}

	public boolean salvaAnagrafica(String codice, String[] valori) {
		//se ci sono campi vuoti, ad eccezioni delle note, non va bene
		for(int i = 0; i < 17; i++) {
			if(valori[i].equals(""))
				return false;
		}
		//salvo tutto
		create
		.update(Anagrafica.ANAGRAFICA)
		.set(Anagrafica.ANAGRAFICA.NOME, valori[0])
		.set(Anagrafica.ANAGRAFICA.COGNOME, valori[1])
		.set(Anagrafica.ANAGRAFICA.CODICE_FISCALE, valori[2])
		.set(Anagrafica.ANAGRAFICA.GIORNO_NASCITA, valori[3])
		.set(Anagrafica.ANAGRAFICA.MESE_NASCITA, valori[4])
		.set(Anagrafica.ANAGRAFICA.ANNO_NASCITA, valori[5])
		.set(Anagrafica.ANAGRAFICA.LUOGO_NASCITA, valori[6])
		.set(Anagrafica.ANAGRAFICA.CITTA, valori[7])
		.set(Anagrafica.ANAGRAFICA.INDIRIZZO, valori[8])
		.set(Anagrafica.ANAGRAFICA.TELEFONO, valori[9])
		.set(Anagrafica.ANAGRAFICA.EMAIL, valori[10])
		.set(Anagrafica.ANAGRAFICA.DIAGNOSI, valori[11])
		.set(Anagrafica.ANAGRAFICA.INTERVENTO, valori[12])
		.set(Anagrafica.ANAGRAFICA.ANAMNESI_PREGRESSA, valori[13])
		.set(Anagrafica.ANAGRAFICA.ANAMNESI_PROSSIMA, valori[14])
		.set(Anagrafica.ANAGRAFICA.TEMPO_ATTESA, valori[15])
		.set(Anagrafica.ANAGRAFICA.MATR_MEDICO, valori[16])
		.set(Anagrafica.ANAGRAFICA.NOTE, valori[17])
		.where(Anagrafica.ANAGRAFICA.CODICE.eq(codice))
		.execute();
		 return true;
	}

	public String[] getValoriAnagrafica(String codiceAnagrafica, String matricolaMedico) {
		
		AnagraficaRecord anagrafica = create
	            .selectFrom(Anagrafica.ANAGRAFICA)
	            .where(Anagrafica.ANAGRAFICA.CODICE.eq(codiceAnagrafica))
	            .fetchOne();
		
		String nome = anagrafica.getValue(Anagrafica.ANAGRAFICA.NOME);
		String cognome = anagrafica.getValue(Anagrafica.ANAGRAFICA.COGNOME);
		String cf = anagrafica.getValue(Anagrafica.ANAGRAFICA.CODICE_FISCALE);
		String gNascita = anagrafica.getValue(Anagrafica.ANAGRAFICA.GIORNO_NASCITA);
		String mNascita = anagrafica.getValue(Anagrafica.ANAGRAFICA.MESE_NASCITA);
		String aNascita = anagrafica.getValue(Anagrafica.ANAGRAFICA.ANNO_NASCITA);
		String lNascita = anagrafica.getValue(Anagrafica.ANAGRAFICA.LUOGO_NASCITA);
		String citta = anagrafica.getValue(Anagrafica.ANAGRAFICA.CITTA);
		String indirizzo = anagrafica.getValue(Anagrafica.ANAGRAFICA.INDIRIZZO);
		String tel = anagrafica.getValue(Anagrafica.ANAGRAFICA.TELEFONO);
		String email = anagrafica.getValue(Anagrafica.ANAGRAFICA.EMAIL);
		String diagnosi = anagrafica.getValue(Anagrafica.ANAGRAFICA.DIAGNOSI);
		String intervento = anagrafica.getValue(Anagrafica.ANAGRAFICA.INTERVENTO);
		String anamnesiPregressa = anagrafica.getValue(Anagrafica.ANAGRAFICA.ANAMNESI_PREGRESSA);
		String anamnesiProssima = anagrafica.getValue(Anagrafica.ANAGRAFICA.ANAMNESI_PROSSIMA);
		String attesa = anagrafica.getValue(Anagrafica.ANAGRAFICA.TEMPO_ATTESA);
		String matrMedico = anagrafica.getValue(Anagrafica.ANAGRAFICA.MATR_MEDICO);
		//se la matricola del medico è vuota significa che quella che sta venendo visualizzata è un'anagrafica
		//nuova e quindi il medico richiedente è quello che sta compilando
		if(matrMedico.equals("")) {
			matrMedico = matricolaMedico;
		}
		String note = anagrafica.getValue(Anagrafica.ANAGRAFICA.NOTE);
		
		String[] valori = {
				nome, cognome, cf, gNascita, mNascita, aNascita, lNascita, citta, indirizzo,
				tel, email, diagnosi, intervento, anamnesiPregressa, anamnesiProssima, attesa,
				matrMedico, note
		};
		return valori;
	}


	public boolean eliminaAnagraficaVuota(String codiceAnagrafica) {
		String[] anagrafica = getValoriAnagrafica(codiceAnagrafica,"");
		String[] anagraficaVuota = getValoriAnagrafica("0","");
		for(int i = 0; i <18; i++)
			if(!(anagrafica[i].equals(anagraficaVuota[i]))){
				return false;
			}
		eliminaAnagrafica(codiceAnagrafica);
		decrementaCodice("Anagrafica");
		return true;
		
	}
	
	
	private void eliminaAnagrafica(String codiceAnagrafica) {
		create.deleteFrom(Anagrafica.ANAGRAFICA)
		.where(Anagrafica.ANAGRAFICA.CODICE.eq(codiceAnagrafica))
		.execute();
	}


	protected void decrementaCodice(String tipo) {
		int codiceDecrementato = create
		        .selectFrom(Codice.CODICE)
		        .where(Codice.CODICE.TIPO.eq(tipo))
		        .fetchOne()
		        .getValue(Codice.CODICE.CONTATORE)
		        -1;
			
			create.update(Codice.CODICE)
	        .set(Codice.CODICE.CONTATORE, codiceDecrementato)
	        .where(Codice.CODICE.TIPO.eq(tipo))
	        .execute();
		
	}

}
	
	
