package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Theme;

public class ThemeDAO {

	
	public static ArrayList<Theme> getThemes(Theme theme) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		ArrayList<Theme> listeThemes = new ArrayList<Theme>();
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("select * "
					+ "from THEME "
					+ "where libelle like '%" +theme.getLibelle()+ "%' ");	
//			rqt.setString(1, test.getNom());
			rs=rqt.executeQuery();
			while (rs.next()){
				theme = new Theme(
									rs.getInt("id_theme"),
									rs.getString("libelle")
						);
				listeThemes.add(theme);				
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeThemes;
	}
	
	public static List<Theme> getThemesParId(Theme theme) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		ArrayList<Theme> listeThemes = new ArrayList<Theme>();
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("select * "
					+ "from THEME "
					+ "where id_theme = ? ");	
			rqt.setInt(1, theme.getId_theme());
			rs=rqt.executeQuery();
			while (rs.next()){
				theme = new Theme(
									rs.getInt("id_theme"),
									rs.getString("libelle")
						);
				listeThemes.add(theme);				
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeThemes;
	}
	
	public static void insert(Theme theme) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("insert into THEME "
					+ "values(?, ?) ");
			rqt.setInt(1, theme.getId_theme());
			rqt.setString(2, theme.getLibelle());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void update(Theme theme) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("update THEME "
					+ "set id_theme  = ?, "
					+ "libelle = ?,");
			rqt.setInt(1, theme.getId_theme());
			rqt.setString(2, theme.getLibelle());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste de promotion : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void delete(Theme theme) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("delete from THEME "
					+ "where id_theme = ? ");
			rqt.setInt(1, theme.getId_theme());
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
