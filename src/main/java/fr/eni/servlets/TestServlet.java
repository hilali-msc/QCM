package fr.eni.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Test;
import fr.eni.services.TestService;

/**
 * Servlet implementation class Authentification
 */
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3693582940464144520L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		lister(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		lister(request, response);
	}

	protected void lister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		try {
			Test test = new Test();
			ArrayList<Test> listeTests = (ArrayList<Test>) request.getAttribute("listeTests");
			if (listeTests== null) listeTests=new ArrayList<Test>();
			test.setNom(request.getParameter("nom"));
			listeTests = TestService.getTests(test);
			request.setAttribute("listeTests", listeTests);
			redirection(request, response, "/test/AffichageTest.jsp");
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	private void redirection(HttpServletRequest request,
			HttpServletResponse response, String chemin) {

		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher(chemin);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			System.out
					.println("ServletException - Impossible de redirigé vers la page d'accueil : ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out
					.println("IOException - Impossible de redirigé vers la page d'accueil : ");
			e.printStackTrace();
		}

	}

}