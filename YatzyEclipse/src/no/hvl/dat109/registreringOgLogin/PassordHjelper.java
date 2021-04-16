package no.hvl.dat109.registreringOgLogin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;
/**
 * 
 * @author ehell
 *
 */
public class PassordHjelper {

	/**
	 * Generere tilfeldig salt som kan brukes til hashing av passord.
	 * @return salt-String
	 */
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
	
	/**
	 * Tar inn passord og salt og hasher passordet.
	 * @param passord
	 * @param salt
	 * @return hashet passord.
	 */
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

/**
 * 
 * @param passord
 * @param salt
 * @param passordhash
 * @return true om passord hashet med salt, er lik passordhash. 
 */
public static boolean validerMedSalt(String passord, String salt, String passordhash) {
	String hashy = hashMedSalt(passord, salt);
	return	passordhash.equals(hashy);
			
}
	
}
