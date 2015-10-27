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
import fr.eni.bean.Utilisateur;
import fr.eni.services.QuestionService;
import fr.eni.services.ReponseService;
import fr.eni.services.ThemeService;
import fr.eni.services.UtilisateurService;

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
		int idQuestion = 0;
		
		try {
			idTheme = (int) request.getAttribute("idTheme");			
		} catch (Exception e) {
			// Continuer...
		}
		
		try {
			idQuestion = (int) request.getAttribute("idQuestion");			
		} catch (Exception e) {
			// Continuer...
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
		request.setAttribute("idTheme", idTheme);
		request.setAttribute("idQuestion", idQuestion);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gestionThemeQuestionReponse/themeQuestRep.jsp");
		dispatcher.forward(request, response);
	}

}
