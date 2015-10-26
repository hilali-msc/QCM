package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Test;

public class TestDAO {

	
	public static ArrayList<Test> getTests(Test test) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		ArrayList<Test> listeTests = new ArrayList<Test>();
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("select * "
					+ "from TEST "
					+ "where nom like '%" +test.getNom()+ "%' ");	
//			rqt.setString(1, test.getNom());
			rs=rqt.executeQuery();
			while (rs.next()){
				test = new Test(
									rs.getInt("id_test"),
									rs.getString("nom"),
									rs.getInt("duree_test"),
									rs.getInt("seuil_en_cours"),
									rs.getInt("seuil_acquis")
						);
				listeTests.add(test);				
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeTests;
	}
	
	public static List<Test> importerListeTest() throws SQLException {

		List<Test> listeTests = new ArrayList<Test>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM test WHERE id_statut = 1 ;";

		cnx = ConnectionDB.getConnection();
		ps = cnx.prepareStatement(req);
		rs = ps.executeQuery();

		while (rs.next()) {
			Test test = new Test();
			test.setId_test(rs.getInt("id_user"));
			test.setNom(rs.getString("nom"));
			test.setDuree_test(rs.getInt("duree_test"));
			test.setSeuil_en_cours(rs.getInt("seuil_en_cours"));
			test.setSeuil_acquis(rs.getInt("seuil_acquis"));
			
			listeTests.add(test);
		}

		return listeTests;

	}
	
	public static void insert(Test test) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("insert into TEST "
					+ "values(?, ?, ?, ?) ");
			rqt.setString(1, test.getNom());
			rqt.setInt(2, test.getDuree_test());
			rqt.setInt(3, test.getSeuil_en_cours());
			rqt.setInt(4, test.getSeuil_acquis());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void update(Test test) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("update TEST "
					+ "set nom  = ?, "
					+ "duree_test = ?,"
					+ "seuil_en_cours = ?,"
					+ "seuil_acquis = ? ");
			rqt.setString(1, test.getNom());
			rqt.setInt(2, test.getDuree_test());
			rqt.setInt(3, test.getSeuil_en_cours());
			rqt.setInt(4, test.getSeuil_acquis());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void delete(Test test) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("delete from TEST "
					+ "where nom = ? ");
			rqt.setString(1, test.getNom());
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