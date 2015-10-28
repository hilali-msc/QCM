package fr.eni.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Section;
import fr.eni.services.SectionService;

/**
 * Servlet implementation class AjouterThemeTestServlet
 */
@WebServlet("/ajoutThemeTest")
public class AjouterThemeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterThemeTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("2")) {
			response.sendRedirect("/");
		}
		Section section = new Section();
		section.setId_test(Integer.parseInt(request.getParameter("id_test")));
		section.setId_theme(Integer.parseInt(request.getParameter("id_theme")));
		section.setNb_question(Integer.parseInt(request.getParameter("nb_questions")));
		try {
			SectionService.insert(section);
		} catch (Exception e) {
			response.sendRedirect("modifierTest");
		}
	}

}
