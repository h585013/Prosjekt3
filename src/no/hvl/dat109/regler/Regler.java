package no.hvl.dat109.regler;

import java.util.HashMap;

public class Regler {
	
	private HashMap<Integer, IRegel> regler;
	
	public Regler() {
	
		regler = new HashMap<Integer, IRegel>();
		
		// For-løkke for runde en til seks.
		
		for(int i = 1; i <= 6; i++) {
			regler.put(i, new RundeEnTilSeks(i));
		}
		
		regler.put(7, new EttPar());
		regler.put(8, new ToPar());
		regler.put(9, new TreLike());
		regler.put(10, new FireLike());
		regler.put(11, new LitenStraight());
		regler.put(12, new StorStraight());
		regler.put(13, new Hus());
		regler.put(14, new Sjanse());
		regler.put(15, new Yatzy());
		
	}
	
	public HashMap<Integer, IRegel> getRegler(){
		return regler;
	}

}
