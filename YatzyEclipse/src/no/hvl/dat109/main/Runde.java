package no.hvl.dat109.main;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import no.hvl.dat109.spiller.Spiller;
import no.hvl.dat109.terningkast.Kopp;
import no.hvl.dat109.terningkast.Terning;

/**
 * Objekt som representerer en runde i yatzy spillet. Lagrer nyttig informasjon
 * og utfører endringer for hver runde og spiller
 * 
 * @author Anne
 *
 */
public class Runde {
	// Objektvariabler
	private ArrayList<Spiller> spillere;
	private int currPlayer;
	private ArrayList<Integer> trillCount = new ArrayList<Integer>();
	private int rundenr;
	private Kopp kopp = new Kopp();
	private List<Terning> terninger;
	private Yatzy yatzy = new Yatzy();

	/**
	 * Konstruktør som starter første runden
	 * 
	 * @param spillere, spillerne som skal være med i hele spillet
	 */
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
	
	
	/**
	 * Logikk for en runde 
	 * 
	 * @param scoreHittil, poengene currPlayer har fått hittil
	 * @param indekser, indeks på hvilke terninger i array som skal beholdes
	 * @return poeng for runden hvis spilleren har trilt tre ganger, 0 ellers
	 */
	public int spillRunde(ArrayList<Integer> scoreHittil, Enumeration<String> indekser) {
		boolean ferdig = this.trillCount.stream().mapToInt(t -> t).allMatch(t -> t == 3);
		if (ferdig) { // Alle spillerne har trilt sine 3 ganger
			// Skal da gå videre til neste runde
			rundenr++;
			nesteSpiller();
			for (int i = 0; i < this.trillCount.size(); i++) {
				this.trillCount.set(i, 0);
			}
			trillAlleTerningerIgjen();
		} else {
			if (this.trillCount.get(currPlayer) == 3) { // currPlayer har trilt sine tre ganger
				// Beregn poeng for currPlayer
				int poeng = yatzy.runde(this.rundenr, this.terninger, scoreHittil);
				nesteSpiller();
				trillAlleTerningerIgjen();
				return poeng;
			} else {
				// CurrPlayer får trille igjen:
				spillerTur(indekser);

			}
		}
		return 0;
	}
	
	/**
	 * Metode som utfører runden til en spiller, altså et trill
	 * @param indekser, indeks for terninger som ble valgt av spiller for å beholde de
	 */
	private void spillerTur(Enumeration<String> indekser) {
		// Sjekker om det er første trill for spilleren 
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
	}
	
	/**
	 * Metode som triller noen terninger på nytt
	 * @param indekser, indekser for terningene som ikke skal trilles igjen
	 */
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
	
	/**
	 * Metode som triller alle terningene på nytt
	 */
	private void trillAlleTerningerIgjen() {
		for (int i = 0; i < this.terninger.size(); i++) {
			Terning t = this.terninger.get(i);
			t.setTall(t.trill());
			this.terninger.set(i, t);
		}
	}
	
	/**
	 * Metode som bestemmer hvem som er neste spiller
	 */
	private void nesteSpiller() {
		if (this.currPlayer == this.spillere.size() - 1)
			currPlayer = 0;
		else
			currPlayer++;
	}

	/**
	 * Hent ut spillerne
	 * @return arraylist av spillerne
	 */
	public ArrayList<Spiller> getSpillere() {
		return spillere;
	}

	/**
	 * Hent ut nåværende spiller
	 * @return Spiller objektet
	 */
	public Spiller getCurrPlayer() {
		return this.spillere.get(currPlayer);
	}

	/**
	 * Hent ut trillCount til nåværende spiller
	 * @return trillCount til nåværende spiller
	 */
	public int getTc() {
		return this.trillCount.get(currPlayer);
	}

	/**
	 * Henter alle trillcountene
	 * @return alle spillerne sin trillCount
	 */
	public ArrayList<Integer> getTrillCount() {
		return trillCount;
	}

	/**
	 * Finner rundenummeret
	 * @return rundenummeret
	 */
	public int getRundenr() {
		return rundenr;
	}

	/**
	 * Henter ut nåværende terninger
	 * @return liste over terningene
	 */
	public List<Terning> getTerninger() {
		return terninger;
	}

}
