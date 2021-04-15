package no.hvl.dat109.registreringOgLogin;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import no.hvl.dat109.dao.BrukerDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registrer")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB
	private BrukerDAO dao;
	
    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/registrer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestData = request.getReader().lines().collect(Collectors.joining());
		
		ObjectMapper objectMapper = new ObjectMapper();
		BrukerRequest brukerRequest = objectMapper.readValue(requestData, BrukerRequest.class);
		
		if(!BrukerRequestService.matcherPassord(brukerRequest.getPassord(), brukerRequest.getPassordRepeat())) {
			response.setStatus(HttpServletResponse.SC_CONFLICT); 
		}else {

			String salt = PassordHjelper.genererTilfeldigSalt();
			String hashetPassord= PassordHjelper.hashMedSalt(brukerRequest.getPassord(), salt);
			
			Bruker nyBruker = new Bruker(
					brukerRequest.getBrukernavn(), 
					brukerRequest.getEmail(), hashetPassord, PassordHjelper.genererTilfeldigSalt(), null, 0);
			
			if(dao.leggTilBruker(nyBruker)){
				//Om det gikk greit :)
				request.getSession().setAttribute("brukernavn", brukerRequest.getBrukernavn());
				response.setStatus(HttpServletResponse.SC_CREATED); 
			}else {
				// Om det ikke gikk greit :(
				response.setStatus(HttpServletResponse.SC_CONFLICT); 
			}
		}
		

		
		
		
		
	}

}
