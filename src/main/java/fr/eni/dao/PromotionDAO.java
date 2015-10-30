package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Promotion;

public class PromotionDAO {

	public static List<Promotion> importerListe() throws SQLException {

		List<Promotion> listePromo = new ArrayList<Promotion>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM PROMOTION ;";

		try {
			cnx = ConnectionDB.getConnection();
			ps = cnx.prepareStatement(req);
			rs = ps.executeQuery();
			while (rs.next()) {
				Promotion maPromo = new Promotion();
				maPromo.setId_promo(rs.getInt("id_promo"));
				maPromo.setLibelle(rs.getString("libelle"));
				listePromo.add(maPromo);
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (cnx != null)
				cnx.close();
		}

		return listePromo;
}
	
	public static Promotion rechercheParId(int id) throws SQLException {

		Promotion promo = new Promotion();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM utilisateur u "
				+"inner join promotion p on p.id_promo = u.id_promo "
				+"where id_user = ? ;";

		try {
			cnx = ConnectionDB.getConnection();
			ps = cnx.prepareStatement(req);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				promo.setId_promo(rs.getInt("id_promo"));
				promo.setLibelle(rs.getString("libelle"));
			}

		} catch (Exception e) {
			System.out.println("Erreur lors de l'execution de la requete de recherche d'utilisateur : ");
			e.printStackTrace();
			
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (cnx != null)
				cnx.close();
		}

		return promo;
	}

	public static void insert(Promotion promo) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("insert into PROMOTION " + "values(?, ?) ");
			rqt.setInt(1, promo.getId_promo());
			rqt.setString(2, promo.getLibelle());
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

	public static void update(Promotion promo) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("update PROMOTION " + "set id_promo  = ?, " + "libelle = ? ");
			rqt.setInt(1, promo.getId_promo());
			rqt.setString(2, promo.getLibelle());
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

	public static void delete(Promotion promo) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {
			cnx = ConnectionDB.getConnection();
			rqt = cnx.prepareStatement("delete from PROMOTION " + "where id_promo = ? ");
			rqt.setInt(1, promo.getId_promo());
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
}
