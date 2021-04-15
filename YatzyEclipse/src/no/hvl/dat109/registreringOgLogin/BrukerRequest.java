package no.hvl.dat109.registreringOgLogin;

public class BrukerRequest {

	private String brukernavn;
	private String passord;
	private String passordRepeat;
	private String email;

	public BrukerRequest(String brukernavn, String epost, String passord, String passordRepeat) {
		this.brukernavn = brukernavn;
		this.passord = passord;
		this.passordRepeat = passordRepeat;
		this.email = epost;
	}
	
	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordRepeat() {
		return passordRepeat;
	}

	public void setPassordRepeat(String passordRepeat) {
		this.passordRepeat = passordRepeat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
