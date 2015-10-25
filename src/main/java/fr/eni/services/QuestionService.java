package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Question;
import fr.eni.dao.QuestionDAO;



public class QuestionService {
	
	public static ArrayList<Question> getQuestions(Question question) throws SQLException {

		try {
			ArrayList<Question> listQuestions = new ArrayList<Question>();		
			listQuestions = QuestionDAO.getQuestions(question);
			return listQuestions;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void insert(Question question) throws SQLException {

		try {
			QuestionDAO.insert(question);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Question question) throws SQLException {

		try {
			QuestionDAO.update(question);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Question question) throws SQLException {

		try {
			QuestionDAO.delete(question);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}
