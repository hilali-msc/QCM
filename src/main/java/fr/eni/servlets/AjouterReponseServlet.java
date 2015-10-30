package fr.eni.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Question;
import fr.eni.bean.Reponse;
import fr.eni.services.QuestionService;
import fr.eni.services.ReponseService;

/**
 * Servlet implementation class AjouterReponseServlet
 */
@WebServlet("/AjouterReponseServlet")
public class AjouterReponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Question uneQuestion = new Question();		
		int idQuestion = Integer.parseInt(request.getParameter("idQuestion"));
		
		try {
			uneQuestion = QuestionService.getQuestion(idQuestion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("question", uneQuestion);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/ajouterReponse.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		Reponse uneReponse = new Reponse();
		uneReponse.setLibelle(request.getParameter("libelle"));	
		uneReponse.setEst_correct(Boolean.parseBoolean(request.getParameter("estCorrect")));	
		uneReponse.setId_question(Integer.parseInt(request.getParameter("idQuestion")));
		
		Question question = null;
		
		try {
			question = QuestionService.getQuestion(Integer.parseInt(request.getParameter("idQuestion")));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ReponseService.insert(uneReponse);
			response.sendRedirect("themeQuestRep?idTheme=" + String.valueOf(question.getId_theme()) + "&idQuestion=" + request.getParameter("idQuestion") );
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
