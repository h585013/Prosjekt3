package forside;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import no.hvl.dat109.dao.SpillDAO;
import no.hvl.dat109.spill.Spill;

/**
 * @author vilde
 * Servlet implementation class LagSpillServlet
 * 
 */
@WebServlet("/LagSpillServlet")
public class LagSpillServlet extends HttpServlet {
	@EJB
	SpillDAO spilldao= new SpillDAO();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * 
     */
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession();
		//Vet ikke hvordan emma lagrer bruker, men tenker sesjonen?-vilde
		String brukernavn= (String) sesjon.getAttribute("brukernavn");
		
		String spillNavn= request.getParameter("spillNavn");
		//må etterhvert lage en validator for å sjekke spillnavn lengde osv. 		
		String spillNavnEscaped= StringEscapeUtils.escapeHtml4(request.getParameter("spillNavn"));
		Spill spill= new Spill(spillNavnEscaped,brukernavn);
		spilldao.leggTilSpill(spill);
		if (sesjon != null) {
			sesjon.invalidate();
		}
		sesjon = request.getSession(true);		
		sesjon.setAttribute("spillnavn", spillNavnEscaped);
		//
	}	

}
