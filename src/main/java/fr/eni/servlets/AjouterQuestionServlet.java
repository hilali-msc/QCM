package fr.eni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Question;
import fr.eni.bean.Theme;
import fr.eni.services.QuestionService;
import fr.eni.services.ThemeService;

/**
 * Servlet implementation class AjouterQuestionServlet
 */

public class AjouterQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Theme unTheme = new Theme();		
		int idTheme = Integer.parseInt(request.getParameter("idTheme"));
		
		try {
			unTheme = ThemeService.getThemesParId(idTheme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("theme", unTheme);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/ajouterQuestion.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Question uneQuestion = new Question();
		uneQuestion.setEnonce(request.getParameter("enonce"));
		uneQuestion.setEst_archive(false);
		uneQuestion.setId_theme(Integer.parseInt(request.getParameter("idTheme")));
		uneQuestion.setUrl_image(request.getParameter("urlImage"));		
		
		try {
			QuestionService.insert(uneQuestion);
			response.sendRedirect("themeQuestRep");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
