package no.hvl.dat109.tester;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class YatzyTester {
	
	// Tester klassen for yatzy kjøring
	// (Kan være en fordel å lage en testklasse for klasse som skal testes, inkludert main, for seg selv
	
	// Oppretting av alle varibler/objekter som trenger testing
	
	// private Terning terning;
	// private Spiller spiller;
	// private ...
	
	// Testmetode for terning
	// Terning triller innenfor riktige verdier og er rettferdig (helt tilfeldig)
	
	// Kjører før hver test
	@BeforeEach
	public void oppsettAvTerning() throws Exception {
		
		 // terning = new Terning();
		
	}
	
	@Test
	public void riktigVerdi() {
		
		// terning.trill bla bla
		
	}
	
	
	// Testmetode for spiller
	// Oppretter et spillerobjekt
	// Tester funksjonalitet for spiller
	
	// Kjører før hver test (vet ikke om man kan gjøre dette 2 ganger i en testklasse
	@BeforeEach
	public void oppsettAvSpiller() throws Exception {
		
		 // terning = new Terning();
		
	}
	
	// Denne må nok deles opp i flere tester (gyldig e-post, gyldige verdier ellers, osv..)
	@Test
	public void riktigeVerdierSattInn() {
		
		
	}
	
	// Dokumentasjon for å sette opp testing:
	// https://www.vogella.com/tutorials/JUnit/article.html

}
