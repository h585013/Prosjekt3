package no.hvl.dat109.databaseEmmaTest;

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


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestData = request.getReader().lines().collect(Collectors.joining());

		ObjectMapper objectMapper = new ObjectMapper();
		Bruker brukerRegistrering = objectMapper.readValue(requestData, Bruker.class);
		
		
		if(dao.leggTilBruker(brukerRegistrering)){
			//Om det gikk greit :)
			request.getSession().setAttribute("brukernavn", brukerRegistrering.getBrukernavn());
			response.setStatus(HttpServletResponse.SC_CREATED); 
		}else {
			// Om det ikke gikk greit :(
			response.setStatus(HttpServletResponse.SC_CONFLICT); 
		}

		
		
		
		
	}

}
