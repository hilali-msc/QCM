package fr.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Theme;

public class ThemeDAO {
	
	public static List<Theme> importerListeThemeTest(int id) throws SQLException {

		Theme theme = new Theme();
		List<Theme> listeTheme = new ArrayList<Theme>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT theme.libelle, theme.id_theme "
				+ "FROM theme "
				+ "inner join section on section.id_theme = theme.id_theme "
				+ "WHERE section.id_test = ? ;";

		cnx = ConnectionDB.getConnection();
		ps = cnx.prepareStatement(req);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		while (rs.next()) {
			
			theme.setId_theme(rs.getInt("id_theme"));
			theme.setLibelle(rs.getString("libelle"));
			listeTheme.add(theme);
		}

		return listeTheme;

	}	
	
	public static List<Theme> importerListeThemeRestant(int id) throws SQLException {

		Theme theme = new Theme();
		List<Theme> listeTheme = new ArrayList<Theme>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT theme.libelle, theme.id_theme "
				+ "FROM theme "
				+ "WHERE id_theme NOT IN (SELECT theme.id_theme "
				+ "FROM theme "
				+ "inner join section on section.id_theme = theme.id_theme "
				+ "WHERE section.id_test = ?)";

		cnx = ConnectionDB.getConnection();
		ps = cnx.prepareStatement(req);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		while (rs.next()) {
			
			theme.setId_theme(rs.getInt("id_theme"));
			theme.setLibelle(rs.getString("libelle"));
			listeTheme.add(theme);
		}

		return listeTheme;

	}	
	
	
	public static List<Theme> importerListeTheme() throws SQLException {

		Theme theme = new Theme();
		List<Theme> listeTheme = new ArrayList<Theme>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String req = "SELECT theme.libelle, theme.id_theme "
				+ "FROM theme ";

		cnx = ConnectionDB.getConnection();
		ps = cnx.prepareStatement(req);
		rs = ps.executeQuery();

		while (rs.next()) {
			
			theme.setId_theme(rs.getInt("id_theme"));
			theme.setLibelle(rs.getString("libelle"));
			listeTheme.add(theme);
		}

		return listeTheme;

	}	
	
	public static Theme getThemesParId(Theme theme) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		Theme unTheme = new Theme();
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("select * "
					+ "from THEME "
					+ "where id_theme = ? ");	
			
			rqt.setInt(1, theme.getId_theme());
			rs=rqt.executeQuery();
			
			if(rs.next()){				
				unTheme.setId_theme(rs.getInt("id_theme"));
				unTheme.setLibelle(rs.getString("libelle"));						
				return theme;				
			}
			
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de récupération d'un thème : ");
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return unTheme;
	}
	
	public static void insert(Theme theme) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnectionDB.getConnection();
			rqt=cnx.prepareStatement("insert into THEME(libelle) "
					+ "values(?) ");
			rqt.setString(1, theme.getLibelle());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete d'insertion d'un thème : ");
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
			rqt=cnx.prepareStatement("UPDATE THEME "
					+ "SET libelle = ? WHERE id_theme = ?");			
			rqt.setString(1, theme.getLibelle());
			rqt.setInt(2, theme.getId_theme());
			rqt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de mise à jour d'une thème : ");
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
			System.out.println("Erreur lors de l'execution de la requete de suppression d'un thème : ");
			e.printStackTrace();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
}
