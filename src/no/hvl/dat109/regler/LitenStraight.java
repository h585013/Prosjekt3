package no.hvl.dat109.regler;

import java.util.ArrayList;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */
public class LitenStraight implements IRegel{

	
	/**
	 * Sjekker om terningkastet har alle verdiene som trengs for liten straight (1-5). 
	 * @param terningkast: ArrayList<Integer> - liste over de 5 terningkastene som brukes til å beregne score.
	 * 
	 * @return int poengsum. 15 poeng om man har 1-5, ellers 0.
	 */
	@Override
	public int resolve(ArrayList<Integer> terningkast) {
		for(int i = 1; i < 6; i++) {
			if(!terningkast.contains(i)) {
				return 0;
			}
		}
		
		return 15;
	}

}
