package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.dao.ResultatDAO;
import no.hvl.dat109.dao.SpillDAO;
import no.hvl.dat109.main.Resultat;
import no.hvl.dat109.main.Runde;
import no.hvl.dat109.registreringOgLogin.Bruker;
import no.hvl.dat109.spill.Spill;

/**
 * Implementasjon av å faktisk spille spillet
 * 
 * @author - Anne, Thea, Magnus 
 */
@WebServlet("/YatzySpill")
public class YatzySpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SpillDAO spilldao = new SpillDAO();
	
	@EJB
	private ResultatDAO resdao = new ResultatDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Henter ut sesjonen:
		HttpSession sesjon = request.getSession();

		// Første gang vi starter spillet:
		if (sesjon.getAttribute("runde") == null) {
			// Henter ut spillID som er sendt fra venterom
			int spillID = (int) sesjon.getAttribute("spillID");
			
			// SpillDAO for å finne spillet
			Spill s = spilldao.finnSpill(spillID);
			
			// Hente ut alle spillerene --> liste
			List<Bruker> spillere = (List<Bruker>) sesjon.getAttribute("spillerListe");
			
			Runde r = new Runde(spillere, spillID);
			
			sesjon.setAttribute("runde", r);
		} else {
			Runde runde = (Runde) sesjon.getAttribute("runde");
			if (runde.getVinner() != null) {
				List<Resultat> resultater = runde.getResultat();
				for (Resultat res : resultater)
					resdao.sendData(res);
			}
		}
		
		
		request.getRequestDispatcher("WEB-INF/jsp/game.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession sesjon = request.getSession();
		Runde r = (Runde) sesjon.getAttribute("runde");
		r.spillRunde(request.getParameterNames());
		
		sesjon.setAttribute("runde", r);

		response.sendRedirect("/Prosjekt3/YatzySpill");

	}

}
