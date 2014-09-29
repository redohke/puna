package fi.omapizzeria.sivusto.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fi.omapizzeria.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.bean.Tuote;
import fi.omapizzeria.sivusto.dao.TuoteDAO;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/lista")
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
		
		List<Tuote> tuote;

		try {
			// tietokannasta pizzat
			TuoteDAO pDao = new TuoteDAO();
			tuote = pDao.haeTuote();
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}

		// lista requestin attribuutiksi
		request.setAttribute("plista", tuote);

		// forwardi .jsp:lle
		request.getRequestDispatcher("list2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
