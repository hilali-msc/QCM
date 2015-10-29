package fr.eni.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Inscription_test;
import fr.eni.bean.Question;
import fr.eni.bean.Section;
import fr.eni.bean.Select_Question;
import fr.eni.bean.Test;
import fr.eni.services.InscriptionTestService;
import fr.eni.services.SectionService;
import fr.eni.services.TestService;

/**
 * Servlet implementation class PasserTestServlet
 */
@WebServlet("/passerTest")
public class PasserTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int idInscription = Integer.parseInt(request.getParameter("id"));
			Inscription_test inscription = InscriptionTestService.getInscriptionTestById(idInscription);
			Test test = TestService.getTestById(inscription.getId_test());
			ArrayList<Section> sections = SectionService.getSections(new Section(inscription.getId_test(), test.getId_test(), 0));
			
			// TODO Choisi un nombre aléatoire de question pour chaque thème
			ArrayList<Select_Question> questions = new ArrayList<Select_Question>();
			for(Section uneSection : sections){
				
			}
			
			// TODO Mettre la liste des questions en sessions
			
			// TODO Lancer la page de passage de test avec la première question
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Tant que c'est pas finis et que la liste de question n'est pas finis...
			// TODO Enregister la réponse à la question
			// TODO Passer à la question suivante
		// Sinon si la liste est finis...
			// TODO Afficher la page de résumé
		// Sinon...
			// TODO Afficher la page de résultat
		
	}

}
