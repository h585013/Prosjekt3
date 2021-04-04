package no.hvl.dat109.regler;

import java.util.ArrayList;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */
public class RundeEnTilSeks implements IRegel {

	private String navn;
	private int rundenr;

	/**
	 * Konstruktør, ansvarlig for å sette riktig navn på runden.
	 * 
	 * @param rundenr
	 */
	public RundeEnTilSeks(int rundenr) {
		this.rundenr = rundenr;
		
		switch (rundenr) {

		case 1:
			navn = "enere";
			break;
		case 2:
			navn = "toere";
			break;
		case 3:
			navn = "treere";
			break;
		case 4:
			navn = "firere";
			break;
		case 5:
			navn = "femmere";
			break;
		case 6:
			navn = "seksere";
			break;

		}
	}

	/**
	 * 
	 * Metoden er ansvarlig for å regne ut poengsum for de første 6 rundene, hvor
	 * man skal regne ut summen av terningkast med en spesifikk terningsverdi.
	 * 
	 * @param terningkast: ArrayList<Integer> over terningkast
	 * @param rundenr.     Er det samme som terningsverdien vi vil ha.
	 * 
	 * @return sum av terningkastene som matcher rundenr.
	 * 
	 *         Metoden finner alle terninger som matcher rundenr (og den
	 *         terningverdien vi vil ha), og summerer alle disse og returnerer de
	 *         til Yatzy-klassen.
	 */

	@Override
	public int resolve(ArrayList<Integer> terningkast) {

		return terningkast.stream().filter(x -> x == rundenr).mapToInt(Integer::valueOf).sum();

	}

	public String getNavn() {
		return navn;
	}

}