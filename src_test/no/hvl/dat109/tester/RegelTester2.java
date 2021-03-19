package no.hvl.dat109.tester;

import static org.junit.Assert.assertEquals;
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
	IRegel litenStraight = new LitenStraight();
	IRegel sjanse = new Sjanse();
	IRegel toPar = new ToPar();

	ArrayList<Integer> ErHus = new ArrayList<Integer>();
	ArrayList<Integer> ErIkkeHus = new ArrayList<Integer>();
	ArrayList<Integer> ErLitenStraight = new ArrayList<Integer>();
	ArrayList<Integer> ErIkkeLitenStraight = new ArrayList<Integer>();
	ArrayList<Integer> Sjanse = new ArrayList<Integer>();
	ArrayList<Integer> ErToPar = new ArrayList<Integer>();
	ArrayList<Integer> ErIkkeToPar = new ArrayList<Integer>();

	
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
		assertEquals(16, testErHus);
		
		//Tester at det ikke er et hus
		int testErIkkeHus = hus.resolve( ErIkkeHus);
		assertEquals(0, testErIkkeHus);

	}

	@Test
	void testLitenStraigth() {
		ErLitenStraight.add(1);
		ErLitenStraight.add(2);
		ErLitenStraight.add(3);
		ErLitenStraight.add(4);
		ErLitenStraight.add(5);
		
		int TestErLitenStraight = litenStraight.resolve(ErLitenStraight);
		assertEquals(15, TestErLitenStraight);
		
		ErIkkeLitenStraight.add(1);
		ErIkkeLitenStraight.add(2);
		ErIkkeLitenStraight.add(3);
		ErIkkeLitenStraight.add(4);
		ErIkkeLitenStraight.add(4);
		
		int TestErIkkeLitenStraight = litenStraight.resolve(ErIkkeLitenStraight);
		assertEquals(0, TestErIkkeLitenStraight);		
		
	}

	@Test
	void testSjanse() {
		Sjanse.add(2);
		Sjanse.add(3);
		Sjanse.add(4);
		Sjanse.add(3);
		Sjanse.add(1);
		
		int TestSjanse = sjanse.resolve(Sjanse);
		assertEquals(13, TestSjanse);
		
	}

	/**
	 * Tester at det er to par, samt at det høyeste paret blir valgt
	 */
	@Test
	void testToPar() {
		ErToPar.add(4);
		ErToPar.add(4);
		ErToPar.add(6);
		ErToPar.add(6);
		ErToPar.add(5);
		
		int TestErToPar = toPar.resolve(ErToPar);
		assertEquals(12, TestErToPar);
		
		ErIkkeToPar.add(1);
		ErIkkeToPar.add(4);
		ErIkkeToPar.add(3);
		ErIkkeToPar.add(6);
		ErIkkeToPar.add(5);
		
		int TestErIkkeToPar = toPar.resolve(ErIkkeToPar);
		assertEquals(0, TestErIkkeToPar);
		
	}

}
