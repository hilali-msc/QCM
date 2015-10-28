package fr.eni.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ThemeQuestRepServlet
 */
@WebServlet(description = "Affichage des thèmes avec ses questions comprenant ses réponses", urlPatterns = { "/ThemeQuestRepServlet" })
public class ThemeQuestRepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
			
		List<Theme> themes = null;
		List<Question> questions = new ArrayList<Question>();
		List<Reponse> reponses = new ArrayList<Reponse>();		
		int idTheme = 0;
		Theme themeSelectionne = new Theme(0, "Thèmes");		
		int idQuestion = 0;
		Question questionSelectionne = new Question(0, 0, "Questions", false, "");
		
		try {
			idTheme = Integer.parseInt(request.getParameter("idTheme"));	
			themeSelectionne = ThemeService.getThemesParId(idTheme);
		} catch (Exception e) {
			themeSelectionne = new Theme(0, "Thèmes");		
		}
		
		try {
			idQuestion = Integer.parseInt(request.getParameter("idQuestion"));	
			questionSelectionne = QuestionService.getQuestion(idQuestion);
		} catch (Exception e) {
			questionSelectionne = new Question(0, 0, "Questions", false, "");
		}
		
		try {
			themes = ThemeService.getListThemes();
			if(themes != null && themes.size() > 1){
				questions = QuestionService.getQuestions(idTheme);
				if(questions != null && questions.size() > 1){
					reponses = ReponseService.getReponses(idQuestion);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("themes", themes);
		request.setAttribute("questions", questions);
		request.setAttribute("reponses", reponses);
		request.setAttribute("themeSelect", themeSelectionne);
		request.setAttribute("questionSelect", questionSelectionne);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/themeQuestRep.jsp");
		dispatcher.forward(request, response);
	}

}
