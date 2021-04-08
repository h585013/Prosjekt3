package VenteromServlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOogKlasse.Spiller;
import DAOogKlasse.SpillerDAO;

@WebServlet("/VenteromServlet")
public class VenteromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SpillerDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<Spiller> spillere = dao.hentAlle();
		request.setAttribute("spillerListe", spillere);
		request.getRequestDispatcher("WEB-INF/jsp/venterom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}