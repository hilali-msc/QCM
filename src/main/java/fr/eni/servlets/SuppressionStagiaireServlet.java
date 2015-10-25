package fr.eni.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Utilisateur;
import fr.eni.services.UtilisateurService;

/**
 * Servlet implementation class SuppressionStagiaireServlet
 */
@WebServlet("/SuppressionStagiaireServlet")
public class SuppressionStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionStagiaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		UtilisateurService service = new UtilisateurService();
		Utilisateur stagiaire = new Utilisateur();
		stagiaire.setId_user(Integer.parseInt(request.getParameter("id")));
		try {
			service.delete(stagiaire);
		} catch (Exception e) {
		}finally {
			response.sendRedirect("stagiaires");
		}
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (!request.isUserInRole("2")) {
//			response.sendRedirect("/");
//		}
//		UtilisateurService service = new UtilisateurService();
//		Utilisateur stagiaire = new Utilisateur();
//		stagiaire.setId_promo(Integer.parseInt(request.getParameter("id")));
//		try {
//			service.delete(stagiaire);
//		} catch (Exception e) {
//		}finally {
//			response.sendRedirect("stagiaires");
//		}
//	}

}
