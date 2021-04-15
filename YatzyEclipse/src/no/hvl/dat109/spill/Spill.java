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

import no.hvl.dat109.registreringOgLogin.Bruker;

/**
 * Spill entiteten innholder en unik id,et spillnavn valgt av spiller n�r
 * spillet opprettes. En string med brukernavn til den som opprettet Spillet, og
 * en liste av deltagere.
 * 
 * @author vilde
 */

@Entity
@Table(schema = "yatzy", name = "spill")
public class Spill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spillID;

	private String spillNavn;

	@OneToMany(mappedBy = "spillID")
	private List<Bruker> brukere;

	public Spill(String spillNavn) {
		this.spillNavn = spillNavn;
	}

	public Spill() {

	}

	public int getSpillID() {
		return spillID;
	}

	public void setBrukere(List<Bruker> brukere) {
		this.brukere = brukere;
	}

	public String getSpillNavn() {
		return spillNavn;
	}

	public void setSpillNavn(String spillNavn) {
		this.spillNavn = spillNavn;
	}

	public List<Bruker> getBrukere() {
		return brukere;
	}

	public boolean leggTilBruker(Bruker bruker) {
		return this.brukere.add(bruker);
	}

}
