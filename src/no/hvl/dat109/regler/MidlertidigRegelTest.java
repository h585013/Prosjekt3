package no.hvl.dat109.regler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MidlertidigRegelTest {

	ArrayList<Integer> terningsTrill;
	ArrayList<Integer> tidligereResultater;
	HashMap<Integer, IRegel> regler;

	IRegel regel;

	private int e0;
	private int e1;
	private int e2;
	private int e3;
	private int e4;
	
	@BeforeAll
	void start() {
		
		Regler r = new Regler();
		regler = r.getRegler();
		
	}

	@BeforeEach
	void setup() {

		terningsTrill = new ArrayList<Integer>();
		tidligereResultater = new ArrayList<Integer>();

	}

	// Tester for runde 1-6 (trille terninger for en gitt verdi) 
	
	@Test
	void riktigSum1ere() {

		// Legger til to enere, og sjekker at den returnerer 2 som sum.

		terningsTrill.add(1);
		terningsTrill.add(4);
		terningsTrill.add(3);
		terningsTrill.add(1);
		terningsTrill.add(5);

		assertEquals(2, regler.get(1).resolve(terningsTrill));

	}

	@Test
	void riktigSum6ere() {

		// Legger til 0 6ere og sjekker at den returnerer 0 som sum.

		terningsTrill.add(1);
		terningsTrill.add(4);
		terningsTrill.add(3);
		terningsTrill.add(1);
		terningsTrill.add(5);

		assertEquals(0, regler.get(6).resolve(terningsTrill));
	}

	//Tester for å sjekke om man får bonuspoeng eller ei
	
	@Test
	void ingenBonusPoeng() {

		// Legger til tidligere poengsummer som tilsammen blir mindre enn 41.

		regel = new Bonuspoeng();

		tidligereResultater.add(3);
		tidligereResultater.add(0);
		tidligereResultater.add(9);
		tidligereResultater.add(20);
		tidligereResultater.add(5);
		tidligereResultater.add(0);
		
		assertEquals(0, regel.resolve(tidligereResultater));
	}

	@Test
	void fårBonusPoeng() {

		// Legger til tidligere poengsum som tilsammen blir 41 eller mer.

		tidligereResultater.add(3);
		tidligereResultater.add(0);
		tidligereResultater.add(9);
		tidligereResultater.add(20);
		tidligereResultater.add(5);
		tidligereResultater.add(6);

		regel = new Bonuspoeng();

		assertEquals(50, regel.resolve(tidligereResultater));
	}
	
	// Tester for ett par

	@Test
	void harEttPar() {

		// Legger til terningkast som har to 3 ere og sjekker at summen blir 6.

		terningsTrill.add(3);
		terningsTrill.add(2);
		terningsTrill.add(5);
		terningsTrill.add(1);
		terningsTrill.add(3);

		regel = new EttPar();
		assertEquals(6, regel.resolve(terningsTrill));
	}

	@Test
	void harIkkeEttPar() {

		// Legger til bare forskjellige tall og sjekker at man får 0 poeng.

		terningsTrill.add(3);
		terningsTrill.add(2);
		terningsTrill.add(5);
		terningsTrill.add(1);
		terningsTrill.add(4);

		regel = new EttPar();
		assertEquals(0, regel.resolve(terningsTrill));
	}
	
	@Test
	void EttPar6ParIkke4Par() {
		// Legger til par i både 6 og 4, og sjekker at summen blir 6*2 = 12.
		// Høyere poengsum skal velges over lavere poengsum.

		terningsTrill.add(4);
		terningsTrill.add(6);
		terningsTrill.add(6);
		terningsTrill.add(1);
		terningsTrill.add(4);

		regel = new EttPar();
		assertEquals(12, regel.resolve(terningsTrill));
	}

	// Tester for to par
	
	@Test
	void harToPar() {

		// Legger til to par (4, 5) og sjekker at man får 18 poeng.
		terningsTrill.add(4);
		terningsTrill.add(2);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(4);

		regel = new ToPar();
		assertEquals(18, regel.resolve(terningsTrill));

	}
	
	@Test
	void harIkkeToParMenHarEtt() {

		// Legger til bare ett par (5) og sjekker at man får 0 poeng.
		terningsTrill.add(1);
		terningsTrill.add(2);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(4);

		regel = new ToPar();
		assertEquals(0, regel.resolve(terningsTrill));

	}
	
	@Test
	void harIkkeToPar() {

		// Legger til 0 par og sjekker at man får 0poeng.
		terningsTrill.add(1);
		terningsTrill.add(2);
		terningsTrill.add(5);
		terningsTrill.add(6);
		terningsTrill.add(4);

		regel = new ToPar();
		assertEquals(0, regel.resolve(terningsTrill));

	}

	// Tester for tre like

	@Test
	void harTreLike() {

		// Legger til terningkast som har tre 2-ere og sjekker at summen blir 6.

		terningsTrill.add(3);
		terningsTrill.add(2);
		terningsTrill.add(2);
		terningsTrill.add(1);
		terningsTrill.add(2);

		regel = new TreLike();
		assertEquals(6, regel.resolve(terningsTrill));
	}

	@Test
	void harIkkeTreLike() {

		// Legger til bare forskjellige tall og sjekker at man får 0 poeng.

		terningsTrill.add(3);
		terningsTrill.add(2);
		terningsTrill.add(5);
		terningsTrill.add(1);
		terningsTrill.add(4);

		regel = new TreLike();
		assertEquals(0, regel.resolve(terningsTrill));
	}

	// Tester for fire like
	
	@Test
	void harFireLike() {

		// Legger til terningkast som har tre 4-ere og sjekker at summen blir 16.

		terningsTrill.add(4);
		terningsTrill.add(4);
		terningsTrill.add(2);
		terningsTrill.add(4);
		terningsTrill.add(4);

		regel = new FireLike();
		assertEquals(16, regel.resolve(terningsTrill));
	}

	@Test
	void harIkkeFireLike() {

		// Legger til bare forskjellige tall og sjekker at man får 0 poeng.

		terningsTrill.add(3);
		terningsTrill.add(2);
		terningsTrill.add(5);
		terningsTrill.add(1);
		terningsTrill.add(4);

		regel = new FireLike();
		assertEquals(0, regel.resolve(terningsTrill));
	}

	// Tester for liten straight
	
	@Test
	void harLitenStraight() {

		// Legger til terningsverdier 1-5 (liten straight) og sjekker at man får 15
		// poeng.
		terningsTrill.add(1);
		terningsTrill.add(2);
		terningsTrill.add(3);
		terningsTrill.add(4);
		terningsTrill.add(5);

		regel = new LitenStraight();
		assertEquals(15, regel.resolve(terningsTrill));
	}

	@Test
	void harIkkeLitenStraight() {

		// Legger til terningsverdier som ikke gir liten straight, og sjekker at man får
		// 0 poeng.
		terningsTrill.add(1);
		terningsTrill.add(1);
		terningsTrill.add(1);
		terningsTrill.add(1);
		terningsTrill.add(4);

		regel = new LitenStraight();
		assertEquals(0, regel.resolve(terningsTrill));
	}

	// Tester for stor straight
	
	@Test
	void harStorStraight() {

		// Legger til terningsverdier 1-5 (liten straight) og sjekker at man får 15
		// poeng.
		terningsTrill.add(2);
		terningsTrill.add(3);
		terningsTrill.add(4);
		terningsTrill.add(5);
		terningsTrill.add(6);

		regel = new StorStraight();
		assertEquals(20, regel.resolve(terningsTrill));
	}

	@Test
	void harIkkeStorStraight() {

		// Legger til terningsverdier som ikke gir liten straight, og sjekker at man får
		// 0 poeng.
		terningsTrill.add(1);
		terningsTrill.add(1);
		terningsTrill.add(1);
		terningsTrill.add(1);
		terningsTrill.add(4);

		regel = new StorStraight();
		assertEquals(0, regel.resolve(terningsTrill));
	}
	
	// Tester for hus
	
	@Test
	void harHus() {
		// Legger til to 3-ere og tre 4-ere og sjekker at summen er 18.
		terningsTrill.add(3);
		terningsTrill.add(3);
		terningsTrill.add(4);
		terningsTrill.add(4);
		terningsTrill.add(4);
		regel = new Hus();
		assertEquals(18, regel.resolve(terningsTrill));
		
	}
	
	void harIkkeHusMenToPar() {
		// Legger til to 3-ere og to 4-ere og sjekker at man får 0 poeng.
		terningsTrill.add(3);
		terningsTrill.add(3);
		terningsTrill.add(4);
		terningsTrill.add(4);
		terningsTrill.add(1);
		regel = new Hus();
		assertEquals(0, regel.resolve(terningsTrill));
		
	}

	void harIkkeHus() {
		// Legger til forskjellige verdier som ikke gir hus.
		terningsTrill.add(3);
		terningsTrill.add(2);
		terningsTrill.add(1);
		terningsTrill.add(4);
		terningsTrill.add(1);
		regel = new Hus();
		assertEquals(0, regel.resolve(terningsTrill));
		
	}
	
	// Test for sjanse
	
	@Test
	void sjanseRiktigSum() {

		// Legger til terninger med total verdi 24, sjekker at dette stemmer med
		// sjanse-metoden.

		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(4);

		regel = new Sjanse();
		assertEquals(24, regel.resolve(terningsTrill));

	}
	
	// Tester for yatzy

	@Test
	void harYatzy() {

		// Legger til bare 5-ere og sjekker at metoden returnerer 50 poeng.
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);

		regel = new Yatzy();
		assertEquals(50, regel.resolve(terningsTrill));
	}

	@Test
	void harIkkeYatzy() {

		// Legger til 4 5-ere og 1 3-er (ikke yatzy!) og sjekker at metoden returnerer 0
		// poeng.
		terningsTrill.add(3);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);

		regel = new Yatzy();
		assertEquals(0, regel.resolve(terningsTrill));
	}
	
	
	// Trenger ikke lenger, ville sjekke at jeg kunne hente metoder fra hashmappen og at det funket.
	
	@Test
	void testRegelKlassen() {
		Regler reglerKlasse = new Regler();
		HashMap<Integer, IRegel> regler = reglerKlasse.getRegler();
		
		terningsTrill.add(3);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);
		terningsTrill.add(5);
		
		assertEquals(20, regler.get(10).resolve(terningsTrill));
		
		
	}

}
