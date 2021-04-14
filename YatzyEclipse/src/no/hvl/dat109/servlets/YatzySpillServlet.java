package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.dao.SpillDAO;
import no.hvl.dat109.main.Runde;
import no.hvl.dat109.registreringOgLogin.Bruker;
import no.hvl.dat109.spill.Spill;

/**
 * Implementasjon av å faktisk spille spillet
 * 
 * @author - Anne, Thea, Magnus 
 */
@WebServlet("/game")
public class YatzySpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<Integer> scoreHittil = new ArrayList<Integer>();
	private SpillDAO spilldao = new SpillDAO();

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
			List<Bruker> spillere = s.getBrukere();
			
			Runde r = new Runde(spillere);
			sesjon.setAttribute("runde", r);
		}

		// hent jsp (løkke: spillere.navn) (antallSpillere -> hvor mange kolonner på
		// brettet)
		// sendRedirect(forward)
		request.getRequestDispatcher("WEB-INF/game.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession sesjon = request.getSession();
		Runde r = (Runde) sesjon.getAttribute("runde");
		int s = r.spillRunde(scoreHittil, request.getParameterNames());
		scoreHittil.add(s);
		System.out.println("scoreHittil: " + scoreHittil.toString());
		
		sesjon.setAttribute("runde", r);


		response.sendRedirect("/game");

	}

}
