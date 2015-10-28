package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Utilisateur;

public class UtilisateurDAO {

	public Utilisateur getStagiaires(String login, String password) {

		Utilisateur perso = new Utilisateur();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM UTILISATEUR WHERE login = ? AND password = ? where statut = 1;";

		try {
			cnx = ConnectionDB.getConnection();
		} catch (SQLException e2) {
			System.out.println("Erreur lors de la r�cup�ration de la connection (authentifiaction) : ");
			e2.printStackTrace();
		}

		try {
			ps = cnx.prepareStatement(req);
			ps.setString(1, login);
			ps.setString(2, password);
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la pr�paration de la requete d'authentification : ");
			e1.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete d'authentification : ");
			e.printStackTrace();
		}

		try {
			if (rs.next()) {
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
			System.out.println("Erreur lors du cast de la personne � authentifi� : ");
			e.printStackTrace();
		}

		return perso;
	}

	public static List<Utilisateur> importerListeStagiaire() throws SQLException {

		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM utilisateur WHERE id_statut = 1 AND est_archive = 0;";

		cnx = ConnectionDB.getConnection();
		ps = cnx.prepareStatement(req);
		rs = ps.executeQuery();

		while (rs.next()) {
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

		return listeUtilisateur;

	}

	public static List<Utilisateur> importerListeStagiaireParIdPromo(int id) throws SQLException {

		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM utilisateur WHERE id_promo = ? ;";

		cnx = ConnectionDB.getConnection();
		ps = cnx.prepareStatement(req);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		while (rs.next()) {
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

		return listeUtilisateur;

	}
	
	
	public static Utilisateur rechercheParId(int id) {

		Utilisateur perso = new Utilisateur();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM UTILISATEUR WHERE id_user = ? ;";

		try {
			cnx = ConnectionDB.getConnection();
			ps = cnx.prepareStatement(req);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
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

	public static void insert(Utilisateur utilisateur) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement(
					"insert into UTILISATEUR (`nom`, `prenom`, `id_promo`, `id_statut`, `est_archive`, `password`, `login`, `email`)"
							+ "values(?, ?, ?, ?, ?, ?, ?, ?) ");
			rqt.setString(1, utilisateur.getNom());
			rqt.setString(2, utilisateur.getPrenom());
			rqt.setInt(3, utilisateur.getId_promo());
			rqt.setInt(4, utilisateur.getId_statut());
			rqt.setBoolean(5, utilisateur.getEst_archive());
			rqt.setString(6, utilisateur.getPassword());
			rqt.setString(7, utilisateur.getLogin());
			rqt.setString(8, utilisateur.getEmail());

			rqt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}

	public static void delete(Utilisateur utilisateur) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("update UTILISATEUR "
					+ "set est_archive = ? "
					+ "where id_user = ? ");
			rqt.setBoolean(1, utilisateur.getEst_archive());
			rqt.setInt(2, utilisateur.getId_user());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}
	
	
	public static void update(Utilisateur utilisateur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("update UTILISATEUR "
					+ "set nom  = ?, "
					+ "prenom = ?, "
					+ "id_promo = ?, "
					+ "id_statut = ?, "
					+ "est_archive = ?,"
					+ "password = ?, "
					+ "login = ?, "
					+ "email = ? "
					+ "where id_user = ?");
			rqt.setString(1, utilisateur.getNom());
			rqt.setString(2, utilisateur.getPrenom());
			rqt.setInt(3, utilisateur.getId_promo());
			rqt.setInt(4, utilisateur.getId_statut());
			rqt.setBoolean(5, utilisateur.getEst_archive());
			rqt.setString(6, utilisateur.getPassword());
			rqt.setString(7, utilisateur.getLogin());
			rqt.setString(8, utilisateur.getEmail());
			rqt.setInt(9, utilisateur.getId_user());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
}
