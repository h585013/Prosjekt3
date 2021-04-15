package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.openejb.util.CollectionsUtil;

import no.hvl.dat109.dao.BrukerDAO;
import no.hvl.dat109.dao.SpillDAO;
import no.hvl.dat109.registreringOgLogin.Bruker;


/**
 * Servlet implementation class VenteromServlet
 */
@WebServlet("/Venterom")
public class VenteromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BrukerDAO dao = new BrukerDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = (int) request.getAttribute("spillID");
		List<Bruker> spiller = dao.hentAlle();
		List<Bruker> spillerListe = spiller.stream().filter(x -> x.getSpillID().getSpillID() == id).collect(Collectors.toList());
		request.setAttribute("spillerListe", spillerListe);	
		request.getRequestDispatcher("WEB-INF/jsp/venterom.jsp").forward(request, response);
	}

}
