package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Question;
import fr.eni.dao.QuestionDAO;



public class QuestionService {
	
	public static ArrayList<Question> getQuestions(int idTheme) throws SQLException {

		try {
			ArrayList<Question> listQuestions = new ArrayList<Question>();		
			listQuestions = QuestionDAO.getQuestions(idTheme);
			return listQuestions;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static Question getQuestion(int idQuestion) throws SQLException {

		try {
			Question uneQuestion = new Question();		
			uneQuestion = QuestionDAO.getQuestion(idQuestion);
			return uneQuestion;
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
