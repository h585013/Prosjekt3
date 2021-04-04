package no.hvl.dat109.regler;

import java.util.ArrayList;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */
public class StorStraight implements IRegel {

	/**
	 * Sjekker om terningkastet har alle verdiene som trengs for stor straight (2-6). 
	 * @param terningkast: ArrayList<Integer> - liste over de 5 terningkastene som brukes til å beregne score
	 * 
	 * @return int poengsum. 20 poeng om man har 2-6, ellers 0.
	 */
	@Override
	public int resolve(ArrayList<Integer> terningkast) {
		for(int i = 2; i < 7; i++) {
			if(!terningkast.contains(i)) {
				return 0;
			}
		}
		
		return 20;
	}

}
