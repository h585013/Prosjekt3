package no.hvl.dat109.main;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import no.hvl.dat109.spiller.Spiller;
import no.hvl.dat109.terningkast.Kopp;
import no.hvl.dat109.terningkast.Terning;

public class Runde {
	// Objektvariabler
	private ArrayList<Spiller> spillere;
	private int currPlayer;
	private ArrayList<Integer> trillCount = new ArrayList<Integer>();
	private int rundenr;
	private Kopp kopp = new Kopp();
	private List<Terning> terninger;
	private Yatzy yatzy = new Yatzy();

	public Runde(ArrayList<Spiller> spillere) {
		System.out.println("OPPRETTER RUNDEN");
		this.spillere = spillere;
		this.currPlayer = 0;
		this.rundenr = 1;
		
		kopp.trillerTerningene();
		this.terninger = kopp.getTerningKastArrayList();

		for (Spiller s : this.spillere)
			this.trillCount.add(0);
	}

	public int spillRunde(ArrayList<Integer> scoreHittil, Enumeration<String> indekser) {
		System.out.println("----------------");
		System.out.println("STARTER EN RUNDE - " + rundenr);
		boolean ferdig = this.trillCount.stream().mapToInt(t -> t).allMatch(t -> t == 3);
		if (ferdig) { // Alle spillerne har trilt sine 3 ganger
			// neste runde 
			rundenr++;
			nesteSpiller();
			for (int i = 0; i < this.trillCount.size(); i++) {
				this.trillCount.set(i, 0);
			}
			trillAlleTerningerIgjen();
			System.out.println("NESTE RUNDE! - " + rundenr);
		} else {
			if (this.trillCount.get(currPlayer) == 3) {
				System.out.println("NESTE SPILLER!");
				// Beregn poeng for currPlayer
				int poeng = yatzy.runde(this.rundenr, this.terninger, scoreHittil);
				nesteSpiller();
				trillAlleTerningerIgjen();
				return poeng;
			} else {
				System.out.println("CURR FÅR TRILLE!");
				// currPlayer får trille igjen:
				spillerTur(indekser);

			}
		}

		return 0;
	}

	private int spillerTur(Enumeration<String> indekser) {
		System.out.println("-----------");
		System.out.println("EN SPILLER SIN TUR!");
		if (this.trillCount.get(currPlayer) == 0) {
			trillAlleTerningerIgjen();
		} else {
			// Få inn hvilke som skal trilles på nytt
			trillTerningerIgjen(indekser);
		}

		// Øke trillCount med en
		int currTrillCount = this.trillCount.get(this.currPlayer);
		currTrillCount++;
		this.trillCount.set(currPlayer, currTrillCount);
		
		return 0;
	}
	
	private void trillTerningerIgjen(Enumeration<String> indekser) {
		List<Integer> behold = new ArrayList<Integer>();
		while (indekser.hasMoreElements()) {
			behold.add(Integer.parseInt(indekser.nextElement()));
		}

		// Trille de terningene på nytt
		for (int i = 0; i < this.terninger.size(); i++) {
			if (!behold.contains(i)) {
				Terning t = this.terninger.get(i);
				t.setTall(t.trill());
				this.terninger.set(i, t);
			}
		}
	}
	
	private void trillAlleTerningerIgjen() {
		for (int i = 0; i < this.terninger.size(); i++) {
			Terning t = this.terninger.get(i);
			t.setTall(t.trill());
			this.terninger.set(i, t);
		}
	}

	private void nesteSpiller() {
		if (this.currPlayer == this.spillere.size() - 1)
			currPlayer = 0;
		else
			currPlayer++;
	}

	public ArrayList<Spiller> getSpillere() {
		return spillere;
	}

	public Spiller getCurrPlayer() {
		return this.spillere.get(currPlayer);
	}

	public int getTc() {
		return this.trillCount.get(currPlayer);
	}
	

	public ArrayList<Integer> getTrillCount() {
		return trillCount;
	}

	public int getRundenr() {
		return rundenr;
	}

	public Kopp getKopp() {
		return kopp;
	}

	public List<Terning> getTerninger() {
		return terninger;
	}

	public Yatzy getYatzy() {
		return yatzy;
	}

}
