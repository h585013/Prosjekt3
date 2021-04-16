package no.hvl.dat109.registreringOgLogin;

import javax.ejb.EJB;

import no.hvl.dat109.dao.BrukerDAO;

/**
 * @author ehell
 */
public class BrukerRequestService {
	
	@EJB
	private static BrukerDAO dao ;
	
	
	/**
	 * 
	 * @param passord
	 * @param passordRepeat
	 * @return true om passord er lik passordRepeat. 
	 */
	static boolean matcherPassord(String passord, String passordRepeat) {
		return passord.equals(passordRepeat);
	}

	/**
	 * Går via databasen og sjekker om brukernavn finnes. 
	 * 
	 * @param brukernavn
	 * @return true om brukernavnet ikke er tatt. 
	 */
	static boolean BrukernavnLedig(String brukernavn) {
		return dao.brukernavnLedig(brukernavn);
	}
	
}
