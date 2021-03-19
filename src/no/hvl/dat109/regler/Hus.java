package no.hvl.dat109.regler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Emma Helland-Hansen
 *
 */
public class Hus implements IRegel {

	/**
	 * Metoden sjekker om det finnes et hus i listen over terningskast, og
	 * returnerer poengsum basert på dette. Et hus er tre like + 2 like.
	 * 
	 * @param terningkast: ArrayList<Integer> liste over terningkast som vi leter
	 *                     etter to par i.
	 * 
	 * @return poengsum : 0 om det ikke finnes hus , ellers summen av verdien til
	 *         terningene i huset.
	 */

	@Override
	public int resolve(ArrayList<Integer> terningkast) {
		
		int treLike = 0;
		int toLike = 0;
		
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
		
		//Om hashmappen ikke inneholder value 3 eller 2 så returnerer vi poengsum 0 (da vi ikke kan ha hus).
		if(! map.containsValue(3) || !map.containsValue(2)){
			return 0;
		}
		
		// Finner hvilke verdier som har tre og to, og returnerer summen av disse. 
		
		for(int i = 1; i < 7; i++) {
			if(map.get(i) == 3) {
				treLike = i;
			}
			else if(map.get(i) == 2){
				toLike = i;
			}
		}
		return treLike*3 + toLike*2;
	}

}
