package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Promotion;
import fr.eni.bean.Utilisateur;
import fr.eni.services.PromotionService;
import fr.eni.services.UtilisateurService;

/**
 * Servlet implementation class AjouterStagiaireServket
 */

public class AjouterStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterStagiaireServlet() {
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
		List<Promotion> listPromo = null;
		try {
			listPromo = PromotionService.importerListe();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("promotions", listPromo);
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
		UtilisateurService service = new UtilisateurService();
		Utilisateur stagiaire = new Utilisateur();
		stagiaire.setNom(request.getParameter("nom"));
		stagiaire.setPrenom(request.getParameter("prenom"));
		stagiaire.setEmail(request.getParameter("email"));
		stagiaire.setId_promo(Integer.parseInt(request.getParameter("promo")));
		stagiaire.setId_statut(1);
		stagiaire.setEst_archive(false);
		stagiaire.setLogin(stagiaire.getPrenom().substring(0, 1).toLowerCase()+stagiaire.getNom().toLowerCase());
		stagiaire.setPassword(stagiaire.getPrenom().substring(0, 3).toLowerCase());
		
		try {
			service.insert(stagiaire);
			response.sendRedirect("stagiaires");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
