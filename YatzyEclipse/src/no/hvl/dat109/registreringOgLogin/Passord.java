package no.hvl.dat109.registreringOgLogin;

import javax.persistence.Embeddable;

@Embeddable
public class Passord {
	
	private String pwd_hash;
    private String pwd_salt;
    
	private Passord(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	public Passord() {}

	@Override
	public String toString() {
		return "Passord [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
		
	}
	
	public static Passord lagPassord(String passordKlartekst) {
		String salt = PassordHjelper.genererTilfeldigSalt();
		String hash = PassordHjelper.hashMedSalt(passordKlartekst, salt);
		return new Passord(hash, salt);
	}

	public String getPwd_salt() {
		return pwd_salt;
	}
	
	public String getPwd_hash() {
		return pwd_hash;
	}
	
	
}
