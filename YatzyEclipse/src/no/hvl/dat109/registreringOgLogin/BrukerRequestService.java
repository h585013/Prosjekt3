package no.hvl.dat109.registreringOgLogin;

import javax.ejb.EJB;

import no.hvl.dat109.dao.BrukerDAO;

public class BrukerRequestService {
	
	@EJB
	private static BrukerDAO dao ;
	
	static boolean matcherPassord(String passord, String passordRepeat) {
		return passord.equals(passordRepeat);
	}

	static boolean BrukernavnLedig(String brukernavn) {
		return dao.brukernavnLedig(brukernavn);
	}
	
}
