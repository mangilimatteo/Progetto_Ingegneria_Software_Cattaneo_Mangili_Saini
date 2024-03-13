package model;

import java.sql.Connection;    
import java.sql.DriverManager;
import java.sql.SQLException;
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
	    DipendenteRecord DipendenteCorretto = getDipendente(matricola);

	    if (DipendenteCorretto == null) {
	        return false;
	    } else {
	        return psw.equals(DipendenteCorretto.getPassword().toCharArray()); //controllo che la psw sia corretta
	    }
	}
	
	private DipendenteRecord getDipendente(String matricola) {
		return create.selectFrom(Dipendente.DIPENDENTE).
				where(Dipendente.DIPENDENTE.MATRICOLA.eq(matricola)).fetchSingle();
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
		AnagraficaRecord anagrafica = getAnagrafica(codiceAnagrafica);
		return anagrafica.getNome() + " " + anagrafica.getCognome();
	}
	
	
	//crea una nuova anagrafica con tutti i campi standard
	private void creaNuovaAnagrafica(String nuovoCodice) {
		AnagraficaRecord nuovaAnagrafica = new AnagraficaRecord(
				nuovoCodice,"","","","","","","","","", "", "", "", "", "", "", "", "", "");
		int result = create.insertInto(Anagrafica.ANAGRAFICA).set(nuovaAnagrafica).execute();
		System.out.println(result); // stampa 1 se tutto andato bene
	}

	public boolean salvaAnagrafica(String codiceAnagrafica, String[] valori, boolean nuova) {
		//se ci sono campi vuoti, ad eccezioni delle note, non va bene
		for(int i = 0; i < 17; i++) {
			if(valori[i].equals(""))
				return false;
		}
		
		if(nuova) {
			creaNuovaAnagrafica(codiceAnagrafica);
		}
		
		//salvo tutto
		
		AnagraficaRecord anagrafica = getAnagrafica(codiceAnagrafica);
		
		anagrafica.setNome(valori[0]);
		anagrafica.setCognome(valori[1]);
		anagrafica.setCodiceFiscale(valori[2]);
		anagrafica.setGiornoNascita(valori[3]);
		anagrafica.setMeseNascita(valori[4]);
		anagrafica.setAnnoNascita(valori[5]);
		anagrafica.setLuogoNascita(valori[6]);
		anagrafica.setCitta(valori[7]);
		anagrafica.setIndirizzo(valori[8]);
		anagrafica.setTelefono(valori[9]);
		anagrafica.setEmail(valori[10]);
		anagrafica.setDiagnosi(valori[11]);
		anagrafica.setIntervento(valori[12]);
		anagrafica.setAnamnesiPregressa(valori[13]);
		anagrafica.setAnamnesiProssima(valori[14]);
		anagrafica.setTempoAttesa(valori[15]);
		anagrafica.setMatrMedico(valori[16]);
		anagrafica.setNote(valori[17]);
		
		return true;
	}

	public String[] getValoriAnagrafica(String codiceAnagrafica, String matricolaMedico) {
		
		AnagraficaRecord anagrafica = getAnagrafica(codiceAnagrafica);
		
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
		String valore17 = anagrafica.getNote();
		
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
				
		String[] valori = {
				valore0, valore1, valore2, valore3, valore4, valore5, valore6, valore7, valore8, valore9, 
				valore10, valore11, valore12, valore13, valore14, valore15, valore16, valore17, valore18,
				valore19, valore20, valore21
		};
		return valori;
	}
	
	
	
	public boolean salvaVerbale(String codiceVerbale, String[] valori, boolean nuovo) {
		
		if(valori[5].equals("") || valori[6].equals("") || valori[6].equals("") || valori[12].equals("") 
				|| valori[13].equals("") || valori[17].equals("") || valori[20].equals("")) {
			return false;
		}
				
		if(nuovo) {
			creaNuovoVerbale(codiceVerbale);
		}
		
		VerbaleRecord verbale = getVerbale(codiceVerbale);
		
		verbale.setIngressoBlocco(valori[0]);
		verbale.setIngressoSala(valori[1]);
		verbale.setPosizionamento(valori[2]);
		verbale.setInizioAnestesia(valori[3]);
		verbale.setFineAnestesia(valori[4]);
		verbale.setInizioIntervento(valori[5]);
		verbale.setFineIntervento(valori[6]);
		verbale.setRisveglio(valori[7]);
		verbale.setUscitaSala(valori[8]);
		verbale.setUscitaBlocco(valori[9]);
		verbale.setTipoAnestesia(valori[10]);
		verbale.setRischioAnestesia(valori[11]);
		verbale.setPrimoOperatore(valori[12]);
		verbale.setSecondoOperatore(valori[13]);
		verbale.setTerzoOperatore(valori[14]);
		verbale.setAnestesista(valori[15]);
		verbale.setStrumentista(valori[16]);
		verbale.setInfermiere(valori[17]);
		verbale.setAiutoAnestesista(valori[18]);
		verbale.setTecnicoRadiologia(valori[19]);
		verbale.setProcedura(valori[20]);
		verbale.setCodiceOperazione(valori[21]);
		
		return true;
	}


	private void creaNuovoVerbale(String nuovoCodice) {
		VerbaleRecord nuovoVerbale = new VerbaleRecord(
				nuovoCodice, "", "", "", "", "", "", "", "", "", "", 
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


	public int salvaOperazione(String codiceOperazione, String[] valori, boolean nuova) {
		if(valori[1].equals("") || valori[2].equals("") || valori[4].equals("")){
			return 1;
		}
		
		if(!esisteDipendente(valori[4]) || !getRuoloDipendente(valori[4]).equals("Medico")) {
			return 2;
		}
		
		if(nuova) {
			creaNuovaOperazione(codiceOperazione);
		}
		
		OperazioneRecord operazione = getOperazione(codiceOperazione);
		
		operazione.setBlocco(valori[1]);
		operazione.setSala(valori[2]);
		operazione.setAnestesia(Boolean.valueOf(valori[3]));
		operazione.setPrimoOperatore(valori[4]);
		
		return 0;
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
	

}
	
	
