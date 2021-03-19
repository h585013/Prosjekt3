package no.hvl.dat109.spiller;
/**
 * 
 * @author Lotte
 *
 */
public class Spiller {

	private String navn;
	 private int score;
	 private String passord;
	 private String email;
	 private String brukernavn;
	 private int spillerId;
/**
 * Konstruktør
 * @param navn
 * @param score
 * @param passord
 * @param email
 * @param brukernavn
 * @param spillerId
 */
	 public Spiller(String navn, int score, String passord, String email, String brukernavn, int spillerId) {
		this.navn = navn;
		this.score = score;
		this.passord = passord;
		this.email = email;
		this.brukernavn = brukernavn;
		this.spillerId = spillerId;
	}

/**
 * Metode for å sette score til spiller
 * @param spiller
 */
	public void spillerScore(Spiller spiller) {
		 
		 spiller.getScore();
	 }
	 
	 
/**
 * Getter og setter for medlemsvariabler  
 * 
 */
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}



	public String getPassord() {
		return passord;
	}



	public void setPassord(String passord) {
		this.passord = passord;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getBrukernavn() {
		return brukernavn;
	}



	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}



	public int getSpillerId() {
		return spillerId;
	}



	public void setSpillerId(int spillerId) {
		this.spillerId = spillerId;
	}
	 
	 


	}
