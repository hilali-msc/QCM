package fr.eni.servlets;

import java.io.IOException;
import java.sql.SQLException;
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
import fr.eni.bean.Test;
import fr.eni.bean.Utilisateur;
import fr.eni.services.InscriptionTestService;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		List<Utilisateur> stagiaires = null;
		List<Test> listTest = null;
		try {
			listTest = TestService.importerListeTests();
			stagiaires = UtilisateurService.importerListeStagaire();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("tests", listTest);
		request.setAttribute("stagiaires", stagiaires);
		RequestDispatcher dispatcher = request.getRequestDispatcher("inscriptionTest.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		int id_test = Integer.parseInt(request.getParameter("id_test"));
		Test test = new Test();

		try {
			test = TestService.getTestById(id_test);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		String[] utilisateursId = request.getParameterValues("stagiaires");
		InscriptionTestService service = new InscriptionTestService();
		Inscription_test inscription = new Inscription_test();
		inscription.setId_test(id_test);
		inscription.setNb_incident(0);
		inscription.setPosition_question(0);
		inscription.setTemps_restant(test.getDuree_test());

		String date_inscription = request.getParameter("dateInscription");
		String date_debut = request.getParameter("dateDebut");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			inscription.setDate_inscription(sdf.parse(date_inscription));
			inscription.setDate_debut(sdf.parse(date_debut));
			System.out.println(date_inscription + date_debut);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			for (String id : utilisateursId) {
				inscription.setId_user(Integer.parseInt(id));
				service.insert(inscription);
			}
		} catch (Exception e) {
			doGet(request, response);
		}
		response.sendRedirect("stagiaires");

	}
}
