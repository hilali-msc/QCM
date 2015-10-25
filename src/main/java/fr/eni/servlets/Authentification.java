package fr.eni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Utilisateur;
import fr.eni.services.UtilisateurService;

/**
 * Servlet implementation class Authentification
 */
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response){
		
		Utilisateur perso = null;
		String identifiant = null;
		String mdp = null;				

		identifiant = request.getParameter("login");
		mdp = request.getParameter("password");
		perso = UtilisateurService.authenctification(identifiant, mdp);
		
		// Redirige l'utilisateur suivant la réussite de son authentification
		if(perso != null && perso.getId_user() > 0){
							
			// TODO : Spécialiser l'utilisateur suivant son idStatut
			// TODO : Ajoute à la session la personne authentifier
			switch (perso.getId_statut()) {
			case 1:
				redirection(request, response, "/StagiaireAccueil");
				break;
				
			case 2:
				redirection(request, response, "/FormateurAccueil");
				break;
	
			default:
				redirection(request, response, "authentification.jsp");
				break;
			}	
			
		} else {
			redirection(request, response, "authentification.jsp");
		}
		
	}
	
	private void redirection(HttpServletRequest request, HttpServletResponse response, String chemin){
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher(chemin);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			System.out.println("ServletException - Impossible de redirigé vers la page d'accueil : ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException - Impossible de redirigé vers la page d'accueil : ");
			e.printStackTrace();
		}
		
	}
	
}
