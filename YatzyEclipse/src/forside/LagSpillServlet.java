package no.hvl.dat109.forside;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vilde
 * Servlet implementation class LagSpillServlet
 * 
 */
@WebServlet("/LagSpillServlet")
public class LagSpillServlet extends HttpServlet {
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
				
		String spillNavnEscaped= StringEscapeUtils.escapeHtml4(request.getParameter("spillNavn"));
		Spill spill= new Spill(spillNavn,brukernavn);
		if (sesjon != null) {
			sesjon.invalidate();
		}
		sesjon = request.getSession(true);		
		
	}	

}
