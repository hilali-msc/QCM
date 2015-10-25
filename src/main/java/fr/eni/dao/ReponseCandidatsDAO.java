package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Reponse_Candidats;

public class ReponseCandidatsDAO {

	public static ArrayList<Reponse_Candidats> getReponsesCandidats(
			Reponse_Candidats reponseCandidat) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Reponse_Candidats> listeReponseCandidat = new ArrayList<Reponse_Candidats>();
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("select * " + "from REPONSE_DES_CANDIDATS "
					+ "where id_reponse = ? " 
					+ "and id_question = ? "
					+ "and id_inscription = ? ");
			rqt.setInt(1, reponseCandidat.getId_reponse());
			rqt.setInt(2, reponseCandidat.getId_question());
			rqt.setInt(2, reponseCandidat.getId_inscription());
			rs = rqt.executeQuery();
		} catch (SQLException e) {
			System.out
					.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				reponseCandidat = new Reponse_Candidats(
						rs.getInt("id_reponse"),
						rs.getInt("id_test"), 
						rs.getInt("id_user"),
						rs.getInt("id_question"),
						rs.getInt("id_inscription")
						);
				listeReponseCandidat.add(reponseCandidat);
			}
		} catch (Exception e) {
			System.out
					.println("Erreur lors du cast de la liste de promotion : ");
			e.printStackTrace();
		}

		if (rs != null)
			rs.close();
		if (rqt != null)
			rqt.close();
		if (cnx != null)
			cnx.close();

		return listeReponseCandidat;
	}

	public static void insert(Reponse_Candidats reponseCandidat) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("insert into REPONSE_DES_CANDIDATS "
					+ "values(?, ?, ?, ?, ?) ");
			rqt.setInt(1, reponseCandidat.getId_reponse());
			rqt.setInt(2, reponseCandidat.getId_test());
			rqt.setInt(3, reponseCandidat.getId_user());
			rqt.setInt(4, reponseCandidat.getId_question());
			rqt.setInt(5, reponseCandidat.getId_inscription());
			rqt.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}

	public static void update(Reponse_Candidats reponseCandidat) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("update REPONSE_DES_CANDIDATS " 
					+ "set id_reponse  = ?, "
					+ "id_test = ?, "
					+ "id_user = ?, "
					+ "id_question = ?, "
					+ "id_inscription = ?");
			rqt.setInt(1, reponseCandidat.getId_reponse());
			rqt.setInt(2, reponseCandidat.getId_test());
			rqt.setInt(3, reponseCandidat.getId_user());
			rqt.setInt(4, reponseCandidat.getId_question());
			rqt.setInt(5, reponseCandidat.getId_inscription());
			rqt.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}

	public static void delete(Reponse_Candidats reponseCandidat) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("delete "
					+ "from REPONSE_DES_CANDIDATS "
					+ "where id_reponse = ? "
					+ "and id_question = ? " 
					+ "and id_inscription = ?");
			rqt.setInt(1, reponseCandidat.getId_reponse());
			rqt.setInt(2, reponseCandidat.getId_question());
			rqt.setInt(2, reponseCandidat.getId_inscription());
			rqt.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}
	
}
