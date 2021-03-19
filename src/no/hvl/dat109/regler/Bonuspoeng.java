package no.hvl.dat109.regler;

import java.util.ArrayList;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */
public class Bonuspoeng implements IRegel {

	/**
	 * 
	 * Metoden regner ut total sum av de første 6 rundene og sjekker om det er nok til å få bonuspoeng.
	 * 
	 * @param tidligereSummer : ArrayList<Integer> - liste over summer fra tildigere runder. 
	 * 
	 * @return returnerer 0 om total sum av tidligere er mindre enn 41,  og 50 om mer eller lik 41.
	 */

	@Override
	public int resolve(ArrayList<Integer> tidligereSummer) {

		int totalSum = tidligereSummer.stream().mapToInt(Integer::valueOf).sum();

		return totalSum >= 41 ? 50 : 0;

	}

}
