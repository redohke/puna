package fi.omapizzeria.sivusto.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import fi.omapizzeria.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.bean.Juoma;
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
		// luodaan listat
		List<Tuote> tuote;
		List<Juoma> juoma;

		try {
			// tietokannasta tuotteet listoihin
			TuoteDAO pDao = new TuoteDAO();
			tuote = pDao.haeTuote();
			TuoteDAO jDao = new TuoteDAO();
			juoma = jDao.haeJuoma();
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		// listat requestin attribuutiksi
		request.setAttribute("plista", tuote);
		request.setAttribute("jlista", juoma);

		// ohjataan .jsp:lle
		request.getRequestDispatcher("ruokalista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
