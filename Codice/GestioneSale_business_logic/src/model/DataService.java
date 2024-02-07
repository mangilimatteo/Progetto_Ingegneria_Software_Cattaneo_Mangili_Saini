package model;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
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
import model.generated.tables.records.VerbaleRecord;
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
	
	public String getPazienteAnagrafica(String codiceAnagrafica) {
		String[] valori = getValoriAnagrafica(codiceAnagrafica, "");
		return valori[0] + " " + valori [1];
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
		
		String valore0 = anagrafica.getValue(Anagrafica.ANAGRAFICA.NOME);
		String valore1 = anagrafica.getValue(Anagrafica.ANAGRAFICA.COGNOME);
		String valore2 = anagrafica.getValue(Anagrafica.ANAGRAFICA.CODICE_FISCALE);
		String valore3 = anagrafica.getValue(Anagrafica.ANAGRAFICA.GIORNO_NASCITA);
		String valore4 = anagrafica.getValue(Anagrafica.ANAGRAFICA.MESE_NASCITA);
		String valore5 = anagrafica.getValue(Anagrafica.ANAGRAFICA.ANNO_NASCITA);
		String valore6 = anagrafica.getValue(Anagrafica.ANAGRAFICA.LUOGO_NASCITA);
		String valore7 = anagrafica.getValue(Anagrafica.ANAGRAFICA.CITTA);
		String valore8 = anagrafica.getValue(Anagrafica.ANAGRAFICA.INDIRIZZO);
		String valore9 = anagrafica.getValue(Anagrafica.ANAGRAFICA.TELEFONO);
		String valore10 = anagrafica.getValue(Anagrafica.ANAGRAFICA.EMAIL);
		String valore11 = anagrafica.getValue(Anagrafica.ANAGRAFICA.DIAGNOSI);
		String valore12 = anagrafica.getValue(Anagrafica.ANAGRAFICA.INTERVENTO);
		String valore13 = anagrafica.getValue(Anagrafica.ANAGRAFICA.ANAMNESI_PREGRESSA);
		String valore14 = anagrafica.getValue(Anagrafica.ANAGRAFICA.ANAMNESI_PROSSIMA);
		String valore15 = anagrafica.getValue(Anagrafica.ANAGRAFICA.TEMPO_ATTESA);
		String valore16 = anagrafica.getValue(Anagrafica.ANAGRAFICA.MATR_MEDICO);
		//se la matricola del medico è vuota significa che quella che sta venendo visualizzata è un'anagrafica
		//nuova e quindi il medico richiedente è quello che sta compilando
		if(valore16.equals("")) {
			valore16 = matricolaMedico;
		}
		String valore17 = anagrafica.getValue(Anagrafica.ANAGRAFICA.NOTE);
		
		String[] valori = {
				valore0, valore1, valore2, valore3, valore4, valore5, valore6, valore7, valore8, valore9, 
				valore10, valore11, valore12, valore13, valore14, valore15, valore16, valore17
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
		int codiceDecrementato = -1 + create
		        .selectFrom(Codice.CODICE)
		        .where(Codice.CODICE.TIPO.eq(tipo))
		        .fetchOne()
		        .getValue(Codice.CODICE.CONTATORE);
			
			create.update(Codice.CODICE)
	        .set(Codice.CODICE.CONTATORE, codiceDecrementato)
	        .where(Codice.CODICE.TIPO.eq(tipo))
	        .execute();
		
	} 


	public String[] getValoriVerbale(String codiceVerbale) {
		VerbaleRecord verbale = create
	            .selectFrom(Verbale.VERBALE)
	            .where(Verbale.VERBALE.CODICE.eq(codiceVerbale))
	            .fetchOne();
		
		String valore0 = valutaOrario(verbale.getValue(Verbale.VERBALE.INGRESSO_BLOCCO));
		String valore1 = valutaOrario(verbale.getValue(Verbale.VERBALE.INGRESSO_SALA));
		String valore2 = valutaOrario(verbale.getValue(Verbale.VERBALE.POSIZIONAMENTO));
		String valore3 = valutaOrario(verbale.getValue(Verbale.VERBALE.INIZIO_ANESTESIA));
		String valore4 = valutaOrario(verbale.getValue(Verbale.VERBALE.FINE_ANESTESIA));
		String valore5 = valutaOrario(verbale.getValue(Verbale.VERBALE.INIZIO_INTERVENTO));
		String valore6 = valutaOrario(verbale.getValue(Verbale.VERBALE.FINE_INTERVENTO));
		String valore7 = valutaOrario(verbale.getValue(Verbale.VERBALE.RISVEGLIO));
		String valore8 = valutaOrario(verbale.getValue(Verbale.VERBALE.USCITA_SALA));
		String valore9 = valutaOrario(verbale.getValue(Verbale.VERBALE.USCITA_BLOCCO));
		String valore10 = verbale.getValue(Verbale.VERBALE.TIPO_ANESTESIA);
		String valore11 = verbale.getValue(Verbale.VERBALE.RISCHIO_ANESTESIA);
		String valore12 = verbale.getValue(Verbale.VERBALE.PRIMO_OPERATORE);
		String valore13 = verbale.getValue(Verbale.VERBALE.SECONDO_OPERATORE);
		String valore14 = verbale.getValue(Verbale.VERBALE.TERZO_OPERATORE);
		String valore15 = verbale.getValue(Verbale.VERBALE.ANESTESISTA); 
		String valore16 = verbale.getValue(Verbale.VERBALE.STRUMENTISTA);
		String valore17 = verbale.getValue(Verbale.VERBALE.INFERMIERE);
		String valore18 = verbale.getValue(Verbale.VERBALE.AIUTO_ANESTESISTA);
		String valore19 = verbale.getValue(Verbale.VERBALE.TECNICO_RADIOLOGIA);
		String valore20 = verbale.getValue(Verbale.VERBALE.PROCEDURA);
		String valore21 = verbale.getValue(Verbale.VERBALE.CODICE_ANAGRAFICA);
		
		
		String[] valori = {
				valore0, valore1, valore2, valore3, valore4, valore5, valore6, valore7, valore8, valore9, 
				valore10, valore11, valore12, valore13, valore14, valore15, valore16, valore17, valore18,
				valore19, valore20, valore21
		};
		return valori;
	}
	
	protected String valutaOrario(LocalTime orario) {
		if(orario == null)
			return "";
		else 
			return orario.toString();
	}
	
	public boolean salvaVerbale(String codiceVerbale, String[] valori) {
		
		if(valori[5].equals("") || valori[6].equals("") || valori[6].equals("") || valori[11].equals("") 
				|| valori[13].equals("") || valori[17].equals("") || valori[20].equals("")) {
			return false;
		}
		
		//DA AGGIUNGERE IL CONTROLLO DELL'ANESTESIA
		
		create
		.update(Verbale.VERBALE)
		.set(Verbale.VERBALE.INGRESSO_BLOCCO, valori[0])
		.set(Verbale.VERBALE.INGRESSO_SALA, valori[1])
		.set(Verbale.VERBALE.POSIZIONAMENTO, valori[2])
		.set(Verbale.VERBALE.INIZIO_ANESTESIA, valori[3])
		.set(Verbale.VERBALE.FINE_ANESTESIA, valori[4])
		.set(Verbale.VERBALE.INIZIO_INTERVENTO, valori[5])
		.set(Verbale.VERBALE.FINE_INTERVENTO, valori[6])
		.set(Verbale.VERBALE.RISVEGLIO, valori[7])
		.set(Verbale.VERBALE.USCITA_SALA, valori[8])
		.set(Verbale.VERBALE.USCITA_BLOCCO, valori[9])
		.set(Verbale.VERBALE.TIPO_ANESTESIA, valori[10])
		.set(Verbale.VERBALE.RISCHIO_ANESTESIA, valori[11])
		.set(Verbale.VERBALE.PRIMO_OPERATORE, valori[12])
		.set(Verbale.VERBALE.SECONDO_OPERATORE, valori[13])
		.set(Verbale.VERBALE.TERZO_OPERATORE, valori[14])
		.set(Verbale.VERBALE.ANESTESISTA, valori[15])
		.set(Verbale.VERBALE.STRUMENTISTA, valori[16])
		.set(Verbale.VERBALE.INFERMIERE, valori[17])
		.set(Verbale.VERBALE.AIUTO_ANESTESISTA, valori[18])
		.set(Verbale.VERBALE.TECNICO_RADIOLOGIA, valori[19])
		.set(Verbale.VERBALE.PROCEDURA, valori[20])
		.set(Verbale.VERBALE.CODICE_ANAGRAFICA, valori[21])
		.where(Verbale.VERBALE.CODICE.eq(codiceVerbale))
		.execute();
		
		return true;
	}


	public String getCodiceVerbale(String codiceVerbale) {
		if(codiceVerbale.equals("")){
			String nuovoCodice = generaNuovoCodice("Verbale");
			creaNuovoVerbale(nuovoCodice);			
			return nuovoCodice;
		}
		else 	
			return codiceVerbale;
	}


	private void creaNuovoVerbale(String nuovoCodice) {
		VerbaleRecord nuovoVerbale = new VerbaleRecord(
				nuovoCodice, null, null, null, null, null, null, null, null, null, null, 
				"", "", "", "", "", "", "", "", "", "", "", "");
		int result = create.insertInto(Verbale.VERBALE).set(nuovoVerbale).execute();
		System.out.println(result); // stampa 1 se tutto andato bene
		
	}


	public String ora(String orario) {
		if(orario.equals("")) {
			return "    ";
		}
		else {
			int posizioneFinale = orario.indexOf(":");
			return orario.substring(0, posizioneFinale);
		}
		
	}
	
	public String minuto(String orario) {
		if(orario.equals("")) {
			return "    ";
		}
		else {
			int posizioneIniziale = orario.indexOf(":") + 1;
			return orario.substring(posizioneIniziale);
		}
	}


	public String getDiagnosiAnagrafica(String codiceAnagrafica) {
		String[] valori = getValoriAnagrafica(codiceAnagrafica, "");
		return valori[11];
	}
	
	
	public String getInterventoAnagrafica(String codiceAnagrafica) {
		String[] valori = getValoriAnagrafica(codiceAnagrafica, "");
		return valori[12];
	}


	


	

}
	
	
