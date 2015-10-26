package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Test;
import fr.eni.dao.TestDAO;

public class TestService {

	public static ArrayList<Test> getTests(Test test) throws SQLException {

		try {
			ArrayList<Test> Listtest = new ArrayList<Test>();		
			Listtest = TestDAO.getTests(test);
			return Listtest;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static List<Test> importerListeTests() throws SQLException {

		try {
			return TestDAO.importerListeTest();
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void insert(Test test) throws SQLException {

		try {
			TestDAO.insert(test);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Test test) throws SQLException {

		try {
			TestDAO.update(test);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Test test) throws SQLException {

		try {
			TestDAO.delete(test);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}