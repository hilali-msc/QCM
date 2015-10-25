package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Select_Question;

public class SelectQuestionDAO {

	public static ArrayList<Select_Question> getSelectQuestions(
			Select_Question selectQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Select_Question> listeSelectQuestion = new ArrayList<Select_Question>();
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("select * " + "from SELECT_QUESTION "
					+ "where id_question = ? " + "and id_inscription =? ");
			rqt.setInt(1, selectQuestion.getId_question());
			rqt.setInt(2, selectQuestion.getId_inscription());
			rs = rqt.executeQuery();
		} catch (SQLException e) {
			System.out
					.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				selectQuestion = new Select_Question(
						rs.getInt("id_test"),
						rs.getInt("id_question"), 
						rs.getInt("id_user"),
						rs.getInt("id_inscription"),
						rs.getBoolean("est_repondu"),
						rs.getBoolean("est_marquer")
						);
				listeSelectQuestion.add(selectQuestion);
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

		return listeSelectQuestion;
	}

	public static void insert(Select_Question selectQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("insert into SELECT_QUESTION "
					+ "values(?, ?, ?, ?, ?, ?) ");
			rqt.setInt(1, selectQuestion.getId_test());
			rqt.setInt(2, selectQuestion.getId_question());
			rqt.setInt(3, selectQuestion.getId_user());
			rqt.setInt(4, selectQuestion.getId_inscription());
			rqt.setBoolean(5, selectQuestion.isEst_repondu());
			rqt.setBoolean(6, selectQuestion.isEst_marque());
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

	public static void update(Select_Question selectQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("update SELECT_QUESTION " 
					+ "set id_test  = ?, "
					+ "id_question = ?, "
					+ "id_user = ?, "
					+ "id_inscription = ?, "
					+ "est_repondu = ?, "
					+ "est_marque = ? ");
			rqt.setInt(1, selectQuestion.getId_test());
			rqt.setInt(2, selectQuestion.getId_question());
			rqt.setInt(3, selectQuestion.getId_user());
			rqt.setInt(4, selectQuestion.getId_inscription());
			rqt.setBoolean(5, selectQuestion.isEst_repondu());
			rqt.setBoolean(6, selectQuestion.isEst_marque());
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

	public static void delete(Select_Question selectQuestion) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("delete from SELECT_QUESTION "
					+ "where id_question = ? " + "and id_inscription = ?");
			rqt.setInt(1, selectQuestion.getId_question());
			rqt.setInt(2, selectQuestion.getId_inscription());
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
