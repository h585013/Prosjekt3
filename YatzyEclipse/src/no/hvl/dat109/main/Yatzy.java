package no.hvl.dat109.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import no.hvl.dat109.regler.Bonuspoeng;
import no.hvl.dat109.regler.IRegel;
import no.hvl.dat109.regler.Regler;
import no.hvl.dat109.terningkast.Terning;

/**
 * 
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
	
	public int runde(int rundenr, List<Terning> terningkast, ArrayList<Integer> scoreHittil) {
		ArrayList<Integer> terningverdier = new ArrayList<Integer>();
		for (Terning t : terningkast) {
			terningverdier.add(t.getTall());
		}
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
			poeng = regel.resolve(terningverdier);
			break;
		case 7:
			poeng = scoreHittil.stream().mapToInt(s -> s).sum();
			break;
		case 8:
			Bonuspoeng bp = new Bonuspoeng();
			ArrayList<Integer> ts = new ArrayList<Integer>(scoreHittil.subList(0, 7));
			poeng = bp.resolve(ts);
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
			poeng = regel.resolve(terningverdier);
			break;
		case 18:
			List<Integer> scoreSomTeller = scoreHittil.subList(7, scoreHittil.size());
			poeng = scoreSomTeller.stream().mapToInt(s -> s).sum();
			break;
		default:
			break;
		}
		return poeng;
	}
}
