import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.DataService;
import model.generated.tables.Operazione;

class CasiDiTest {
	
	@Test
	public void testSuccessLogin() {
		//Simuliamo un utente con credenziali d'accesso
		String username = "m001a";
		String password = "psw1";
		
		//Creiamo un'istanza del sistema di login
		DataService dataService = new DataService();
		
		//Effettuaimo il login con le credenziali valide
		boolean loginResult = dataService.credenzialiCorrette(username, password.toCharArray());
		
		//Verifichiamo che il login sia stato effettuato con successo
		assertTrue(loginResult);
	}
	
	@Test
	public void TestInvalidPassword() {
		//Simuliamo un utente con credenziali non archiviate
		String username = "m001a";
		String password = "invalidPassword";
		
		//Creiamo un'istanza del sistema di login
		DataService dataService = new DataService();
		
		//Effettuiamo un login con credenziali non valide
		boolean loginResult = dataService.credenzialiCorrette(username, password.toCharArray());
		
		//Verifichiamo che il login sia fallito
		assertFalse(loginResult);
	}
	
	@Test
	public void TestInvalidUserName() {
		//Simuliamo un utente con credenziali non archiviate
		String username = "invalidUsername";
		String password = "psw1";
		
		//Creiamo un'istanza del sistema di login
		DataService dataService = new DataService();
		
		//Effettuiamo un login con credenziali non valide
		boolean loginResult = dataService.credenzialiCorrette(username, password.toCharArray());
		
		//Verifichiamo che il login sia fallito
		assertFalse(loginResult);
	}
	
	@Test
	public void VerbaleInesistente() {
		//Simuliamo di voler trovare un determinato verbale medico rispetto al codice operazione
		String codiceOperazione = "4501";
		
		//Creiamo un'istanza del sistema
		DataService dataService = new DataService();
		
		//Effettuiamo una ricerca del verbale rispetto al codice operazione
		String result = dataService.getVerbaleAssociato(codiceOperazione);
		
		//Verifichiamo che la ricerca riporti un codice verbale inesistente
		assertEquals(result, "");
	}

	

}
