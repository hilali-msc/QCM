package fr.eni.servlets;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class ModifierStagiaireServlet
 */
@WebServlet("/ModifierTestServlet")
public class ModifierTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		Test test = null;
		List<Theme> listThemeParTest = null;
		List<Theme> listTheme = null;
		try {
			test = TestService.getTestById(id);
			listTheme = ThemeService.getThemesTest(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("test", test);
		request.setAttribute("themesParTests", listThemeParTest);
		request.setAttribute("themes", listTheme);
		RequestDispatcher dispatcher = request.getRequestDispatcher("modifTest.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			service.update(test);
			response.sendRedirect("tests");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
