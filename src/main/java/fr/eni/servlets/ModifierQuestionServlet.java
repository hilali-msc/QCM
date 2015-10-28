package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Question;
import fr.eni.bean.Theme;
import fr.eni.services.QuestionService;
import fr.eni.services.ThemeService;

/**
 * Servlet implementation class ModifierQuestionServlet
 */
@WebServlet("/ModifierQuestionServlet")
public class ModifierQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Question uneQuestion = null;
		List<Theme> themes = null;
		int idQuestion = Integer.parseInt(request.getParameter("id"));				

		try {
			uneQuestion = QuestionService.getQuestion(idQuestion);
			themes = ThemeService.getListThemes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("themes", themes);		
		request.setAttribute("question", uneQuestion);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/modifierQuestion.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Question uneQuestion = new Question();
		uneQuestion.setEnonce(request.getParameter("enonce"));
		uneQuestion.setId_theme(Integer.parseInt(request.getParameter("theme")));
		uneQuestion.setId_question(Integer.parseInt(request.getParameter("idQuestion")));
		uneQuestion.setUrl_image(request.getParameter("urlImage"));
		uneQuestion.setEst_archive(false);
		
		try {
			QuestionService.update(uneQuestion);
			response.sendRedirect("themeQuestRep");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
