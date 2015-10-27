package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Test;
import fr.eni.bean.Theme;
import fr.eni.services.TestService;
import fr.eni.services.ThemeService;

/**
 * Servlet implementation class AjouterTestServlet
 */
@WebServlet("/AjouterTestServlet")
public class AjouterTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterTestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		List<Theme> listTheme = null;
		try {
			listTheme = ThemeService.getListThemes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("promotions", listTheme);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutTest.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}		
		TestService service = new TestService();
		Test test = new Test();
		test.setNom(request.getParameter("nom"));
		test.setDuree_test(Integer.parseInt(request.getParameter("duree_test")));
		test.setSeuil_en_cours(Integer.parseInt(request.getParameter("seuil_en_cours")));
		test.setSeuil_acquis(Integer.parseInt(request.getParameter("seuil_acquis")));
		try {
			service.insert(test);
			response.sendRedirect("tests");
		} catch (Exception e) {
			doGet(request, response);
		}
	}
}