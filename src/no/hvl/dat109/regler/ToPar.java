package no.hvl.dat109.regler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */

public class ToPar implements IRegel {

	/**
	 * Metoden sjekker om det finnes to par i listen over terningskast, og
	 * returnerer poengsum basert på dette.
	 * 
	 * @param terningkast: ArrayList<Integer> liste over terningkast som vi leter
	 *                     etter to par i.
	 * 
	 * @return poengsum : 0 om det ikke finnes 2 par, ellers summen av verdien til
	 *         de to parene.
	 */
	@Override
	public int resolve(ArrayList<Integer> terningkast) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Setter alle valusene til 0 først.
		for (int i = 1; i < 7; i++) {
			map.put(i, 0);
		}

		// Teller hvor mange det er av hver verdi.
		for (int i = 0; i < 5; i++) {

			int verdi = terningkast.get(i);
			map.put(verdi, map.get(verdi) + 1);

		}

		// Fjerner de som har 1 eller 0.

		for (int i = 6; i > 0; i--) {
			map.remove(i, 1);
			map.remove(i, 0);

		}
		// Sjekker om det er to elementer igjen, isåfall returnerer summen av disse. 
		if (map.size() == 2) {
			return map.keySet().stream().map(x -> x * 2).mapToInt(Integer::valueOf).sum();
		}
		
		// Ellers returnerer 0. 

		return 0;

	}

}
