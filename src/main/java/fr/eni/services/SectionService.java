package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Section;
import fr.eni.dao.SectionDAO;


public class SectionService {

	public static ArrayList<Section> getSections(Section section) throws SQLException {

		try {
			ArrayList<Section> listSection = new ArrayList<Section>();		
			listSection = SectionDAO.getSections(section);
			return listSection;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static List<Section> getSectionsById(Section section) throws SQLException {

		try {
			List<Section> listSection = new ArrayList<Section>();		
			listSection = SectionDAO.getSectionsById(section);
			return listSection;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	

	public static void insert(Section section) throws SQLException {

		try {
			SectionDAO.insert(section);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Section section) throws SQLException {

		try {
			SectionDAO.update(section);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Section section) throws SQLException {

		try {
			SectionDAO.delete(section);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
}
