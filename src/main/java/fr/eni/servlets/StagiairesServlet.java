package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Promotion;
import fr.eni.bean.Utilisateur;
import fr.eni.services.PromotionService;
import fr.eni.services.UtilisateurService;

/**
 * Servlet implementation class StagiairesServlet
 */
public class StagiairesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StagiairesServlet() {
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
			List<Utilisateur> stagiaires = null;
			Promotion promo = null;
			try {
				stagiaires = UtilisateurService.importerListeStagaire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(Utilisateur stagiaire : stagiaires)
			{
				try {
					promo = PromotionService.rechercheParId(stagiaire.getId_user());
					stagiaire.setLibellePromo(promo.getLibelle());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			request.setAttribute("stagiaires", stagiaires);
			RequestDispatcher dispatcher = request.getRequestDispatcher("stagiaires.jsp");
			dispatcher.forward(request, response);
	}
}