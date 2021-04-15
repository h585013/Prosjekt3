package no.hvl.dat109.registreringOgLogin;

import javax.persistence.Embedded;
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

	private String hashetPassord;
	
	private String salt;
	
	@ManyToOne
	@JoinColumn(name = "spillID", referencedColumnName = "spillID")
	private Spill spill;
	
	int score;
	
	public Bruker(String brukernavn, String email, String passord, String salt, Spill spill, int score) {
		
		this.brukernavn = brukernavn;
		this.email = email;
		this.hashetPassord = passord;
		this.spill = spill;
		this.score = score;
		this.salt = salt;
	}


	public Spill getSpill() {
		return spill;
	}

	public void setSpill(Spill spill) {
		this.spill = spill;
	}

	public Bruker() {

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
		return hashetPassord;
	}
	
	public void setPassord(String pass) {
		hashetPassord = pass;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	

}
