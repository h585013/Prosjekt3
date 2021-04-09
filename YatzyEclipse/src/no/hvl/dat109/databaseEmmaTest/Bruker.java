package no.hvl.dat109.databaseEmmaTest;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "spiller")
public class Bruker {

	@Id
	private String brukernavn;

	private String email;

	// TODO: er faktisk ikke hashet / saltet enda. 100% i klartekst. 
	private String passord;

//	private String salt;
 @OneToMany( mappedBy= "bruker",fetch = FetchType.EAGER)
private int spillID;

	public Bruker() {

	}

	public Bruker(String brukernavn, String epost, String passord) {
		this.brukernavn = brukernavn;
		email = epost;
		this.passord = passord;
		
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
