package fi.omapizzeria.sivusto.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fi.omapizzeria.sivusto.bean.WebUser;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.WebUserDAO;

/**
 * Servlet implementation class SisaankirjautumisServlet
 */
@WebServlet("/kirjaudu")
public class SisaankirjautumisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SisaankirjautumisServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			// haetaan käyttäjä tietokannasta
			WebUserDAO dao = new WebUserDAO();
			WebUser kayttajaKannasta = dao.hae(username);
			
			boolean validiKayttaja = kayttajaKannasta.vertaaSalasanaa(password);
			if (validiKayttaja) {
				request.getSession().setAttribute(
						SiteServlet.SESSION_ATTR_WEBUSER, kayttajaKannasta);
				response.sendRedirect("admin");
			} else {
				request.setAttribute("error", "ä FUG YOU :DDDDDD ");
				request.setAttribute("prev_login_username", username);
				request.getRequestDispatcher(SiteServlet.FRONT_PAGE).forward(request, response);
			}
		} catch (DAOPoikkeus e) {
			e.printStackTrace();
			throw new ServletException("Tietokantavirhe", e);
		} catch (NoSuchAlgorithmException e) {
			throw new ServletException("Salausalgoritmia ei löydy.", e);
		}
	}
}