package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
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
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchOne();
	}
	
	private AnagraficaRecord getAnagrafica(String codiceAnagrafica) {
		return create
			    .selectFrom(Anagrafica.ANAGRAFICA)
			    .where(Anagrafica.ANAGRAFICA.CODICE.eq(codiceAnagrafica))
			    .fetchOne();
	}
	
	private OperazioneRecord getOperazione(String codiceOperazione) {
		return create
			    .selectFrom(Operazione.OPERAZIONE)
			    .where(Operazione.OPERAZIONE.CODICE.eq(codiceOperazione))
			    .fetchOne();
	}

	private VerbaleRecord getVerbale(String codiceVerbale) {
		return create
			    .selectFrom(Verbale.VERBALE)
			    .where(Verbale.VERBALE.CODICE.eq(codiceVerbale))
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

	public String salvaAnagrafica(String codiceAnagrafica, String[] valori, boolean nuova) {
		//se ci sono campi vuoti, ad eccezioni delle note, non va bene
		for(int i = 0; i < 17; i++) {
			if(valori[i].equals(""))
				return "-1";
		}
		
		if(nuova) {
			creaNuovaAnagrafica(codiceAnagrafica);
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
		.where(Anagrafica.ANAGRAFICA.CODICE.eq(codiceAnagrafica))
		.execute();
		
		return codiceAnagrafica;
	}

	public String[] getValoriAnagrafica(String codiceAnagrafica, String matricolaMedico) {
		
		AnagraficaRecord anagrafica = create
	            .selectFrom(Anagrafica.ANAGRAFICA)
	            .where(Anagrafica.ANAGRAFICA.CODICE.eq(codiceAnagrafica))
	            .fetchOne();
		
		String valore0 = anagrafica.getNome();
		String valore1 = anagrafica.getCognome();
		String valore2 = anagrafica.getCodiceFiscale();
		String valore3 = anagrafica.getGiornoNascita();
		String valore4 = anagrafica.getMeseNascita();
		String valore5 = anagrafica.getAnnoNascita();
		String valore6 = anagrafica.getLuogoNascita();
		String valore7 = anagrafica.getCitta();
		String valore8 = anagrafica.getIndirizzo();
		String valore9 = anagrafica.getTelefono();
		String valore10 = anagrafica.getEmail();
		String valore11 = anagrafica.getDiagnosi();
		String valore12 = anagrafica.getIntervento();
		String valore13 = anagrafica.getAnamnesiPregressa();
		String valore14 = anagrafica.getAnamnesiProssima();
		String valore15 = anagrafica.getTempoAttesa();
		String valore16 = anagrafica.getMatrMedico();
		//se la matricola del medico � vuota significa che quella che sta venendo visualizzata � un'anagrafica
		//nuova e quindi il medico richiedente � quello che sta compilando
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
		getAnagrafica(codiceAnagrafica).delete();
		
		decrementaCodice(codiceAnagrafica, "Anagrafica");
		
		String operazioneAssociata = getOperazioneAssociata(codiceAnagrafica);
		if(!operazioneAssociata.equals("")) {
			eliminaOperazione(operazioneAssociata);
		}
		
	}


	public void decrementaCodice(String codice, String tipo) {
		int contatore = getContatoreCodice(tipo);
		//decremeento il contatore del codice a cui si � arrivati solo se nel frattempo 
		//non sono state create altre anagrafice/operazioni/verbali, altrimenti ci sarebbero probelimi 
		//di non univocit� delle chiavi. Se non si pu� decrementare il codice, si accetta di perdere
		//delle potenziali chiavi.
		if(contatore == Integer.valueOf(codice)) {
			create.update(Codice.CODICE)
	        .set(Codice.CODICE.CONTATORE, contatore - 1)
	        .where(Codice.CODICE.TIPO.eq(tipo))
	        .execute();
		}			
				
	} 


	public String[] getValoriVerbale(String codiceVerbale) {

		VerbaleRecord verbale = getVerbale(codiceVerbale);
		
		String valore0 = verbale.getIngressoBlocco();
		String valore1 = verbale.getIngressoSala();
		String valore2 = verbale.getPosizionamento();
		String valore3 = verbale.getInizioAnestesia();
		String valore4 = verbale.getFineAnestesia();
		String valore5 = verbale.getInizioIntervento();
		String valore6 = verbale.getFineIntervento();
		String valore7 = verbale.getRisveglio();
		String valore8 = verbale.getUscitaSala();
		String valore9 = verbale.getUscitaBlocco();
		String valore10 = verbale.getTipoAnestesia();
		String valore11 = verbale.getRischioAnestesia();
		String valore12 = verbale.getPrimoOperatore();
		String valore13 = verbale.getSecondoOperatore();
		String valore14 = verbale.getTerzoOperatore();
		String valore15 = verbale.getAnestesista(); 
		String valore16 = verbale.getStrumentista();
		String valore17 = verbale.getInfermiere();
		String valore18 = verbale.getAiutoAnestesista();
		String valore19 = verbale.getTecnicoRadiologia();
		String valore20 = verbale.getProcedura();
		String valore21 = verbale.getCodiceOperazione();
		String valori22 = verbale.getDataOraCreazione();
				
		String[] valori = {
				valore0, valore1, valore2, valore3, valore4, valore5, valore6, valore7, valore8, valore9, 
				valore10, valore11, valore12, valore13, valore14, valore15, valore16, valore17, valore18,
				valore19, valore20, valore21, valori22
		};
		return valori;
	}
	
	
	
	public String salvaVerbale(String codiceVerbale, String[] valori, boolean nuovo) {
		
		//controllo dei campi obbligatori
		if(valori[5].equals("") || valori[6].equals("") || valori[6].equals("") || valori[12].equals("") 
				|| valori[17].equals("") || valori[20].equals("")) {
			return "-1";
		}
		
		//controlli dei ruoli del personale inserito
		if(!esisteDipendente(valori[12]) || !getRuoloDipendente(valori[12]).equals("Medico")) {
			return "-2";
		}
		
		if(!valori[13].equals("nessun operatore") && 
				(!esisteDipendente(valori[13]) || !getRuoloDipendente(valori[13]).equals("Medico"))) {
			return "-3";
		}
		
		if(!valori[14].equals("") && 
				(!esisteDipendente(valori[14]) || !getRuoloDipendente(valori[14]).equals("Medico"))) {
			return "-4";
		}
		
		if(!valori[15].equals("") && 
				(!esisteDipendente(valori[15]) || !getRuoloDipendente(valori[15]).equals("Medico"))) {
			return "-5";
		}
		
		if(!valori[16].equals("") && 
				(!esisteDipendente(valori[16]) || !getRuoloDipendente(valori[16]).equals("Infermiere"))) {
			return "-6";
		}
		
		if(!esisteDipendente(valori[17]) || !getRuoloDipendente(valori[17]).equals("Infermiere")) {
			return "-7";
		}
		
		if(!valori[18].equals("") && 
				(!esisteDipendente(valori[18]) || !getRuoloDipendente(valori[18]).equals("Infermiere"))) {
			return "-8";
		}
		
		if(!valori[19].equals("") && !esisteDipendente(valori[19])) {
			return "-9";
		}
		
		if(nuovo) {
			creaNuovoVerbale(codiceVerbale);
		}
		
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
		.set(Verbale.VERBALE.CODICE_OPERAZIONE, valori[21])
		.where(Verbale.VERBALE.CODICE.eq(codiceVerbale))
		.execute();
		
		return codiceVerbale;
	}


	private void creaNuovoVerbale(String nuovoCodice) {
       
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String questoIstante = LocalDateTime.now().format(formatter);
		
		VerbaleRecord nuovoVerbale = new VerbaleRecord(
				nuovoCodice, "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "", "", "", "", questoIstante);
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



	private void creaNuovaOperazione(String nuovoCodice, String matricolaMedico) {
		OperazioneRecord nuovaOperazione = new OperazioneRecord(nuovoCodice, "", "    ", false, "", "", matricolaMedico);
		int result = create.insertInto(Operazione.OPERAZIONE).set(nuovaOperazione).execute();
		System.out.println(result); // stampa 1 se tutto andato bene
		
	}


	public String[] getValoriOperazione(String codiceOperazione) {
		OperazioneRecord operazione = getOperazione(codiceOperazione);
		String valore0 = operazione.getValue(Operazione.OPERAZIONE.CODICE_ANAGRAFICA);
		String valore1 = operazione.getValue(Operazione.OPERAZIONE.BLOCCO);
		String valore2 = operazione.getValue(Operazione.OPERAZIONE.SALA);
		String valore3 = operazione.getValue(Operazione.OPERAZIONE.ANESTESIA).toString();
		String valore4 = operazione.getValue(Operazione.OPERAZIONE.PRIMO_OPERATORE);
				
		String[] valori = {valore0, valore1, valore2, valore3, valore4};
		
		return valori;		
	}


	public String getNomeAnagrafica(String codiceAnagrafica) {
		return getAnagrafica(codiceAnagrafica).getNome();
	}
	
	
	public String getCognomeAnagrafica(String codiceAnagrafica) {
		return getAnagrafica(codiceAnagrafica).getCognome();
	}


	public String getNascitaAnagrafica(String codiceAnagrafica) {
		AnagraficaRecord anagrafica = getAnagrafica(codiceAnagrafica);
		return anagrafica.getGiornoNascita() + "/" + anagrafica.getMeseNascita() + "/" + anagrafica.getAnnoNascita();
	}


	public String salvaOperazione(String codiceOperazione, String matricolaMedico, String[] valori, boolean nuova) {
		if(valori[1].equals("") || valori[2].equals("") || valori[4].equals("")){
			return "-1";
		}
		
		if(!esisteDipendente(valori[4]) || !getRuoloDipendente(valori[4]).equals("Medico")) {
			return "-2";
		}
		
		if(nuova) {
			creaNuovaOperazione(codiceOperazione, matricolaMedico);
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
		
		return codiceOperazione;
	}


	public void eliminaOperazione(String codiceOperazione) {
		getOperazione(codiceOperazione).delete();		
		decrementaCodice(codiceOperazione, "Operazione");
		
		String verbaleAssociato = getVerbaleAssociato(codiceOperazione);
		if(!verbaleAssociato.equals("")) {
			eliminaVerbale(verbaleAssociato);
		}
	}


	public void eliminaVerbale(String codiceVerbale) {
		getVerbale(codiceVerbale).delete();
		decrementaCodice(codiceVerbale, "Verbale");
	}

	public String getCodiceAnagraficaOperazione(String codiceOperazione) {
		return getOperazione(codiceOperazione).getCodiceAnagrafica();
	}
	
	public String getDiagnosiOperazione(String codiceOperazione) {
		return getDiagnosiAnagrafica(getCodiceAnagraficaOperazione(codiceOperazione));
	}

	public String getInterventoOperazione(String codiceOperazione) {
		return getInterventoAnagrafica(getCodiceAnagraficaOperazione(codiceOperazione));
	}

	public boolean esisteAnagrafica(String codiceAnagrafica) {
		return getAnagrafica(codiceAnagrafica) != null;
	}
	
	public boolean esisteOperazione(String codiceOperazione) {
		return getOperazione(codiceOperazione) != null;
	}
	
	public boolean esisteVerbale(String codiceVerbale) {
		return getVerbale(codiceVerbale) != null;
	}
	
	public boolean esisteDipendente(String matricolaDipendente) {
		return getDipendente(matricolaDipendente) != null;
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

	public String getMatrMedicoAnagrafica(String codiceAnagrafica) {
		return getAnagrafica(codiceAnagrafica).getMatrMedico();
	}
	
	private String getMedicoSchedulazioneOperazione(String codiceOperazione) {
		return getOperazione(codiceOperazione).getMedicoSchedulazione();
	}
	
	private String getPrimoOperatoreVerbale(String codiceVerbale) {
		return getVerbale(codiceVerbale).getPrimoOperatore();
	}
	
	private Duration getTempoPassatoVerbale(String codiceOperazione) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dataOraCreazione = LocalDateTime.parse(getVerbale(codiceOperazione).getDataOraCreazione(), formatter);
		return Duration.between(dataOraCreazione, LocalDateTime.now());
	}



	//una pagina anagrafica e' modificabile ed eliminabile solo da chi l'ha creata e solo se 
	//non �' ha ancora un'operazione associata 
	public boolean anagraficaModificabile(String codiceAnagrafica, String matricolaMedico) {
		if(matricolaMedico.equals(getMatrMedicoAnagrafica(codiceAnagrafica)) &&
				getOperazioneAssociata(codiceAnagrafica).equals("")){
			return true;
		}
		return false;
	}

	//un'operazione e' modificabile ed eliminabile solo da chi l'ha creata e solo se 
	//non �' ha ancora un verbale associato
	public boolean operazioneModificabile(String codiceOperazione, String matricolaMedico) {
		if(matricolaMedico.equals(getMedicoSchedulazioneOperazione(codiceOperazione)) &&
				getVerbaleAssociato(codiceOperazione).equals("")){
			return true;
		}
		return false;
	}

	//un verbale e' modificabile ed eliminabile solo dal primo operatore e solo se 
	//non �' ha ancora passato un giorno dalla sua creazione
	public boolean verbaleModificabile(String codiceVerbale, String matricolaMedico) {
		
		if(matricolaMedico.equals(getPrimoOperatoreVerbale(codiceVerbale)) &&
				getTempoPassatoVerbale(codiceVerbale).toDays() < 1){
			return true;
		}
		return false;
	}


}
	
	
