package no.hvl.dat109.regler;

import java.util.ArrayList;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */
public class TreLike implements IRegel {

	/**
	 * 
	 * Sjekker om terningene har tre like, og returnerer poengscoren fra dette.
	 * 
	 * @param terningkast: ArrayList<Integer> over terningkastene i runden
	 * 
	 * @return sum av tre like om finnes. Tar høyest-verdi først. Returnerer 0 om
	 *         det ikke finnes 3 av noe siffer.
	 */
	@Override
	public int resolve(ArrayList<Integer> terningkast) {
		for (int i = 6; i > 0; i--) {

			// Får ikke lov til å bruke i-variabel i filter, så lager en midlertidig j.
			int j = i;

			int antall = (int) terningkast.stream().filter(x -> x == j).count();

			if (antall >= 3) {
				return 3 * j;
			}
		}

		return 0;
	}

}
