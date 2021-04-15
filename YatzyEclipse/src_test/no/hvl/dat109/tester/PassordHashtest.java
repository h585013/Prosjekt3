package no.hvl.dat109.tester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import no.hvl.dat109.registreringOgLogin.Bruker;
import no.hvl.dat109.registreringOgLogin.PassordHjelper;

public class PassordHashtest {
	
	private static String passord;
	private static String salt;
	private static String hashetPassord;
	private static Bruker testBruker;
	
	@BeforeAll
	public static void Setup(){
		passord = "passord";
		salt = PassordHjelper.genererTilfeldigSalt();
		System.out.println("Salt er : " + salt);
		
		hashetPassord = PassordHjelper.hashMedSalt(passord, salt);
		System.out.println("Hashet passord er: " + hashetPassord);
		
		testBruker = new Bruker("TestBruker", "emailTest", hashetPassord, salt, null, 0);
	}
	
	@Test
	public void hentRiktigSalt() {
		assertEquals(salt, testBruker.getSalt());
	}
	
	public void hentRiktigPassord() {
		assertEquals(hashetPassord, testBruker.getPassord());
	}
	
	public void hentFeilPassord() {
		assertFalse(passord.equals(testBruker.getPassord()));
	}
	
	public void lagSammeHash() {
		assertEquals(hashetPassord, PassordHjelper.hashMedSalt(passord, salt));
	}
		
	public void validerRiktigPassord() {
		assertTrue(PassordHjelper.validerMedSalt(passord, salt, hashetPassord));
	}

	public void validerFeilPassord() {
		assertFalse(PassordHjelper.validerMedSalt("ikkeRiktigPassord", salt, hashetPassord));
	}
}
