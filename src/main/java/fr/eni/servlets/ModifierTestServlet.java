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

import fr.eni.bean.Section;
import fr.eni.bean.Test;
import fr.eni.bean.Theme;
import fr.eni.services.SectionService;
import fr.eni.services.TestService;
import fr.eni.services.ThemeService;

/**
 * Servlet implementation class ModifierStagiaireServlet
 */
@WebServlet("/ModifierTestServlet")
public class ModifierTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		Test test = null;
		List<Theme> listThemeParTest = null;
		List<Theme>listThemeRestant = null;
		
		try {
			test = TestService.getTestById(id);
			listThemeParTest = ThemeService.getThemesTest(id);
			listThemeRestant = ThemeService.importerListeThemeRestant(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("test", test);
		request.setAttribute("themesParTests", listThemeParTest);
		request.setAttribute("themesRestants", listThemeRestant);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("modifTest.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		
		String typeTraitement = request.getParameter("typeTraitement");
		int idTest = Integer.parseInt(request.getParameter("id_test"));
		
		switch (typeTraitement) {
		case "add":			
			try {
				int idTheme = Integer.parseInt(request.getParameter("themes"));
				int nbQuestion = Integer.parseInt(request.getParameter("nbQuestion"));
				
				if(idTheme > 0 && nbQuestion > 0){
					Section uneSection = new Section(idTest, idTheme, nbQuestion);
					SectionService.insert(uneSection);
				}
				
			} catch (SQLException e1) {
				System.out.println("Erreur d'ajout d'une section (modification d'un test");
				e1.printStackTrace();
				
			} finally {
				response.sendRedirect("modifierTest?id=" + String.valueOf(idTest));
			}
			break;
			
		case "edit":
			TestService service = new TestService();
			Test test = new Test();
			
			test.setId_test(idTest);
			test.setNom(request.getParameter("nom"));
			test.setDuree_test(Integer.parseInt(request.getParameter("duree_test")));
			test.setSeuil_en_cours(Integer.parseInt(request.getParameter("seuil_en_cours")));
			test.setSeuil_acquis(Integer.parseInt(request.getParameter("seuil_acquis")));
			
			try {
				service.update(test);
				response.sendRedirect("tests");
			} catch (Exception e) {
				doGet(request, response);
			}
			break;
			
		case "delete":
			try {
				int idTheme = Integer.parseInt(request.getParameter("themes"));
				
				if(idTheme > 0){
					Section uneSection = new Section(idTest, idTheme, 0);
					SectionService.delete(uneSection);
				}				
				
			} catch (SQLException e1) {
				System.out.println("Erreur de suppr. d'une section (modification d'un test");
				e1.printStackTrace();
				
			} finally {
				response.sendRedirect("modifierTest?id=" + String.valueOf(idTest));
			}
			break;
		}
		
	}

}
