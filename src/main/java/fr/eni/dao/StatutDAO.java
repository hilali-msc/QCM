package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import fr.eni.bean.Statut;

public class StatutDAO {

	public static Vector<Statut> importerListe() throws SQLException{
		
		Vector<Statut> listeStatut = new Vector<Statut>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT * FROM STATUT ;";		
		
		try {
			cnx = ConnectionDB.getConnection();	
			ps = cnx.prepareStatement(req);	
			rs = ps.executeQuery();	

			while(rs.next()){
				Statut monStatut = new Statut();
				monStatut.setId_statut(rs.getInt("id_statut"));
				monStatut.setLibelle(rs.getString("libelle"));
				listeStatut.add(monStatut);
			}
			
		} catch (Exception e) {
			System.out.println("Erreur lors du cast de la liste de statut : ");
			e.printStackTrace();
			
		}finally{
			if (rs!=null) rs.close();
			if (ps!=null) ps.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeStatut;
		
	}
	
	public static void insert(Statut statut) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("insert into STATUT "
					+ "values(?, ?) ");
			rqt.setInt(1, statut.getId_statut());
			rqt.setString(2, statut.getLibelle());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void update(Statut statut) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("update STATUT "
					+ "set id_statut  = ?, "
					+ "libelle = ? ");
			rqt.setInt(1, statut.getId_statut());
			rqt.setString(2, statut.getLibelle());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void delete(Statut statut) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("delete from STATUT "
					+ "where id_statut = ? ");
			rqt.setInt(1, statut.getId_statut());
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
