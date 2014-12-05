package fi.omapizzeria.sivusto.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.WebUser;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/admin")
public class SiteServlet extends HttpServlet {

	public static final String FRONT_PAGE = "etusivu.jsp";
	private static final String INSIDE_PAGE = "list.jsp";

	public static final String SESSION_ATTR_WEBUSER = "kayttajatiedot";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SiteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//otetaan käyttäjätiedot sessiosta
		WebUser user = (WebUser) request.getSession().getAttribute(SESSION_ATTR_WEBUSER);

		if (user == null) //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(FRONT_PAGE).forward(request, response);
		else // mikäli käyttäjätiedot löytyvät, päästetään sisään
			request.getRequestDispatcher(INSIDE_PAGE).forward(request, response);

	}
}