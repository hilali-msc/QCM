//package fr.eni.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Vector;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//
//import fr.eni.bean.Promotion;
//import fr.eni.bean.Statut;
//import fr.eni.bean.Utilisateur;
//import fr.eni.services.PromotionService;
//import fr.eni.services.StatutService;
//import fr.eni.services.UtilisateurService;
//
///**
// * Servlet implementation class GestionStagiaire
// */
//public class GestionStagiaireServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		traitement(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		traitement(request, response);
//	}
//
//	protected void traitement(HttpServletRequest request, HttpServletResponse response){
//				
//		String typeTraitement = null;
//		typeTraitement = request.getParameter("typeTraitement");		
//					
//		Vector<Promotion> listePromo = PromotionService.importerListe();
//		Vector<Statut> listeStatut = StatutService.importerListe();
//		Vector<Utilisateur> listeStagiaire = UtilisateurService.importerListeStagaire();
//		
//		request.setAttribute("listePromo", listePromo);		
//		request.setAttribute("listeStatut", listeStatut);	
//		request.setAttribute("listeStagiaire", listeStagiaire);	
//		
//		// D�finis les param�tre � renvoyer suivant le traitement chosis
//		if(typeTraitement != null){
//		
//			switch (typeTraitement) {	
//				case "idStagiaire":
//					int idStagiaire = (int) request.getAttribute("idStagiaire");
//					 
//			        PrintWriter out = response.getWriter();
//			        response.setContentType("text/html");
//			        response.setHeader("Cache-control", "no-cache, no-store");
//			        response.setHeader("Pragma", "no-cache");
//			        response.setHeader("Expires", "-1");
//			 
//			        response.setHeader("Access-Control-Allow-Origin", "*");
//			        response.setHeader("Access-Control-Allow-Methods", "POST");
//			        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
//			        response.setHeader("Access-Control-Max-Age", "86400");
//			 
//			        // TODO - Installer JSON
//			        Gson gson = new Gson();
//			        JsonObject myObj = new JsonObject();
//			        Utilisateur user = UtilisateurService.rechercheParId(idStagiaire);
//			 
//			        JsonElement countryObj = gson.toJsonTree(user);
//			        if(user.getNom() == null){
//			            myObj.addProperty("success", false);
//			        }
//			        else {
//			            myObj.addProperty("success", true);
//			        }
//			        myObj.add("stagiaire", user);
//			        out.println(myObj.toString());
//			 
//			        out.close();
//					break;
//			
//				case "ajout":
//					
//					break;
//					
//				case "modification":
//					
//					break;
//					
//				case "suppression":
//					
//					break;
//					
//				default:
//					redirection(request, response);
//					break;
//			}	
//		
//		} else {
//			redirection(request, response);
//		}
//		
//	}
//	
//	private void redirection(HttpServletRequest request, HttpServletResponse response){
//		
//		RequestDispatcher dispatcher = null;
//		dispatcher = request.getRequestDispatcher("/PageGestionStagiaire");
//		
//		try {
//			dispatcher.forward(request, response);
//		} catch (ServletException e) {
//			System.out.println("ServletException - Impossible de redirig� vers la page de gestion d'un stagiaire : ");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("IOException - Impossible de redirig� vers la page de gestion d'un stagiaire : ");
//			e.printStackTrace();
//		}
//		
//	}
//	
//}
