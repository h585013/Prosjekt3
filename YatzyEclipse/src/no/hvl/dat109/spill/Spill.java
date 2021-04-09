package no.hvl.dat109.spill;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.dat109.databaseEmmaTest.Bruker;
import no.hvl.dat109.spiller.Spiller;

/**
 * Spill entiteten innholder en unik id,et spillnavn valgt av spiller n�r
 * spillet opprettes. En string med brukernavn til den som opprettet Spillet, og
 * en liste av deltagere.
 * 
 * @author vilde
 */

@Entity
@Table(schema = "yatzy", name = "spillPU")
public class Spill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spillID;
	public int getSpillID() {
		return spillID;
	}

	
	public void setBrukere(List<Bruker> brukere) {
		this.brukere = brukere;
	}

	private String spillNavn;
	private String admin;

	@OneToMany(mappedBy = "spill", fetch = FetchType.EAGER)
	private List<Bruker> brukere;

	/**
	 * Konstrukt�r
	 * 
	 * 
	 * @param spillNavn
	 * @param admin
	 * 
	 */
	public Spill(String spillNavn, String admin) {

		this.spillNavn = spillNavn;
		this.admin = admin;

	}

	public Spill() {

	}

	public String getSpillNavn() {
		return spillNavn;
	}
	

	public void setSpillNavn(String spillNavn) {
		this.spillNavn = spillNavn;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public List<Bruker> getBrukere() {
		return brukere;
	}

	public boolean leggTilBruker(Bruker bruker) {
		return this.brukere.add(bruker);
	}

}