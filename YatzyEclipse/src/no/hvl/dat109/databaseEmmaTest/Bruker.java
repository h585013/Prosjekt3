package no.hvl.dat109.databaseEmmaTest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "dat109oblig3", name = "bruker")
public class Bruker {

	@Id
	private String brukernavn;

	private String epost;

	// TODO: er faktisk ikke hashet / saltet enda. 100% i klartekst. 
	private String passord;

//	private String salt;

	public Bruker() {

	}

	public Bruker(String brukernavn, String epost, String passord) {
		this.brukernavn = brukernavn;
		this.epost = epost;
		this.passord = passord;
		
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}
	
	public String getPassord() {
		return passord;
	}
	
	public void setPassord(String pass) {
		passord = pass;
	}
	
	

}
