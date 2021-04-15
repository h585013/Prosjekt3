package no.hvl.dat109.registreringOgLogin;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.dao.BrukerDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(name="RegistrationServlet", urlPatterns = { "/registrer" }) //name = "ForsideServlet", urlPatterns = { "/forside" }
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB
	private BrukerDAO dao;
	

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.getRequestDispatcher("WEB-INF/jsp/registrer.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brukernavn = request.getParameter("brukernavn");
		String passord = request.getParameter("passord");
		String passordRepeat = request.getParameter("passordRepeat");
		String epost = request.getParameter("epost");
		
		BrukerRequest brukerRequest = new BrukerRequest(brukernavn, epost, passord, passordRepeat);
		
		
		if(!BrukerRequestService.matcherPassord(brukerRequest.getPassord(), brukerRequest.getPassordRepeat())) {
			response.setStatus(HttpServletResponse.SC_CONFLICT); 
			response.sendRedirect("/registrer");
		}else {

			String salt = PassordHjelper.genererTilfeldigSalt();
			String hashetPassord= PassordHjelper.hashMedSalt(brukerRequest.getPassord(), salt);
			
			Bruker nyBruker = new Bruker(
					brukerRequest.getBrukernavn(), 
					brukerRequest.getEmail(), hashetPassord, salt, null, 0);
			
			if(dao.leggTilBruker(nyBruker)){
				//Om det gikk greit :)
				request.getSession().setAttribute("brukernavn", brukerRequest.getBrukernavn());
				response.setStatus(HttpServletResponse.SC_CREATED); 
				
				response.sendRedirect("/Prosjekt3/Forside");
			}else {
				// Om det ikke gikk greit :(
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				response.sendRedirect("/Prosjekt3/registrer");
				
			}
		}
		

		
		
		
		
	}

}
