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
 * Servlet implementation class AjouterTestServlet
 */
@WebServlet("/AjouterTestServlet")
public class AjouterTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterTestServlet() {
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
		List<Theme> listTheme = null;
		try {
			listTheme = ThemeService.getListThemes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("themes", listTheme);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutTest.jsp");
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
		String page = request.getParameter("page");

		if (page.equals("1")) {
			Test test = new Test();
			test.setNom(request.getParameter("nom"));
			test.setDuree_test(Integer.parseInt(request.getParameter("duree_test")));
			test.setSeuil_en_cours(Integer.parseInt(request.getParameter("seuil_en_cours")));
			test.setSeuil_acquis(Integer.parseInt(request.getParameter("seuil_acquis")));
			test.setEst_archive(false);
			TestService service = new TestService();
		Integer testId = null;
			try {
				testId = service.insert(test);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] themesIds = request.getParameterValues("themes");
			List<Theme> themes = new ArrayList<Theme>();
			
			if(themesIds != null){
			for (String id : themesIds) {
				try {
					themes.add(ThemeService.getThemesParId(Integer.parseInt(id)));
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("idtest", testId);
			request.setAttribute("themes", themes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutTest2.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("tests");
		}
		} else if (page.equals("2")) {
		
			Integer testId = Integer.parseInt(request.getParameter("idtest"));
			String[] themesIds = request.getParameterValues("themesids");
			
			for (int i =0; i<themesIds.length ; i++) {
					Section section = new Section();
					section.setId_test(testId);
					section.setId_theme(Integer.parseInt(request.getParameter(
							new String("theme"+ String.valueOf(i+1)))));
					section.setNb_question(Integer.parseInt(request.getParameter(
							new String("nb"+String.valueOf(i+1)))));
					try {
						SectionService.insert(section);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			
			
			response.sendRedirect("tests");
		} else {
			response.sendRedirect("tests");
		}

	}
}