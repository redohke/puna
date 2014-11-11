package fi.omapizzeria.sivusto.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.omapizzeria.sivusto.bean.Asiakas;
import fi.omapizzeria.sivusto.bean.Ostoskori;

import fi.omapizzeria.sivusto.bean.Tilausrivi;

/**
 * Servlet implementation class TilausServlet
 */
@WebServlet("/tilaus")
public class TilausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TilausServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Ostoskori kori = (Ostoskori) session.getAttribute("kori");
		Tilausrivi tilaus = (Tilausrivi) session.getAttribute("tilaus");
		
		if (request.getParameter("action").equals("summary")) {
			
			try {				
				//haetaan kamat formista
				String etunimi = request.getParameter("enimi");
				String sukunimi = request.getParameter("snimi");
				String yritys = request.getParameter("yr");
				String puh = request.getParameter("puh");
				String email = request.getParameter("email");
				String osoite = request.getParameter("os");
				String pnro = request.getParameter("pnro");
				String kaupunki = request.getParameter("kaup");
				
				Asiakas asiakas = new Asiakas(etunimi, sukunimi, yritys, puh, 
						email, osoite, pnro, kaupunki);
				
				double kokohinta = 0;

				tilaus = new Tilausrivi(asiakas, kori, kokohinta);

			} catch (Exception e) {
				e.printStackTrace();
			}

			request.getSession().setAttribute("tilaus", tilaus);
			response.sendRedirect("/PizzeriaTyyni/yhteenveto.jsp");
			System.out.println(tilaus);
			
		}
	}

}
