package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Promotion;
import fr.eni.bean.Theme;
import fr.eni.bean.Utilisateur;
import fr.eni.services.PromotionService;
import fr.eni.services.ThemeService;
import fr.eni.services.UtilisateurService;

/**
 * Servlet implementation class AjouterThemeServlet
 */
@WebServlet("/AjouterThemeServlet")
public class AjouterThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/ajoutTheme.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}

		Theme unTheme = new Theme();
		unTheme.setLibelle(request.getParameter("libelle"));
		
		try {
			ThemeService.insert(unTheme);
			response.sendRedirect("themeQuestRep");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
