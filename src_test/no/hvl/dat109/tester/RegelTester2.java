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
import no.hvl.dat109.terningkast.Terning;

class RegelTester2 {

	
	//Tester hus

	IRegel hus = new Hus();
	IRegel litenStraigth = new LitenStraight();	
	IRegel sjanse = new Sjanse();
	IRegel toPar = new ToPar();
	
	List<Integer> terningKast = new ArrayList<Integer>();
	
	
	@Test
	void testHus() {
		terningKast.add(2);
		terningKast.add(2);
		terningKast.add(5);
		terningKast.add(5);
		terningKast.add(5);

		hus.resolve(terningKast);
		
		
		
		
	}
	
	@Test
	void testLitenStraigth() {
		
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
