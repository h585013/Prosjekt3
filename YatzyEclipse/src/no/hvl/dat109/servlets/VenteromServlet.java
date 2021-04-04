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

import no.hvl.dat109.dao.BrukerDAO;
import no.hvl.dat109.spiller.Spiller;

/**
 * Servlet implementation class VenteromServlet
 */
@WebServlet("/VenteromServlet")
public class VenteromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BrukerDAO dao = new BrukerDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Viser spillere
//		List<Spiller> spillere = dao.hentAlle();
		
		
		request.getRequestDispatcher("WEB-INF/jsp/venterom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reload knapp
	
	}

}
