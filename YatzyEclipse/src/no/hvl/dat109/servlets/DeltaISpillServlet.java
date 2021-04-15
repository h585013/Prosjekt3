
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
import no.hvl.dat109.registreringOgLogin.Bruker;
import no.hvl.dat109.dao.SpillDAO;
import no.hvl.dat109.spill.Spill;


/**
 * Servlet implementation class DeltaISpillServlet
 */
@WebServlet("/DeltaISpillServlet")
public class DeltaISpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	@EJB
	BrukerDAO brukerdao = new BrukerDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/deltaispill.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession();
		
		
	// int spillID = SpillDAO.finnSpill()
	
		
	}

	}
	
	

