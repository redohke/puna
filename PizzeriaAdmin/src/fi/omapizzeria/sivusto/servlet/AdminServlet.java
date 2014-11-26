package fi.omapizzeria.sivusto.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.TuoteDAO;
import fi.omapizzeria.sivusto.dao.AdminDAO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


				// pizzat listaan
				ArrayList<Pizza> pizzat;
				ArrayList<Tayte> taytteet;

				try {
					// tietokannasta pizzat
					AdminDAO dao = new AdminDAO();
					pizzat = dao.haePizzatAdmin();
				
				

				
					// tietokannasta taytteet
					TuoteDAO tDao = new TuoteDAO();
					taytteet = tDao.haeTaytelista();
				} catch (DAOPoikkeus e) {
					throw new ServletException(e);
				}

				// lista requestin attribuutiksi
				request.setAttribute("plista", pizzat);
				
				request.setAttribute("tayte", taytteet);

				// forwardi .jsp:lle
				request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		// jos tuleva parametri action on del ajetaan poisto else lisäys
		
		 if (request.getParameter("action").equals("del")){
			
			// id formista			
			String syotettyId = request.getParameter("id");
			String nimi = null;
			double d = 0;
			
			// int stringistä intiksi
			int id = Integer.parseInt(syotettyId);
						
			// infot olioksi
			Pizza p = new Pizza(id, nimi, d, false, false );
			
			try {
				// uus pizzadao
				AdminDAO dao = new AdminDAO();
				// olio poistometodiin
				dao.poistaPizza(p);
			} catch (DAOPoikkeus e) {
				throw new ServletException(e);
			}
			
			// pitsa poistettu -> redirect removed parameterillä
			response.sendRedirect("admin?removed=true");
			
		}else{
		
		
		// infot formista
		String syotettyNimi = request.getParameter("pizza");

		String syotettyHinta = request.getParameter("hinta");
		int id = 0;
		
		// hinta stringistä doubleksi
		double d = Double.parseDouble(syotettyHinta);
		
		// infot olioksi
		Pizza p = new Pizza(id, syotettyNimi, d, false, false);
		
		//täytteet formista
		String syotettyTayte = request.getParameter("tayte1");
		String syotettyTayte2 = request.getParameter("tayte2");
		String syotettyTayte3 = request.getParameter("tayte3");		
		String syotettyTayte4 = request.getParameter("tayte4");
		
		//taytteet olioksi
		Tayte t = new Tayte(id, syotettyTayte);
		Tayte t2 = new Tayte(id, syotettyTayte2);
		Tayte t3 = new Tayte(id, syotettyTayte3);
		Tayte t4 = new Tayte(id, syotettyTayte4);
		
		try {
			// uus pizzadao
			AdminDAO dao = new AdminDAO();
			// olio lisaysmetodiin
			dao.lisaaPizza(p);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		// pitsa lisätty -> redirect added parameterillä
		response.sendRedirect("admin?added=true");
		
		}
		
		
	
	}

}
