package no.hvl.dat109.regler;

import java.util.ArrayList;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */
public class Yatzy implements IRegel {

	/**
	 * Sjekker at alle 5 terningene har samme verdi. Gir poeng om alle er like, og
	 * ingen poeng om de ikke er det.
	 * 
	 * @param terningkast : ArrayList<Integer> - listen vi skal sjekke om har yatzy.
	 * 
	 * @return int sum: 50 poeng om brukeren har yatzy, 0 poeng om ikke.
	 * 
	 */

	@Override
	public int resolve(ArrayList<Integer> terningkast) {

		for (int i = 1; i < 7; i++) {
			int j = i;

			if (terningkast.stream().allMatch(x -> x == j)) {
				return 50;
			}

		}

		return 0;
	}

}
