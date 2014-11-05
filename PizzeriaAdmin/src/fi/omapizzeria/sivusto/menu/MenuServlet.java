package fi.omapizzeria.sivusto.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.omapizzeria.admin.dao.PizzaDAO;
import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Ostos;
import fi.omapizzeria.sivusto.bean.Ostoskori;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.service.PizzaService;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/ruokalista")

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	
	
	
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
    

    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// luodaan listat
		List<Pizza> pizza;
		List<Juoma> juoma;

		try {
			// tietokannasta tuotteet listoihin
			PizzaService p = new PizzaService();
			pizza = p.haePizzaLista();
			juoma = p.haeJuomaLista();
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		// listat requestin attribuutiksi
		request.setAttribute("plista", pizza);
		request.setAttribute("jlista", juoma);

		// ohjataan .jsp:lle
		request.getRequestDispatcher("ruokalista.jsp").forward(request, response);
	}
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Ostoskori kori = (Ostoskori) session.getAttribute("kori");
				
		if (request.getParameter("action").equals("add")){
		
			
			if (kori == null) {

                kori = new Ostoskori();
                session.setAttribute("kori", kori);
            }
			
			
		
		
		String syotettyId = request.getParameter("id");
		String syotettyNimi = request.getParameter("nimi");
		String syotettyHinta = request.getParameter("hinta");
		
		int id = Integer.parseInt(syotettyId);
		double pd = Double.parseDouble(syotettyHinta);
		
		Pizza f = new Pizza(id, syotettyNimi, pd);
		
		
	
		
	//	Ostos p = new Ostos(f);
		
		
		try {
			
			kori.lisaaTuote(f);
		
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		session.setAttribute("ostos", f);
		
		response.sendRedirect("/PizzeriaTyyni/ruokalista");
		System.out.println(kori.ostokset());
		} else {
			
		}

	}}
