package fr.eni.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Test;
import fr.eni.services.TestService;

/**
 * Servlet implementation class SuppressionTestServlet
 */
@WebServlet("/suppressionTest")
public class SuppressionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionTestServlet() {
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
		TestService service = new TestService();
		Test test = new Test();
		test.setId_test(Integer.parseInt(request.getParameter("id")));
		try {
			service.delete(test);
		} catch (Exception e) {
		}finally {
			response.sendRedirect("tests");
		}
	}


}
