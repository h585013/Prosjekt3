	package no.hvl.dat109.registreringOgLogin;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.dao.BrukerDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brukernavn = request.getReader().readLine();
		String passord = request.getReader().readLine();

		Bruker b = dao.finnBruker(brukernavn);
		if (b == null) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		} else {
			
			
			if (PassordHjelper.validerMedSalt(passord, b.getSalt(), b.getPassord())) {

				request.getSession().setAttribute("brukernavn", b.getBrukernavn());
				response.setStatus(HttpServletResponse.SC_OK);

			} else {

				response.setStatus(HttpServletResponse.SC_CONFLICT);
			}
		}

	}

}