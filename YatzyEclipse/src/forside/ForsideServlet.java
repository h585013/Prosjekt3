package forside;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ForsideServlet
 */
@WebServlet("/Forside")
public class ForsideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/forside.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession();
		String brukernavn= (String) sesjon.getAttribute("brukernavn");
		if (sesjon != null) {
			sesjon.invalidate();
		}
		
		sesjon = request.getSession(true);
		sesjon.setAttribute("brukernavn", brukernavn);
		String handling= request.getParameter("handling");
		if(handling.equals("lagSpill")) {
			response.sendRedirect("/Prosjekt3/LagSpillServlet");
		}
		if(handling.equals("deltaSpill")) {
			response.sendRedirect("/Prosjekt3/DeltaISpill");
		}
		
	}

}
