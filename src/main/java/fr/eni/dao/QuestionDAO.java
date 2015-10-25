package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Question;

public class QuestionDAO {

	public static ArrayList<Question> getQuestions(Question question)
			throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Question> listeQuestions = new ArrayList<Question>();

		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("select * " + "from QUESTION "
					+ "where id_theme = ? ");
			rqt.setInt(1, question.getId_theme());
			rs = rqt.executeQuery();
			while (rs.next()) {
				question = new Question(rs.getInt("id_question"),
						rs.getInt("id_theme"), rs.getString("enonce"),
						rs.getBoolean("est_archive"), rs.getString("url_image"));
				listeQuestions.add(question);
			}
		} catch (SQLException e) {
			System.out
					.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}

		return listeQuestions;
	}

	public static void insert(Question question) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("insert into Question "
					+ "values(?, ?, ?, ?) ");
			rqt.setInt(1, question.getId_theme());
			rqt.setString(2, question.getEnonce());
			rqt.setBoolean(3, question.isEst_archive());
			rqt.setString(4, question.getUrl_image());
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

	public static void update(Question question) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("update QUESTION " + "set id_theme  = ?, "
					+ "enonce = ?, " + "est_archive = ? " + "url_image = ? ");
			rqt.setInt(1, question.getId_theme());
			rqt.setString(2, question.getEnonce());
			rqt.setBoolean(3, question.isEst_archive());
			rqt.setString(4, question.getUrl_image());
			rqt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}

	public static void delete(Question question) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("delete from QUESTION "
					+ "where id_theme = ? "
					+ "and id_question = ?");
			rqt.setInt(1, question.getId_theme());
			rqt.setInt(1, question.getId_question());
			rqt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}

}
