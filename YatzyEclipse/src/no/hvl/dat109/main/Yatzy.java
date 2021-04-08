package no.hvl.dat109.main;

import java.util.ArrayList;
import java.util.HashMap;

import no.hvl.dat109.regler.Bonuspoeng;
import no.hvl.dat109.regler.IRegel;
import no.hvl.dat109.regler.Regler;

/**
 * Hovedklasse som starter spillet
 *
 * Antar at spillet er tvunget yatzy i første omgang hvertfall
 *
 * @author Anne og Thea og Magnus :)
 *
 */
public class Yatzy {
	/**
	 * Objektvariabler
	 */
	private static Regler reg = new Regler();
	private static HashMap<Integer, IRegel> regler = reg.getRegler();

	public Yatzy() {
		
	}
	
	public int runde(int rundenr, ArrayList<Integer> terningkast) {
		int poeng = 0;
		IRegel regel;
		switch (rundenr) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			regel = regler.get(rundenr);
			poeng = regel.resolve(terningkast);
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
			regel = regler.get(rundenr-2);
			poeng = regel.resolve(terningkast);
			break;
		case 18:
			break;
		default:
			break;
		}
		return poeng;
	}
}
