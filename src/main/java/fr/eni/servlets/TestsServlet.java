package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Test;
import fr.eni.services.TestService;

/**
 * Servlet implementation class TestsServlet
 */
@WebServlet("/TestsServlet")
public class TestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestsServlet() {
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
			List<Test> tests = null;
			try {
				tests = TestService.importerListeTests();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("tests", tests);
			RequestDispatcher dispatcher = request.getRequestDispatcher("tests.jsp");
			dispatcher.forward(request, response);
	}
}