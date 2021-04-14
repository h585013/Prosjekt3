package no.hvl.dat109.registreringOgLogin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;

public class PassordHjelper {

	public static String genererTilfeldigSalt() {
	    SecureRandom sr;
	    byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		    sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    return DatatypeConverter.printHexBinary(salt);
	}
	
public static String hashMedSalt(String passord, String salt) { 
		
		byte[] passhash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
			md.update(saltbytes);
			passhash = md.digest(passord.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(passhash);
	}

public static boolean validerMedSalt(String passord, String salt, String passordhash) {
	String hashy = hashMedSalt(passord, salt);
	return	passordhash.equals(hashy);
			
}
	
}
