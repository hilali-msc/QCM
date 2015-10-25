package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Section;

public class SectionDAO {

	public static ArrayList<Section> getSections(Section section)
			throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> listeSections = new ArrayList<Section>();
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("select * " + "from SECTION "
					+ "where id_test = ? " + "and id_theme =? ");
			rqt.setInt(1, section.getId_test());
			rqt.setInt(2, section.getId_theme());
			rs = rqt.executeQuery();
		} catch (SQLException e) {
			System.out
					.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				section = new Section(rs.getInt("id_test"),
						rs.getInt("id_theme"), rs.getInt("nb_question"));
				listeSections.add(section);
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

		return listeSections;
	}

	public static void insert(Section section) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("insert into SECTION "
					+ "values(?, ?, ?) ");
			rqt.setInt(1, section.getId_test());
			rqt.setInt(2, section.getId_theme());
			rqt.setInt(3, section.getNb_question());
			rqt.executeUpdate();
		}catch (SQLException e) {
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

	public static void update(Section section) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("update SECTION " + "set id_test  = ?, "
					+ "id_theme = ?, " + "nb_question = ? ");
			rqt.setInt(1, section.getId_test());
			rqt.setInt(2, section.getId_theme());
			rqt.setInt(3, section.getNb_question());
			rqt.executeUpdate();
		}catch (SQLException e) {
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

	public static void delete(Section section) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("delete from SECTION "
					+ "where id_test = ? " + "and id_theme = ?");
			rqt.setInt(1, section.getId_test());
			rqt.setInt(2, section.getId_theme());
			rqt.executeUpdate();
		}catch (SQLException e) {
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
