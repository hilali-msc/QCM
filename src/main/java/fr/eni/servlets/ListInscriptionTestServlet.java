package fr.eni.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Inscription_test;
import fr.eni.bean.Test;
import fr.eni.bean.Utilisateur;
import fr.eni.services.InscriptionTestService;
import fr.eni.services.TestService;
import fr.eni.services.UtilisateurService;

/**
 * Servlet implementation class ListInscriptionTestServlet
 */
@WebServlet("/listInscriptionTest")
public class ListInscriptionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListInscriptionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurService service = new UtilisateurService();
		InscriptionTestService serviceInscription = new InscriptionTestService();
		String login = request.getUserPrincipal().getName();
		Utilisateur user = null;
		List<Inscription_test> listInscription = null;
		List<Inscription_test> newListInscription = new ArrayList<Inscription_test>();
		try {
			user = service.getStagiairesByLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			listInscription = serviceInscription.getInscriptionTestByUser(user.getId_user());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Inscription_test inscris : listInscription){
			Test unTest = null;
			try {
				unTest = TestService.getTestById(inscris.getId_inscription());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inscris.setLibelleTest(unTest.getNom());
			newListInscription.add(inscris);
		}
		
		request.setAttribute("inscriptions", newListInscription);
		RequestDispatcher dispatcher = request.getRequestDispatcher("inscriptions.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
