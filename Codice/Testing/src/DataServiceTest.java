import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.DataService;

class CasiDiTest {
	
	private DataService dataService = new DataService();
	
	private boolean confrontaArray(String[] str1, String[] str2) {
		if(str1.length != str2.length) {
			return false;
		}
		for (int i = 0; i < str1.length; i++) {
			if(!str1[i].equals(str2[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testSuccessLogin() {
		//Simuliamo un utente con credenziali d'accesso
		String username = "m001a";
		String password = "psw1";
				
		//Effettuaimo il login con le credenziali valide
		boolean loginResult = dataService.credenzialiCorrette(username, password.toCharArray());
		
		//Verifichiamo che il login sia stato effettuato con successo
		assertTrue(loginResult);
	}
	
	@Test
	public void testInvalidPassword() {
		//Simuliamo un utente con credenziali non archiviate
		String username = "m001a";
		String password = "invalidPassword";
		
		//Effettuiamo un login con credenziali non valide
		boolean loginResult = dataService.credenzialiCorrette(username, password.toCharArray());
		
		//Verifichiamo che il login sia fallito
		assertFalse(loginResult);
	}
	
	@Test
	public void testInvalidUserName() {
		//Simuliamo un utente con credenziali non archiviate
		String username = "invalidUsername";
		String password = "psw1";
		
		//Effettuiamo un login con credenziali non valide
		boolean loginResult = dataService.credenzialiCorrette(username, password.toCharArray());
		
		//Verifichiamo che il login sia fallito
		assertFalse(loginResult);
	}
	
	@Test
	public void verbaleInesistente() {
		//Simuliamo di voler trovare un determinato verbale medico rispetto al codice operazione
		String codiceOperazione = "-1";
		
		//Effettuiamo una ricerca del verbale rispetto al codice operazione
		String result = dataService.getVerbaleAssociato(codiceOperazione);
		
		//Verifichiamo che la ricerca riporti un codice verbale inesistente
		assertEquals(result, "");
	}
	
	@Test
	public void ruoloDipendenteSbagliato() {
		
		//Cerchiamo il ruolo di un dipendente dell'ospedale
		String matricola = "m001a";
		String ruolo = "infermiere";
		
		String cercaRuolo = dataService.getRuoloDipendente(matricola);
		
		//Verifichiamo che il ruolo dichiarato non corrisponde a quello vero
		if(cercaRuolo.equals(ruolo)) {
			fail("ruolo non corrispondente");
		}
	}
	
	@Test
	public void salvataggioEdEliminazioneOperazioneRiusciti() {
		
		//Simuliamo il salvataggio di un'operazione che non fallisce
		String valori[] = new String[5];
		valori[0] = "1";
		valori[1] = "Blu";
		valori[2] = "14";
		valori[3] = "true";
		valori[4] = "m001a";
		boolean n = true;
		String codiceOperazione = "800";
		String matricolaDipendente = "m001a";
		
		String risultatoSalvataggio = dataService.salvaOperazione(codiceOperazione, matricolaDipendente, valori, n);
		
		assertTrue(
				Integer.parseInt(risultatoSalvataggio) > 0 &&
				confrontaArray(dataService.getValoriOperazione(codiceOperazione), valori)
				);
		
		dataService.eliminaOperazione(codiceOperazione);
		assertFalse(dataService.esisteOperazione(codiceOperazione));
		
	}
	
	
	@Test
	public void salvataggioOperazioneMedicoInesistente() {
			
		//Simuliamo il salvataggio di un'operazione che fallise a causa di 
		//un errore nell'inserimento della matricola del medico
		String valoriMatricolaInesistente[] = {
				"1",
				"Blu",
				"14",
				"true",
				"matricolaInesistente"
		};
					
		String valoriMatricolaInfermiere[] = {
				"1",
				"Blu",
				"14",
				"true",
				"i001a"
		};
		
		String codiceOperazione1 = "300";
		String codiceOperazione2 = "400";
		String matricolaDipendente = "m001a";
		
		boolean nuovo = true;
		
		String risultatoSalvataggio1 = dataService.salvaOperazione(codiceOperazione1, matricolaDipendente, valoriMatricolaInesistente, nuovo);
		String risultatoSalvataggio2 = dataService.salvaOperazione(codiceOperazione2, matricolaDipendente, valoriMatricolaInfermiere, nuovo);
		
		assertEquals(risultatoSalvataggio1, "-2");
		assertEquals(risultatoSalvataggio2, "-2");
	}

	@Test
	public void SalvataggioOperazionefallito() {
			
		//Simuliamo il salvataggio di un'operazione che fallisce a causa di 
		//mancato inserimento di valori obbligatori
		String valori1[] = {
			"1",
			"",
			"14",
			"true",
			"matricolaInesistente"
		};
		
		String valori2[] = {
			"1",
			"Blu",
			"",
			"true",
			"matricolaInesistente"
		};
		
		String valori3[] = {
			"1",
			"Blu",
			"14",
			"true",
			""
		};
		
		String codiceOperazione1 = "120";
		String codiceOperazione2 = "121";
		String codiceOperazione3 = "122";
		String matricolaDipendente = "m001a";
		
		boolean nuovo = true;
		
		String risultatoSalvataggio1 = dataService.salvaOperazione(codiceOperazione1, matricolaDipendente, valori1, nuovo);
		String risultatoSalvataggio2 = dataService.salvaOperazione(codiceOperazione2, matricolaDipendente, valori2, nuovo);
		String risultatoSalvataggio3 = dataService.salvaOperazione(codiceOperazione3, matricolaDipendente, valori3, nuovo);

		
		assertEquals(risultatoSalvataggio1, "-1");
		assertEquals(risultatoSalvataggio2, "-1");
		assertEquals(risultatoSalvataggio3, "-1");
	}
	
	@Test
	public void eliminazioneOperazioneInesistente() {
		try {
			dataService.eliminaOperazione("matricolaInesistente");
		}catch(Exception e) {
			 fail("La funzione ha fallito con un'eccezione: " + e.getMessage());
		}		
	}
	
	
	

}
