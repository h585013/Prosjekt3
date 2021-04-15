package no.hvl.dat109.main;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import no.hvl.dat109.registreringOgLogin.Bruker;
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
	private List<Bruker> spillere;
	private int currPlayer;
	private ArrayList<Integer> trillCount = new ArrayList<Integer>();
	private int rundenr;
	private Kopp kopp = new Kopp();
	private List<Terning> terninger;
	private Yatzy yatzy = new Yatzy();
	private List<Resultat> resultat = new ArrayList<Resultat>();
	private Bruker vinner = null;

	/**
	 * Konstruktør som starter første runden
	 * 
	 * @param spillere, spillerne som skal være med i hele spillet
	 */
	public Runde(List<Bruker> brukere) {
		this.spillere = brukere;
		this.currPlayer = 0;
		this.rundenr = 1;

		kopp.trillerTerningene();
		this.terninger = kopp.getTerningKastArrayList();

		for (Bruker s : this.spillere) {
			// Legger til trillCount og resultat for hver spiller
			this.trillCount.add(0);
			this.resultat.add(new Resultat());
		}
	}

	/**
	 * Logikk for en runde
	 * 
	 * @param scoreHittil, poengene currPlayer har fått hittil
	 * @param indekser,    indeks på hvilke terninger i array som skal beholdes
	 * @return poeng for runden hvis spilleren har trilt tre ganger, 0 ellers
	 */
	public void spillRunde(Enumeration<String> indekser) {
		
		if (this.rundenr <= 18) {
			boolean ferdig = this.trillCount.stream().mapToInt(t -> t).allMatch(t -> t == 3);
			if (ferdig) { // Alle spillerne har trilt sine 3 ganger
				//Lagrer siste spiller sine poeng:
				int poeng = yatzy.runde(this.rundenr, this.terninger, spillerScoreHittil());
				lagrePoeng(poeng);
				
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
					int poeng = yatzy.runde(this.rundenr, this.terninger, spillerScoreHittil());

					// Lagre poeng i resultat:
					lagrePoeng(poeng);

					// Går videre til neste spiller
					nesteSpiller();
					trillAlleTerningerIgjen();

				} else {
					// CurrPlayer får trille igjen:
					spillerTur(indekser);
				}
			}
		} else {
			// Spillet er over og vi kårer en vinner
			int indeksVinner = 0;
			int storsteSum = 0;
			for (int i = 0; i < this.spillere.size(); i++) {
				if (this.resultat.get(i).getTotalSum() > storsteSum) {
					indeksVinner = i;
				}
			}
			vinner = this.spillere.get(indeksVinner);
		}
	}

	/**
	 * Metode som returnerer en liste over det nåværende spiller har trilt i de
	 * tidligere rundene
	 * 
	 * @return listen
	 */
	private ArrayList<Integer> spillerScoreHittil() {
		System.out.println("I spillerScoreHittil(), runde: " + this.rundenr);
		ArrayList<Integer> score = new ArrayList<Integer>();
		for (int i = 1; i <= this.rundenr; i++) {
			switch (i) {
			case 1:
				score.add(this.resultat.get(this.currPlayer).getEnere());
				break;
			case 2:
				score.add(this.resultat.get(this.currPlayer).getToere());
				break;
			case 3:
				score.add(this.resultat.get(this.currPlayer).getTreere());
				break;
			case 4:
				score.add(this.resultat.get(this.currPlayer).getFirere());
				break;
			case 5:
				score.add(this.resultat.get(this.currPlayer).getFemere());
				break;
			case 6:
				score.add(this.resultat.get(this.currPlayer).getSeksere());
				break;
			case 7:
				score.add(this.resultat.get(this.currPlayer).getSum1());
				break;
			case 8:
				score.add(this.resultat.get(this.currPlayer).getBonus());
				break;
			case 9:
				score.add(this.resultat.get(this.currPlayer).getEtPar());
				break;
			case 10:
				score.add(this.resultat.get(this.currPlayer).getToPar());
				break;
			case 11:
				score.add(this.resultat.get(this.currPlayer).getTreLike());
				break;
			case 12:
				score.add(this.resultat.get(this.currPlayer).getFireLike());
				break;
			case 13:
				score.add(this.resultat.get(this.currPlayer).getLitenStraight());
				break;
			case 14:
				score.add(this.resultat.get(this.currPlayer).getStorStraight());
				break;
			case 15:
				score.add(this.resultat.get(this.currPlayer).getHus());
				break;
			case 16:
				score.add(this.resultat.get(this.currPlayer).getSjanse());
				break;
			case 17:
				score.add(this.resultat.get(this.currPlayer).getYatzy());
				break;
			case 18:
				score.add(this.resultat.get(this.currPlayer).getTotalSum());
				break;
			default:
				break;

			}
		}

		return score;

	}

	/**
	 * Metode som lagrer poengene for hver runde i Resultat objektet for hver
	 * spiller
	 * 
	 * @param poeng, poeng for en runde
	 */
	private void lagrePoeng(int poeng) {
		switch (this.rundenr) {
		case 1:
			this.resultat.get(this.currPlayer).setEnere(poeng);
			break;
		case 2:
			this.resultat.get(this.currPlayer).setToere(poeng);
			break;
		case 3:
			this.resultat.get(this.currPlayer).setTreere(poeng);
			break;
		case 4:
			this.resultat.get(this.currPlayer).setFirere(poeng);
			break;
		case 5:
			this.resultat.get(this.currPlayer).setFemere(poeng);
			break;
		case 6:
			this.resultat.get(this.currPlayer).setSeksere(poeng);
			break;
		case 7:
			this.resultat.get(this.currPlayer).setSum1(poeng);
			break;
		case 8:
			this.resultat.get(this.currPlayer).setBonus(poeng);
			break;
		case 9:
			this.resultat.get(this.currPlayer).setEtPar(poeng);
			break;
		case 10:
			this.resultat.get(this.currPlayer).setToPar(poeng);
			break;
		case 11:
			this.resultat.get(this.currPlayer).setTreLike(poeng);
			break;
		case 12:
			this.resultat.get(this.currPlayer).setFireLike(poeng);
			break;
		case 13:
			this.resultat.get(this.currPlayer).setLitenStraight(poeng);
			break;
		case 14:
			this.resultat.get(this.currPlayer).setStorStraight(poeng);
			break;
		case 15:
			this.resultat.get(this.currPlayer).setHus(poeng);
			break;
		case 16:
			this.resultat.get(this.currPlayer).setSjanse(poeng);
			break;
		case 17:
			this.resultat.get(this.currPlayer).setYatzy(poeng);
			break;
		case 18:
			this.resultat.get(this.currPlayer).setTotalSum(poeng);
			break;
		default:
			break;

		}
	}

	/**
	 * Metode som utfører runden til en spiller, altså et trill
	 * 
	 * @param indekser, indeks for terninger som ble valgt av spiller for å beholde
	 *                  de
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
	 * 
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
	 * 
	 * @return arraylist av spillerne
	 */
	public List<Bruker> getSpillere() {
		return spillere;
	}

	/**
	 * Hent ut nåværende spiller
	 * 
	 * @return Spiller objektet
	 */
	public Bruker getCurrPlayer() {
		return this.spillere.get(currPlayer);
	}

	/**
	 * Hent ut trillCount til nåværende spiller
	 * 
	 * @return trillCount til nåværende spiller
	 */
	public int getTc() {
		return this.trillCount.get(currPlayer);
	}

	/**
	 * Henter alle trillcountene
	 * 
	 * @return alle spillerne sin trillCount
	 */
	public ArrayList<Integer> getTrillCount() {
		return trillCount;
	}

	/**
	 * Finner rundenummeret
	 * 
	 * @return rundenummeret
	 */
	public int getRundenr() {
		return rundenr;
	}

	/**
	 * Henter ut nåværende terninger
	 * 
	 * @return liste over terningene
	 */
	public List<Terning> getTerninger() {
		return terninger;
	}

	public List<Resultat> getResultat() {
		return resultat;
	}

	public Bruker getVinner() {
		return vinner;
	}

	
}
