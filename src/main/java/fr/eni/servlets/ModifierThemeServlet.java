package fr.eni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Theme;
import fr.eni.services.ThemeService;

/**
 * Servlet implementation class ModifierThemeServlet
 */
@WebServlet("/ModifierThemeServlet")
public class ModifierThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		int idTheme = Integer.parseInt(request.getParameter("id"));
		Theme unTheme = null;

		try {
			unTheme = ThemeService.getThemesParId(idTheme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("theme", unTheme);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/modifierTheme.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Theme unTheme = new Theme();
		unTheme.setLibelle(request.getParameter("libelle"));
		
		try {
			ThemeService.update(unTheme);
			response.sendRedirect("themeQuestRep");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
