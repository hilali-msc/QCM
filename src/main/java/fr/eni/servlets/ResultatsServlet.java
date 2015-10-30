package fr.eni.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bean.Reponse_Candidats;
import fr.eni.services.ReponseCandidatsService;

/**
 * Servlet implementation class ResultatsServlet
 */
@WebServlet("/ResultatsServlet")
public class ResultatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultatsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_inscription = Integer.parseInt(request.getParameter("id_inscription"));
		ReponseCandidatsService service = new ReponseCandidatsService();
		List<Reponse_Candidats> listReponse = null;
		try {
			listReponse = service.getReponsesByInscription(id_inscription);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int reponseExacte = 0;
		for(Reponse_Candidats reponse : listReponse)
		{
			if (reponse.getReponse().isEst_correct()) {
				reponseExacte++;
			}
		}
		int pourcentage = (reponseExacte/listReponse.size())*100;
		request.setAttribute("pourcentage", pourcentage);
		request.setAttribute("reponses", listReponse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("resultats.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
