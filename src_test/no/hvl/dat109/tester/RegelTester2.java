package no.hvl.dat109.tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import no.hvl.dat109.regler.Hus;
import no.hvl.dat109.regler.IRegel;
import no.hvl.dat109.regler.LitenStraight;
import no.hvl.dat109.regler.Sjanse;
import no.hvl.dat109.regler.ToPar;

class RegelTester2 {

	// Tester hus

	IRegel hus = new Hus();
	IRegel litenStraigth = new LitenStraight();
	IRegel sjanse = new Sjanse();
	IRegel toPar = new ToPar();

	ArrayList<Integer> ErHus = new ArrayList<Integer>();
	ArrayList<Integer> ErIkkeHus = new ArrayList<Integer>();
	ArrayList<Integer> ErLitenStraight = new ArrayList<Integer>();
	ArrayList<Integer> ErIkkeLitenStraight = new ArrayList<Integer>();

	@Test
	void testHus() {
		ErHus.add(2);
		ErHus.add(2);
		ErHus.add(2);
		ErHus.add(5);
		ErHus.add(5);
		
		ErIkkeHus.add(2);
		ErIkkeHus.add(2);
		ErIkkeHus.add(4);
		ErIkkeHus.add(5);
		ErIkkeHus.add(3);
		
		//Tester at det er et hus
		int testErHus = hus.resolve(ErHus);
		assertEquals(19, ErHus);
		
		//Tester at det ikke er et hus
		int testErIkkeHus = hus.resolve( ErIkkeHus);
		assertEquals(0, ErIkkeHus);

	}

	@Test
	void testLitenStraigth() {
		
		ErLitenStraight.add(5);
		ErIkkeLitenStraight.add(5);
	}

	@Test
	void testSjanse() {
		;
	}

	@Test
	void testToPar() {
		;
	}

}
