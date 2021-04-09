package no.hvl.dat109.spill;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.dat109.spiller.Spiller;

/**
* Spill entiteten innholder en unik id,et spillnavn valgt av spiller når
* spillet opprettes. En string med brukernavn til den som opprettet Spillet, og
* en liste av deltagere.
* @author vilde
*/

@Entity
@Table(schema = "public", name = "spiller")
public class Spill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String spillNavn;
	private String admin;

	@OneToMany(mappedBy = "spiller")
	private List<Spiller> spillere;

	/**
	 * Konstruktør
	 * 
	 * @param id
	 * @param spillNavn
	 * @param admin
	 * 
	 */
	public Spill(String spillNavn, String admin) {

		
		this.spillNavn = spillNavn;
		this.admin = admin;

	}
}
