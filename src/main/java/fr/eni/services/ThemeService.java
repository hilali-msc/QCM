package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Theme;
import fr.eni.dao.ThemeDAO;

public class ThemeService {

	public static ArrayList<Theme> getThemes(Theme theme) throws SQLException {

		try {
			ArrayList<Theme> Listtest = new ArrayList<Theme>();		
			Listtest = ThemeDAO.getThemes(theme);
			return Listtest;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static Theme getThemesParId(Theme theme) throws SQLException {

		try {
			Theme unTheme = new Theme();		
			unTheme = ThemeDAO.getThemesParId(theme);
			return unTheme;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void insert(Theme theme) throws SQLException {

		try {
			ThemeDAO.insert(theme);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Theme theme) throws SQLException {

		try {
			ThemeDAO.update(theme);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Theme theme) throws SQLException {

		try {
			ThemeDAO.delete(theme);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
}
