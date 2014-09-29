package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.dao.DAOPoikkeus;
import fi.omapizzeria.admin.dao.PizzaDAO;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// katsotaan onko sessiota
		Date aloitusaika = (Date) request.getSession().getAttribute("aaika");

		// jos ei ole sessiota luodaan aika
		if (aloitusaika == null) {
			aloitusaika = new Date();
		}

		// tallennetaan aika sessioksi
		request.getSession().setAttribute("aaika", aloitusaika);

		// pizzat listaan
		List<Pizza> pizzat;

		try {
			// tietokannasta pizzat
			PizzaDAO pDao = new PizzaDAO();
			pizzat = pDao.haePizzat();
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}

		// lista requestin attribuutiksi
		request.setAttribute("plista", pizzat);

		// forwardi .jsp:lle
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// jos tuleva parametri action on del ajetaan poisto else lisäys
		if (request.getParameter("action").equals("del")){
			
			// id formista			
			String syotettyId = request.getParameter("id");
			String nimi = null;
			double d = 0;
			
			// int stringistä intiksi
			int id = Integer.parseInt(syotettyId);
						
			// infot olioksi
			Pizza p = new Pizza(id, nimi, d);
			
			try {
				// uus pizzadao
				PizzaDAO pDao = new PizzaDAO();
				// olio poistometodiin
				pDao.poistaPizza(p);
			} catch (DAOPoikkeus e) {
				throw new ServletException(e);
			}
			
			// pitsa poistettu -> redirect removed parameterillä
			response.sendRedirect("controller?removed=true");
			
		}else {
		
		// infot formista
		String syotettyNimi = request.getParameter("pizza");
		String syotettyHinta = request.getParameter("hinta");
		int id = 0;
		
		// hinta stringistä doubleksi
		double d = Double.parseDouble(syotettyHinta);
		
		// infot olioksi
		Pizza p = new Pizza(id, syotettyNimi, d);

		try {
			// uus pizzadao
			PizzaDAO pDao = new PizzaDAO();
			// olio lisaysmetodiin
			pDao.lisaaPizza(p);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		// pitsa lisätty -> redirect added parameterillä
		response.sendRedirect("controller?added=true");
		}
	}

}
