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
import fr.eni.bean.Reponse;
import fr.eni.bean.Theme;
import fr.eni.services.QuestionService;
import fr.eni.services.ReponseService;
import fr.eni.services.ThemeService;

/**
 * Servlet implementation class ModifierReponseServlet
 */
@WebServlet("/ModifierReponseServlet")
public class ModifierReponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Reponse uneReponse = null;
		Question uneQuestion = null;
		List<Question> questions = null;
		int idReponse = Integer.parseInt(request.getParameter("id"));				

		try {
			uneReponse = ReponseService.getReponse(idReponse);
			uneQuestion = QuestionService.getQuestion(uneReponse.getId_question());
			questions = QuestionService.getQuestions(uneQuestion.getId_theme());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("reponse", uneReponse);		
		request.setAttribute("questions", questions);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/modifierReponse.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Reponse uneReponse = new Reponse();
		uneReponse.setEst_correct(Boolean.parseBoolean(request.getParameter("estCorrect")));
		uneReponse.setId_question(Integer.parseInt(request.getParameter("question")));
		uneReponse.setId_reponse(Integer.parseInt(request.getParameter("idReponse")));
		uneReponse.setLibelle(request.getParameter("libelle"));
		
		try {
			ReponseService.update(uneReponse);
			response.sendRedirect("themeQuestRep");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
