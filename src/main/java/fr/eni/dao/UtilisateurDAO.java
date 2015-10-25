package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import fr.eni.bean.Utilisateur;

public class UtilisateurDAO {

	public static Utilisateur authentification(String login, String password){		
		
		Utilisateur perso = new Utilisateur();		
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM UTILISATEUR WHERE login = ? AND password = ? ;";		
		
		try {
			cnx = ConnectionDB.getConnection();			
		} catch (SQLException e2) {
			System.out.println("Erreur lors de la récupération de la connection (authentifiaction) : ");
			e2.printStackTrace();
		}		
		
		try {
			ps = cnx.prepareStatement(req);
			ps.setString(1, login);
			ps.setString(2, password);				
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la préparation de la requete d'authentification : ");
			e1.printStackTrace();
		}		
		
		try {
			rs = ps.executeQuery();	
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete d'authentification : ");
			e.printStackTrace();
		}
		
		try {			
			if(rs.next()){
				perso.setId_user(rs.getInt("id_user"));
				perso.setNom(rs.getString("nom"));
				perso.setPrenom(rs.getString("prenom"));
				perso.setId_promo(rs.getInt("id_promo"));
				perso.setId_statut(rs.getInt("id_statut"));
				perso.setEst_archive(rs.getBoolean("est_archive"));
				perso.setPassword(rs.getString("password"));
				perso.setLogin(rs.getString("login"));
				perso.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			System.out.println("Erreur lors du cast de la personne à authentifié : ");
			e.printStackTrace();
		}
						
		return perso;
	}
	
	public static Vector<Utilisateur> importerListeStagiaire(){
		
		Vector<Utilisateur> listeUtilisateur = new Vector<Utilisateur>();		
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM UTILISATEUR WHERE id_statut = 1 ;";		
		
		try {
			cnx = ConnectionDB.getConnection();			
		} catch (SQLException e2) {
			System.out.println("Erreur lors de la récupération de la connection (importerListeStagiaire) : ");
			e2.printStackTrace();
		}		
		
		try {
			ps = cnx.prepareStatement(req);			
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la préparation de la requete de la listede stagiaire : ");
			e1.printStackTrace();
		}		
		
		try {
			rs = ps.executeQuery();	
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de stagiaire : ");
			e.printStackTrace();
		}
		
		try {			
			while(rs.next()){
				Utilisateur perso = new Utilisateur();
				perso.setId_user(rs.getInt("id_user"));
				perso.setNom(rs.getString("nom"));
				perso.setPrenom(rs.getString("prenom"));
				perso.setId_promo(rs.getInt("id_promo"));
				perso.setId_statut(rs.getInt("id_statut"));
				perso.setEst_archive(rs.getBoolean("est_archive"));
				perso.setPassword(rs.getString("password"));
				perso.setLogin(rs.getString("login"));
				perso.setEmail(rs.getString("email"));
				listeUtilisateur.add(perso);
			}
			
		} catch (Exception e) {
			System.out.println("Erreur lors du cast de la liste de stagiaire : ");
			e.printStackTrace();
		}
		
		return listeUtilisateur;
		
	}
	
	public static Utilisateur rechercheParId(int id){		
		
		Utilisateur perso = new Utilisateur();		
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM UTILISATEUR WHERE id_user = ? ;";		
		
		try {
			cnx = ConnectionDB.getConnection();			
		} catch (SQLException e2) {
			System.out.println("Erreur lors de la récupération de la connection (rechercheParIUser) : ");
			e2.printStackTrace();
		}		
		
		try {
			ps = cnx.prepareStatement(req);
			ps.setInt(1, id);			
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la préparation de la requete de recherche d'utilisateur : ");
			e1.printStackTrace();
		}		
		
		try {
			rs = ps.executeQuery();	
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de recherche d'utilisateur : ");
			e.printStackTrace();
		}
		
		try {			
			if(rs.next()){
				perso.setId_user(rs.getInt("id_user"));
				perso.setNom(rs.getString("nom"));
				perso.setPrenom(rs.getString("prenom"));
				perso.setId_promo(rs.getInt("id_promo"));
				perso.setId_statut(rs.getInt("id_statut"));
				perso.setEst_archive(rs.getBoolean("est_archive"));
				perso.setPassword(rs.getString("password"));
				perso.setLogin(rs.getString("login"));
				perso.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			System.out.println("Erreur lors du cast de recherche d'utilisateur : ");
			e.printStackTrace();
		}
						
		return perso;
	}
	
}
