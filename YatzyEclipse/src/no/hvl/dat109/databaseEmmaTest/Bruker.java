package no.hvl.dat109.databaseEmmaTest;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.dat109.spill.Spill;

@Entity
@Table(schema = "public", name = "bruker")
public class Bruker {

	@Id
	private String brukernavn;

	private String email;

	// TODO: er faktisk ikke hashet / saltet enda. 100% i klartekst. 
	private String passord;

//	private String salt;
	
	@ManyToOne
	@JoinColumn(name = "spillID", referencedColumnName = "spillID")
	private Spill spill;
	
	int score;


	public Spill getSpill() {
		return spill;
	}

	public void setSpill(Spill spill) {
		this.spill = spill;
	}

	public Bruker() {

	}
	

	public Bruker(String brukernavn, String epost, String passord) {
		this(brukernavn, epost, passord, 0, null);
	}
		
	public Bruker(String brukernavn, String epost, String passord, int score, Spill spill) {

		this.brukernavn = brukernavn;
		email = epost;
		this.passord = passord;
		this.score = score;
		this.spill = spill;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getEpost() {
		return email;
	}

	public void setEpost(String epost) {
		email = epost;
	}
	
	public String getPassord() {
		return passord;
	}
	
	public void setPassord(String pass) {
		passord = pass;
	}
	
	

}
