package no.hvl.dat109.terningkast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vilde
 *
 */
public class Kopp {
	
	private List<Terning> terninger = new  ArrayList<Terning>();

	/**
	 * Triller terningene (5stk)
	 */
	public void trillerTerningene() {
		int i = 0;
		while (i<5) {
			Terning terningKast = new Terning(Terning.trill()); 
			terninger.add(terningKast);
			i++;
		}
	}
	
	/**
	 * Henter terningskastene i form av String
	 * Brukes for mottakeren hei
	 * @return
	 */
	public String getTerningKastString() {
		String terningkast  = "";
		int i = 0;
		while (i < 5) {
			terningkast += "Terning " + (i+1) +  ": " + terninger.get(i) + "\n";
			i++;
		}
		return terningkast;
	}


	/**
	 * Henter terningkastene i form av Array
	 * Brukes for eventuelle metoder
	 * @return
	 */
	public List<Terning> getTerningKastArrayList() {
		return terninger;
	}
	
}
