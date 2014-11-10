package fi.omapizzeria.sivusto.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Ostoskori;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.TuoteDAO;
import fi.omapizzeria.sivusto.service.PizzaService;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")

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
		request.getRequestDispatcher("menu.jsp").forward(request, response);
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

			
			}
		
			// haetaan ID formista
			
	
			
			
		String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);			
			
		String maara = request.getParameter("lkm");
			int lkm = Integer.parseInt(maara);
		
			
		String klikattuOregano = request.getParameter("oregano"); // oregano valinta checkboxista
		String klikattuValkosipuli = request.getParameter("valkosipuli"); //valkosipuli valinta checkboxista
		
			boolean oregano;
			boolean valkosipuli;
			
		
			
			// tsekataan että onko oregano valittu	
		if (klikattuOregano != null) {
			oregano = true;
			} else {
			oregano = false;
			}
			// tsekataan että onko valkosipuli valittu	
		if (klikattuValkosipuli != null) {
			valkosipuli = true;
			} else {
			valkosipuli = false;
		}
						//haetaan pizzaID:llä pizzan tiedot tietokannasta
		
			
			try {
				
				
				PizzaService pService = new PizzaService();
				Pizza uusiPizza = pService.tuoPizza(id);
				
				kori.lisaaTuote(uusiPizza, lkm, oregano, valkosipuli);
				
			} catch (DAOPoikkeus e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getSession().setAttribute("kori", kori);
			
			response.sendRedirect("/PizzeriaTyyni/menu");
		
		
	
		System.out.println(kori.ostokset());
		} else {
			
		}
		 }
	}
