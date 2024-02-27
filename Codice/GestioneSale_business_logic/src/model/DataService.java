package model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;

import org.jooq.impl.DSL;

import model.generated.tables.*;
import model.generated.tables.records.*;
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
	
	private DipendenteRecord getDipendente(String matricola) {
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle();
	}
	
	private OperazioneRecord getOperazione(String codiceOperazione) {
		return create
			    .selectFrom(Operazione.OPERAZIONE)
			    .where(Operazione.OPERAZIONE.CODICE.eq(codiceOperazione))
			    .fetchOne();
	}


	public String getRuoloDipendente(String matricola) {
		return getDipendente(matricola).getRuolo();
	}
	

	public String getNomeDipendente(String matricola) { 
		return getDipendente(matricola).getNome();
	}
	
	public String getCognomeDipendente(String matricola) { 
		return getDipendente(matricola).getCognome();
	}
	
	public int getContatoreCodice(String tipo) {
		return create
	        .selectFrom(Codice.CODICE)
	        .where(Codice.CODICE.TIPO.eq(tipo))
	        .fetchOne()
	        .getContatore();
	}
	
	//questa funzione prende il contatore dei codici nel database e da quello ne genera uno nuovo
	//in modo incrementale e aggiorna il contatore
	public String generaNuovoCodice(String tipo) {
		int nuovoCodice = 1 + getContatoreCodice(tipo);
				
		create.update(Codice.CODICE)
        .set(Codice.CODICE.CONTATORE, nuovoCodice)
        .where(Codice.CODICE.TIPO.eq(tipo))
        .execute();
		
		return String.valueOf(nuovoCodice);	
	}
	
	public String getPazienteAnagrafica(String codiceAnagrafica) {
		String[] valori = getValoriAnagrafica(codiceAnagrafica, "");
		return valori[0] + " " + valori [1];
	}
	
	
	//crea una nuova anagrafica con tutti i campi standard
	private void creaNuovaAnagrafica(String nuovoCodice) {
		AnagraficaRecord nuovaAnagrafica = new AnagraficaRecord(
				nuovoCodice,"","","","","","","","","", "", "", "", "", "", "", "", "", "");
		int result = create.insertInto(Anagrafica.ANAGRAFICA).set(nuovaAnagrafica).execute();
		System.out.println(result); // stampa 1 se tutto andato bene
	}

	public boolean salvaAnagrafica(String codice, String[] valori, boolean nuova) {
		//se ci sono campi vuoti, ad eccezioni delle note, non va bene
		for(int i = 0; i < 17; i++) {
			if(valori[i].equals(""))
				return false;
		}
		
		if(nuova) {
			creaNuovaAnagrafica(codice);
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
	
	
	public void eliminaAnagrafica(String codiceAnagrafica) {
		create.deleteFrom(Anagrafica.ANAGRAFICA)
		.where(Anagrafica.ANAGRAFICA.CODICE.eq(codiceAnagrafica))
		.execute();
		
		decrementaCodice(codiceAnagrafica, "Anagrafica");
		
		String operazioneAssociata = getOperazioneAssociata(codiceAnagrafica);
		if(!operazioneAssociata.equals("")) {
			eliminaOperazione(operazioneAssociata);
		}
		
	}


	public void decrementaCodice(String codice, String tipo) {
		int contatore = getContatoreCodice(tipo);
		//decremeento il contatore del codice a cui si è arrivati solo se nel frattempo 
		//non sono state create altre anagrafice/operazioni/verbali, altrimenti ci sarebbero probelimi 
		//di non univocità delle chiavi. Se non si può decrementare il codice, si accetta di perdere
		//delle potenziali chiavi.
		if(contatore == Integer.valueOf(codice)) {
			create.update(Codice.CODICE)
	        .set(Codice.CODICE.CONTATORE, contatore - 1)
	        .where(Codice.CODICE.TIPO.eq(tipo))
	        .execute();
		}
			
			
				
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
		String valore21 = verbale.getValue(Verbale.VERBALE.CODICE_OPERAZIONE);
		
		
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
	
	public boolean salvaVerbale(String codiceVerbale, String[] valori, boolean nuovo) {
		
		if(valori[5].equals("") || valori[6].equals("") || valori[6].equals("") || valori[11].equals("") 
				|| valori[13].equals("") || valori[17].equals("") || valori[20].equals("")) {
			return false;
		}
		
		//DA AGGIUNGERE IL CONTROLLO DELL'ANESTESIA
		
		if(nuovo) {
			creaNuovoVerbale(codiceVerbale);
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		create
		.update(Verbale.VERBALE)
		.set(Verbale.VERBALE.INGRESSO_BLOCCO, LocalTime.parse(valori[0], formatter))
		.set(Verbale.VERBALE.INGRESSO_SALA, LocalTime.parse(valori[1], formatter))
		.set(Verbale.VERBALE.POSIZIONAMENTO, LocalTime.parse(valori[2], formatter))
		.set(Verbale.VERBALE.INIZIO_ANESTESIA, LocalTime.parse(valori[3], formatter))
		.set(Verbale.VERBALE.FINE_ANESTESIA, LocalTime.parse(valori[4], formatter))
		.set(Verbale.VERBALE.INIZIO_INTERVENTO, LocalTime.parse(valori[5], formatter))
		.set(Verbale.VERBALE.FINE_INTERVENTO, LocalTime.parse(valori[6], formatter))
		.set(Verbale.VERBALE.RISVEGLIO, LocalTime.parse(valori[7], formatter))
		.set(Verbale.VERBALE.USCITA_SALA, LocalTime.parse(valori[8], formatter))
		.set(Verbale.VERBALE.USCITA_BLOCCO, LocalTime.parse(valori[9], formatter))
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
		.set(Verbale.VERBALE.CODICE_OPERAZIONE, valori[21])
		.where(Verbale.VERBALE.CODICE.eq(codiceVerbale))
		.execute();
		
		return true;
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



	private void creaNuovaOperazione(String nuovoCodice) {
		OperazioneRecord nuovaOperazione = new OperazioneRecord(nuovoCodice, "", "    ", false, "", "");
		int result = create.insertInto(Operazione.OPERAZIONE).set(nuovaOperazione).execute();
		System.out.println(result); // stampa 1 se tutto andato bene
		
	}


	public String[] getValoriOperazione(String codiceOperazione) {
		OperazioneRecord operazione = create
	            .selectFrom(Operazione.OPERAZIONE)
	            .where(Operazione.OPERAZIONE.CODICE.eq(codiceOperazione))
	            .fetchOne();
		
		String valore0 = operazione.getValue(Operazione.OPERAZIONE.CODICE_ANAGRAFICA);
		String valore1 = operazione.getValue(Operazione.OPERAZIONE.BLOCCO);
		String valore2 = operazione.getValue(Operazione.OPERAZIONE.SALA);
		String valore3 = operazione.getValue(Operazione.OPERAZIONE.ANESTESIA).toString();
		String valore4 = operazione.getValue(Operazione.OPERAZIONE.PRIMO_OPERATORE);
				
		String[] valori = {valore0, valore1, valore2, valore3, valore4};
		
		return valori;
		
		
	}


	public String getNomeAnagrafica(String codiceAnagrafica) {
		String[] valori = getValoriAnagrafica(codiceAnagrafica, "");
		return valori[0];
	}
	
	
	public String getCognomeAnagrafica(String codiceAnagrafica) {
		String[] valori = getValoriAnagrafica(codiceAnagrafica, "");
		return valori[1];
	}


	public String getNascitaAnagrafica(String codiceAnagrafica) {
		String[] valori = getValoriAnagrafica(codiceAnagrafica, "");
		return valori[3] + "/" + valori[4] + "/" + valori[5];
	}


	public int salvaOperazione(String codiceOperazione, String[] valori, boolean nuova) {
		if(valori[1].equals("") || valori[2].equals("    ") || valori[4].equals("")){
			return 1;
		}
		
		if(!esisteDipendente(valori[4]) || !getRuoloDipendente(valori[4]).equals("Medico")) {
			return 2;
		}
		
		if(nuova) {
			creaNuovaOperazione(codiceOperazione);
		}
		
		create
		.update(Operazione.OPERAZIONE)
		.set(Operazione.OPERAZIONE.BLOCCO,valori[1])
		.set(Operazione.OPERAZIONE.SALA, valori[2])
		.set(Operazione.OPERAZIONE.ANESTESIA, Boolean.valueOf(valori[3]))
		.set(Operazione.OPERAZIONE.PRIMO_OPERATORE, valori[4])
		.set(Operazione.OPERAZIONE.CODICE_ANAGRAFICA, valori[0])
		.where(Operazione.OPERAZIONE.CODICE.eq(codiceOperazione))
		.execute();
		
		return 0;
	}


	public void eliminaOperazione(String codiceOperazione) {
		create.deleteFrom(Operazione.OPERAZIONE)
		.where(Operazione.OPERAZIONE.CODICE.eq(codiceOperazione))
		.execute();
		
		decrementaCodice(codiceOperazione, "Operazione");
		
		String verbaleAssociato = getVerbaleAssociato(codiceOperazione);
		if(!verbaleAssociato.equals("")) {
			eliminaVerbale(verbaleAssociato);
		}
	}


	public void eliminaVerbale(String codiceVerbale) {
		create.deleteFrom(Verbale.VERBALE)
		.where(Verbale.VERBALE.CODICE.eq(codiceVerbale))
		.execute();
	}


	public String getDiagnosiOperazione(String codiceOperazione) {
		String[] valoriOperazione = getValoriOperazione(codiceOperazione);
		return getDiagnosiAnagrafica(valoriOperazione[0]);
	}

	public String getInterventoOperazione(String codiceOperazione) {
		String[] valoriOperazione = getValoriOperazione(codiceOperazione);
		return getInterventoAnagrafica(valoriOperazione[0]);
	}


	public String getCodiceAnagraficaOperazione(String codiceOperazione) {
		String[] valori = getValoriOperazione(codiceOperazione);
		return valori[0];
	}


	public boolean esisteAnagrafica(String codiceAnagrafica) {
		AnagraficaRecord anagrafica = create
	            .selectFrom(Anagrafica.ANAGRAFICA)
	            .where(Anagrafica.ANAGRAFICA.CODICE.eq(codiceAnagrafica))
	            .fetchOne();
		return anagrafica != null;
	}
	
	public boolean esisteOperazione(String codiceOperazione) {
		OperazioneRecord operazione = create
	            .selectFrom(Operazione.OPERAZIONE)
	            .where(Operazione.OPERAZIONE.CODICE.eq(codiceOperazione))
	            .fetchOne();
		return operazione != null;
	}
	
	public boolean esisteVerbale(String codiceVerbale) {
		VerbaleRecord verbale = create
	            .selectFrom(Verbale.VERBALE)
	            .where(Verbale.VERBALE.CODICE.eq(codiceVerbale))
	            .fetchOne();
		return verbale != null;
	}
	
	public boolean esisteDipendente(String matricolaDipendente) {
		DipendenteRecord dipendente = create
	            .selectFrom(Dipendente.DIPENDENTE)
	            .where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricolaDipendente))
	            .fetchOne();
		return dipendente != null;
	}


	public String getOperazioneAssociata(String codiceAnagrafica) {
		OperazioneRecord operazione = create
			    .selectFrom(Operazione.OPERAZIONE)
			    .where(Operazione.OPERAZIONE.CODICE_ANAGRAFICA.eq(codiceAnagrafica))
			    .fetchOne();
		if(operazione == null) {
			return "";
		}
		return operazione.getCodice();
	}


	public String getVerbaleAssociato(String codiceOperazione) {
		VerbaleRecord verbale = create
				.selectFrom(Verbale.VERBALE)
				.where(Verbale.VERBALE.CODICE_OPERAZIONE.eq(codiceOperazione))
				.fetchOne();
		if(verbale == null) {
			return "";
		}
		return verbale.getCodice();
	}


	public boolean getAnestesiaOperazione(String codiceOperazione) {
		return getOperazione(codiceOperazione).getAnestesia();
	}
	

}
	
	
