package no.hvl.dat109.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.regler.IRegel;
import no.hvl.dat109.regler.Regler;
import no.hvl.dat109.spiller.Spiller;

/**
 * Hovedklasse som starter spillet
 *
 * Antar at spillet er tvunget yatzy i første omgang hvertfall
 *
 * @author Anne og Thea
 *
 */
public class Yatzy {
	/**
	 * Objektvariabler
	 */
	private static final int MAKS_ANTALL_RUNDER = 15; // Ut fra et vanlig yatzy brett
	private static int rundenr = 1;
	private static int antallSpillere;
	private static Regler reg = new Regler();
	private static HashMap<Integer, IRegel> regler = reg.getRegler();
	private static List<Spiller> spillere = new ArrayList<Spiller>();


	public static void main(String[] args) {
		startSpill();
		System.out.println("SPILLET ER SLUTT");

	}

	private static void startSpill() {
		Scanner sc = new Scanner(System.in);

		// Be om antall spillere:
		System.out.println("Hvor mange skal spille? (Fra 1 til 6 personer)");
		antallSpillere = sc.nextInt();
		while (antallSpillere < 1 || antallSpillere > 6) {
			System.out.println("Ugyldig antall spillere! Må være fra 1 til 6");
			antallSpillere = sc.nextInt();
		}

		// Få informasjon om alle spillerene
		for (int i = 0; i < antallSpillere; i++) {
			System.out.println("Spiller navn: ");
			String navn = sc.next();
			//spillere.add(new Spiller());//sc.next())); // Antar at dette er en konstruktør
			// Spør om eventuelt mer informasjon som er nødvendig for å opprette spiller objekt
		}

		sc.close();

		// Starter rundene
		while (rundenr <= MAKS_ANTALL_RUNDER) {
			System.out.println("RUNDE NUMMER: " + rundenr);
			for (Spiller s : spillere) {
				// Triller:
				// for (int i = 0; i < 3; i++)
				// 		Kopp k = s.trill(); 	--> Regner med dette blir en metode i Spiller klassen

				// Første runde bare:
				IRegel regel = regler.get(rundenr);
				//int resultat = regel.resolve(terningkast, rundenr);

				// HashMap: lagre resultat i Spiller
				
				// Når trillingen og det er ferdig
				// Så må vi beregne summen og bonus
				if (rundenr == 6) {
					// beregn sum til spilleren
					// beregn bonus til spilleren
				}
				// Hei
			}
			if (rundenr == 6) {
				// skriver ut poengsummene til hver spiller
				// og om de da får bonus
				for (Spiller s : spillere) {
					//System.out.println(s.getNavn() + " sin poengsum er: " + s.getSum() + " -> Bonuspoeng: " + s.bonuspoeng());
				}
			}
			rundenr++;
		}

		// sysout: spiller + totalsum
		// sysout: hvem som vant
	}

}
