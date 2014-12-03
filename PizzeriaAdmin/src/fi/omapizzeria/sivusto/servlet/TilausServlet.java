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
import fi.omapizzeria.sivusto.bean.Tilaus;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.TilausDAO;

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
		Tilaus tilaus = (Tilaus) session.getAttribute("tilaus");
		
        //Validointi muuttujat
        boolean etuValidointi = false;
        boolean sukuValidointi = false;
        boolean yrValidointi = false;
        boolean puhValidointi = false;
        boolean emValidointi = false;
        boolean osValidointi = false;
        boolean pnValidointi = false;
        boolean kaValidointi = false;
		
		
		String etunimi = request.getParameter("enimi");
		String sukunimi = request.getParameter("snimi");
		String yritys = request.getParameter("yr");
		String puh = request.getParameter("puh");
		String email = request.getParameter("email");
		String osoite = request.getParameter("os");
		String pnro = request.getParameter("pnro");
		String kaupunki = request.getParameter("kaup");
		String toimitus = request.getParameter("toimitus");
		String maksu = request.getParameter("maksu");
		double kokohinta = kori.getTilauksenHinta();
		
		

		Asiakas asiakas = new Asiakas(etunimi, sukunimi, yritys, puh, 
						email, osoite, pnro, kaupunki);
		
		
		System.out.println("asiakas on: " + asiakas);
		tilaus = new Tilaus(asiakas, kori, kokohinta);
		

		
		System.out.println(tilaus);
		
		request.getSession().setAttribute("toimitus", toimitus);
		request.getSession().setAttribute("maksu", maksu);
		request.getSession().setAttribute("tilaus", tilaus);
		
		if (request.getParameter("action").equals("summary")) {
			
            //Haetut tiedot verrataan validointi ehtojen kanssa ja muuttujat muutetaan trueksi, jos ehto täyttyy.
            if (etunimi.length()>0 && etunimi.length()<30){
                    etuValidointi = true;
            }
            if (sukunimi.length()>0 && sukunimi.length()<30){
                    sukuValidointi = true;
            }
            if (yritys.length()<30){
                    yrValidointi = true;
            }
            if (puh.length()>0 && puh.length()<15){
                    puhValidointi = true;
            }
            if (email.length()>0 && email.length()<50){
                    emValidointi = true;
            }
            if (osoite.length()>0 && osoite.length()<50){
                    osValidointi = true;
            }
            if (pnro.matches("\\d*") && pnro.length()>0 && pnro.length()==5){
                    pnValidointi = true;
            }
            if (kaupunki.length()>0 && kaupunki.length()<50){
                    kaValidointi = true;
            }
           
            if (etuValidointi == false ||
                            sukuValidointi == false ||
                            yrValidointi == false ||
                            puhValidointi == false ||
                            emValidointi == false ||
                            osValidointi == false ||
                            pnValidointi == false ||
                            kaValidointi == false){
                           
                            //Kaataa ohjelman ennen kuin tietoja lisätään olioon,
                            //  jos formi ei täsmää java ehtojen kanssa.
                            try {
                                    session.invalidate();
                                   
                                    } catch (Exception e) {
                                            e.printStackTrace();
                                    }
                            response.sendRedirect("menu");
            }
			
			
								
			response.sendRedirect("/PizzeriaTyyni/yhteenveto.jsp");
			System.out.println(tilaus);
			
		}
		
		if (request.getParameter("action").equals("valmis")) {

			
			try {
				//uusi tilausdao			
				TilausDAO tDAO = new TilausDAO();			
				tDAO.lisaaTilaus(tilaus);				
			} catch (DAOPoikkeus e) {
				throw new ServletException(e);
			}
			
			
			//tilaus on lisätty -->
			
			
			
			
			session.invalidate();
				

			response.sendRedirect("tilausvahvistus.jsp");
					
		}
	}

}
