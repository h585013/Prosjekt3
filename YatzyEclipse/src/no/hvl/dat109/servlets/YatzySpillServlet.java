package no.hvl.dat109.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.main.Yatzy;

/**
 * Implementasjon av å faktisk spille spillet
 * 
 * @author - Anne, Thea, Magnus
 */
@WebServlet("/YatzySpillServlet")
public class YatzySpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Yatzy yatzy = new Yatzy();
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hvis sesjon.getPrameter(startet) == null
    		// Henter ut spillID fra request
    		// SpillDAO for å finne spillet
    		// Hente ut alle spillerene --> liste
    		// Finne ut antall spillere
    		// Lagre alle disse på sesjonen
    		// sesjon.setParameter(startet) = true;
    	 	// sesjon.setParameter(rundenr) = 1;
    	
    	// hent jsp (løkke: spillere.navn) (antallSpillere -> hvor mange kolonner på brettet)
    	// sendRedirect(forward)
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if sesjon.getParameter(rundenr) <= 18:
			// if rundenr == 7:
				// beregne summen til nå
			// if rundenr == 8:
				// finn ut om de skal ha bonus
			// if rundenr == 18:
				// beregn totalsum
		
		
			// if (trillCount < 3) 
				// Finne ut hvilke terninger som er valgt
				// Trille på nytt de som ikke ble valgt
				// oppdatere terningkast
				// trillCount++
			// if (trillCount == 3)
				// yatzy.runde(rundenr, terningkast);
				// rundenr++;
				// sesjon.setParameter(rundenr) = rundenr;
				// beregn poengsummen for spilleren
				// sett poengsummen inn i databasen
				// neste spiller sin tur
		// if sesjon.getParameter(rundenr) > 18:
			// finne ut hvilken spiller som har høyest totalSum
			// sesjon.setParameter(vinner) = vinnerSpiller.navn
		
	}

}
