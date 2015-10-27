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
 * Servlet implementation class DetailTestServlet
 */
@WebServlet("/DetailTestServlet")
public class DetailTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailTestServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		List<Test> tests = null;
		List<Theme> listThemeParTest = null;
		try {
			tests = TestService.importerListeTests();
			listThemeParTest = ThemeService.getThemesTest(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("themesParTests", listThemeParTest);
		request.setAttribute("tests", tests);
		RequestDispatcher dispatcher = request.getRequestDispatcher("tests.jsp");
		dispatcher.forward(request, response);
	}
}