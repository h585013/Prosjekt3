package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.dao.BrukerDAO;
import no.hvl.dat109.registreringOgLogin.Bruker;
import no.hvl.dat109.dao.SpillDAO;
import no.hvl.dat109.spill.Spill;

/**
 * Servlet implementation class DeltaISpillServlet
 */
@WebServlet("/DeltaISpill")
public class DeltaISpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	BrukerDAO brukerdao = new BrukerDAO();

	@EJB
	private SpillDAO spilldao = new SpillDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Spill> ledigeSpill = spilldao.hentAlle();

		request.setAttribute("ledigeSpill", ledigeSpill);
		request.getRequestDispatcher("WEB-INF/jsp/deltaispill.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession();

		Enumeration<String> params = request.getParameterNames();
		if (params.hasMoreElements()) {
			int spillID = Integer.parseInt(params.nextElement());
			Bruker b = brukerdao.finnBruker((String) sesjon.getAttribute("brukernavn"));
			Spill spill = spilldao.finnSpill(spillID);
			brukerdao.leggTilSpill(b.getBrukernavn(), spill);
			sesjon.setAttribute("spillID", spill.getSpillID());

			response.sendRedirect("/Prosjekt3/Venterom");
		} else {
			response.sendRedirect("/Prosjekt3/DeltaISpill");
		}

	}

}
