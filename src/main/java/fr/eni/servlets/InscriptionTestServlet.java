package fr.eni.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Inscription_test;
import fr.eni.bean.Promotion;
import fr.eni.bean.Test;
import fr.eni.bean.Utilisateur;
import fr.eni.services.InscriptionTestService;
import fr.eni.services.PromotionService;
import fr.eni.services.TestService;
import fr.eni.services.UtilisateurService;

/**
 * Servlet implementation class InscriptionTestServlet
 */
@WebServlet("/inscriptionsTests")
public class InscriptionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		List<Test> listTest = null;
		List<Promotion> listPromo = null;
		List<Utilisateur> listUtilisateur= null;
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			listTest = TestService.importerListeTests();
			listPromo = PromotionService.importerListe();
			listUtilisateur =  UtilisateurService.importerListeStagiaireParIdPromo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stagiaires", listUtilisateur);
		request.setAttribute("promos", listPromo);
		request.setAttribute("tests", listTest);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutStagiaire.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		InscriptionTestService service = new InscriptionTestService();
		Inscription_test inscription = new Inscription_test();
		inscription.setId_user(Integer.parseInt(request.getParameter("id_user")));
		inscription.setId_test(Integer.parseInt(request.getParameter("id_test")));
		inscription.setNb_incident(0);
		inscription.setPosition_question(0);
		inscription.setTemps_restant(Integer.parseInt(request.getParameter("duree_test")));
		
		String date_inscription = request.getParameter("date_inscription");
		String date_debut = request.getParameter("date_debut");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
		try {
			inscription.setDate_inscription(sdf.parse(date_inscription));
			inscription.setDate_debut(sdf.parse(date_debut));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			service.insert(inscription);
			response.sendRedirect("stagiaires");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
